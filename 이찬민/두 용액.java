import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int N;
    static int minMixedSolution;
    static int ansLeft;
    static int ansRight;
    static int[] solutions;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        minMixedSolution = Integer.MAX_VALUE;


        String[] temp = br.readLine().split(" ");
        solutions = new int[N];

        for(int i = 0; i < temp.length;i++) {
            solutions[i] = Integer.parseInt(temp[i]);
        }
        // 오름차순 정렬
        Arrays.sort(solutions);
        // 이분탐색처럼 보이는 투포인터 함수?!!
        binarySearch(0, N-1);

        System.out.println(solutions[ansLeft] + " " + solutions[ansRight]);
    }
    
    static void binarySearch(int a, int b) {
        // 포인터 두개(이분 탐색처럼 배열의 맨 앞과 맨뒤)
        int left = a;
        int right = b;
        
        // 이분탐색과 유사하지만 mid값을 사용x
        while(left < right) {
            // 융합!!!!!!!!!!
            int sum = solutions[left] + solutions[right];
            // 0이랑 가까워지면 값 저장해둠
            if(minMixedSolution > Math.abs(sum)) {
                minMixedSolution = Math.abs(sum);
                ansLeft = left;
                ansRight = right;
            }

            if (sum == 0) {
                minMixedSolution = 0;
                return;
            }
            // 융합된 값이 0보다 작다면 값을 양수쪽으로 올리기위해 left를 하나 뒤로
            if (sum < 0) {
                left++;
            }
            // 융합된 값이 0보다 작다면 값을 음수쪽으로 올리기위해 right를 하나 앞으로
            if (sum > 0) {
                right--;
            }
        }
    }
}
