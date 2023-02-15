import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    static int N;
    static int[][] timeTable;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
      //회의 시작, 끝시간을 Nx2 2차원배열로 저장
        timeTable = new int[N][2];
        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            timeTable[i][0] = Integer.parseInt(input[0]);
            timeTable[i][1] = Integer.parseInt(input[1]);
        }
        Arrays.sort(timeTable, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
              //끝시간 기준으로 정렬 후 끝시간을 다음 회의들의 시작시간과 비교해야함
                if(o1[1] == o2[1]){
                  //끝시간 같으면 시작시간으로 정렬
                  // 시작시간 == 끝시간인 애들 먼저 처리해야함
                        return o1[0] - o2[0];
                }
                return o1[1] - o2[1];
            }
        });

        int cnt = 1;
        //정렬한 상태에서 첫 회의의 끝나는 시간을 변수에 설정
        int enableTime = timeTable[0][1];
        for (int i = 1; i < N; i++) {
          //다음 회의 시작시간이 더 늦어야 회의 가능, 회의 끝시간 업데이트
            if(timeTable[i][0] >= enableTime){
                cnt++;
                enableTime = timeTable[i][1];
            }
        }
        System.out.println(cnt);
    }
}
