import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int N, M , low, high;
    static int[] trees;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        trees = new int[N];
        M = Integer.parseInt(input[1]);
        input = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            trees[i] = Integer.parseInt(input[i]);
          //나무 높이 중 최댓값 high 찾기
            if(high < trees[i]){
                high = trees[i];
            }
        }
      
      //0부터 high 중 자른 결과 얻는 나무가 M인 수를 찾는 이진탐색
        while(low <= high){
            int mid = (low + high) / 2;
          //얻는 나무 합을 저장할 때 int로 하면 연산 중 오버플로우 발생하는 경우가 생김, long 변수로 선언 
            long sum = 0;
            for (int i = 0; i < N; i++) {
                int val = trees[i] - mid;
                if (val > 0) {
                    sum += trees[i] - mid;
                }
            }
            if(sum == M){
              //결과가 정확히 M이면 mid 값 뱉고 끝
                System.out.println(mid);
                System.exit(0);
            }else if(sum < M){
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
      /*정확히 M인 결과를 찾지 못함
        현재 상태 low>high, 반드시 low-1==high 성립
        가장 최근에 sum > m이었던 mid값을 찾아야 함
        1)마지막 연산 결과 sum < M인 경우
        마지막 연산 전의low - 1 값을 구하면 됨
        low-1 == high 값 출력
        2)마지막 연산 결과 sum > M인 경우
        해당 mid값 == low-1 == high값 출력*/
        System.out.println(high);


    } 
}
            
