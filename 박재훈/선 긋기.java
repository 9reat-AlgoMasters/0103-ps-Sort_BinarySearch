import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Main {
    static int N;
    static ArrayList<int[]> lines = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            int l = Integer.parseInt(input[0]);
            int r = Integer.parseInt(input[1]);
          //두칸짜리 배열을 원소로 가지는 ArrayList에 선의 시작점과 끝점 저장
            lines.add(new int[]{l,r});
        }

      //N이 백만개 => Arrays.sort는 최악의 경우 O(N^2)이라 시간초과 날 때도있음
      //Collections.sort는 최악도 O(nlogn)을 보장
        Collections.sort(lines, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
              //시작점으로 정렬 => 먼저 시작하는 선들을 앞으로
                return o1[0] - o2[0];
            }
        });

        int sum = 0;
      //가장 먼저 시작하는 선의 시작과 끝을 각각 left, right변수 초기값으로 설정
        int left = lines.get(0)[0];
        int right = lines.get(0)[1];
        for (int i = 1; i < N; i++) {
          //그다음 시작하는 선들 탐색
          //시작이 right보다 작거나 같다면 겹침 => 선 확장
          //left는 어차피 정렬해놔서 고정, right를 더 큰 쪽으로 업데이트
            int[] line = lines.get(i);
            if(line[0] <= right){
                right = Math.max(line[1], right);
            }else{
              //시작이 right보다 크면
                //새로운 선이므로 지금껏 계산한 선의 길이는 더해줌, 새로운 시작 끝 설정
                sum += (right - left);
                left = line[0];
                right = line[1];
            }
        }
      //반복문 끝날때 마지막 선의 길이 연산 미진행 상태이므로
        sum += (right - left);

        System.out.println(sum);
    }
}
