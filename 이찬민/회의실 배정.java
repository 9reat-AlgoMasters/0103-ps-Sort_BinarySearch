import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int N;
    static int[][] rooms;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        rooms = new int[N][2];
        for(int i = 0;i < N; i++ ){
            String[] temp = br.readLine().split(" ");
            rooms[i][0] = Integer.parseInt(temp[0]);
            rooms[i][1] = Integer.parseInt(temp[1]);
        }
        
        // 끝나는 시간순으로 정렬, 끝나는 시간이 같다면 시작시간을 오름차순으로 정렬
        Arrays.sort(rooms,(o1, o2) -> {
            if (o1[1] == o2[1]){
                return Integer.compare(o1[0], o2[0]);
            }
            return Integer.compare(o1[1], o2[1]);
        });
      
      
        // 회의실 배정의 아이디어는 회의가 가장 빨리 끝나도록 하면 최대한 많은 회의실을 배정받을수있다라는 점
        // 그리디 기법(항상 최적의 해를 준다는 보장은 없지만 이런경우에는 최적의 해를 도출할 수 있다.)
        int cnt = 1;
        int end = rooms[0][1];
        for(int i = 1;i < N; i++ ){
            if (rooms[i][0] >= end) {
                end = rooms[i][1];
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}
