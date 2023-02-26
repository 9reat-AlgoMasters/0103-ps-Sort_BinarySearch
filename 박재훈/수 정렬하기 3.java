import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
    static int N;
    static int[] arr, count, sorted;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        sorted = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        //계수 정렬
        count = new int[10001];
        for (int val : arr) {
            count[val]++;
        }
        for (int i = 1; i < 10000; i++) {
            count[i+1] += count[i];
        }
        for (int i = N-1; i >= 0; i--) {
            int val = arr[i];
            sorted[--count[val]] = val;
        }

        StringBuilder sb = new StringBuilder();
        for(int val : sorted){
            sb.append(val).append('\n');
        }
        System.out.println(sb);
    }
}
