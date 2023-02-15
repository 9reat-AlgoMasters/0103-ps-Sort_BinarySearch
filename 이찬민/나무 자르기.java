import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class Main {
    static int N;
    static int M;
    static int[] trees;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = br.readLine().split(" ");
        N = Integer.parseInt(temp[0]);
        M = Integer.parseInt(temp[1]);
        trees = new int[N];

        temp = br.readLine().split(" ");
        int max = -1;
        for (int i = 0; i < temp.length; i++) {
            trees[i] = Integer.parseInt(temp[i]);
            max = Math.max(max, trees[i]);
        }

        System.out.println(binarySearch(0, max));

    }

    static int binarySearch(int min, int max) {
        while(min < max) {
            int mid = (min + max) / 2;
            long sum = 0L;
            
            // 자르는 높이값으로 잘랐을때 얻을수있는 나무토막의 전체 길이를 구함
            for (int i = 0; i < trees.length; i++) {
                int val = trees[i] - mid;
                if(val > 0) {
                    sum += val;
                }
            }

            // M(가져가려고 하는 나무길이)보다 크거나 같은경우 자르는 위치가 낮았다 => 올리자 (upper_bound를 통해 처리)
            if (sum >= M) {
                min = mid + 1;
            } else {
                // M보다작다는건 자르는 위치가 높았다는 뜻 => 낮추자
                max = mid;
            }


        }
        // upperbound 이기때문에 하나 낮춰줌
        return max - 1;
    }
}
