import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static int N;
    static List<int[]> lines;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        lines = new ArrayList<>();

        for(int i = 0; i < N; i++) {
            String[] temp = br.readLine().split(" ");
            int a = Integer.parseInt(temp[0]);
            int b = Integer.parseInt(temp[1]);

            lines.add(new int[]{a, b});

        }
        // 시작지점 기준 오름차순 정렬
        lines.sort((o1, o2) -> {
            return o1[0] - o2[0];
        });
        
        // 첫번째 선은 기준으로 start, end를 잡는다
        int end = lines.get(0)[1];
        int start = lines.get(0)[0];
        int sum = 0;
        for(int i  = 1; i < N; i++) {
            // 확인하고 있는 선의 시작점이 현재 내가 알고있는 선의 끝값보다 크다면
            // 선이 끊어졌다는것이기 때문에 현재 까지의 선의 결과를 저장하고 
            // 시작점과 끝점을 바꿔준다.
            if(lines.get(i)[0] > end) {
                sum += (end - start);
                start = lines.get(i)[0];
                end = lines.get(i)[1];
                continue;
            }
            // 만약 내가 알고있는 선의 끝값보다 현재 선의 시작점이 작다면 선이 포함되는 부분이 있거나 포함되는 것이므로 
            // 비교를 통해 끝점을 갱신한다.
            if (lines.get(i)[0] <= end){
                end = Math.max(end, lines.get(i)[1]);
            }

        }
        // 항상 마지막 선까지 다보고 나면 현재만들어진 선을 더해줘야한다(for문에서 더해지지 않음)
        System.out.println(sum + end - start);
    }


}
