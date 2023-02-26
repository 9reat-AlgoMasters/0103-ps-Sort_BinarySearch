import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int N, M;
    static int[] card, target, ans;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        card = new int[N];
        String[] temp = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            card[i] = Integer.parseInt(temp[i]);
        }
        M = Integer.parseInt(br.readLine());
        target = new int[M];
        ans = new int[M];
        temp = br.readLine().split(" ");
        for (int i = 0; i < M; i++) {
            target[i] = Integer.parseInt(temp[i]);
        }

        Arrays.sort(card);

      //이분탐색
        for (int i = 0; i < M; i++) {
            int t = target[i];
            int start = 0 , end = N;
            int first, last;
          //lowerbound
            while(start < end) {
                int mid = (start + end) / 2;
                if(t <= card[mid]){
                    end = mid;
                }else {
                    start = mid + 1;
                }
            }
            first = start;
            start = 0;
            end = N;
          //upperbound
            while(start < end) {
                int mid = (start + end) / 2;
                if(t < card[mid]){
                    end = mid;
                }else {
                    start = mid + 1;
                }
            }
            last = start;

            ans[i] = last - first;
        }
        StringBuilder sb = new StringBuilder();
        for (int val : ans) {
            sb.append(val).append(' ');
        }
        System.out.println(sb);
    }
}
