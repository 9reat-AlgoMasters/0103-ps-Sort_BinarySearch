import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int N, M;
    static int[] arr, target, ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        String[] temp = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(temp[i]);
        }

        M = Integer.parseInt(br.readLine());
        target = new int[M];
        ans = new int[M];
        temp = br.readLine().split(" ");
        for (int i = 0; i < M; i++) {
            target[i] = Integer.parseInt(temp[i]);
        }

        Arrays.sort(arr);

        for (int i = 0; i < M; i++) {
            int val = target[i];
            int start = 0;
            int end = N-1;
            while(start <= end){
                int mid = (start + end) / 2;
                if(val < arr[mid]){
                    end = mid - 1;
                }else if(val > arr[mid]){
                    start = mid + 1;
                }else{
                    ans[i] = 1;
                    break;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i : ans){
            sb.append(i).append('\n');
        }
        System.out.println(sb);
    }
}
