import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q1920 {
    static int N;
    static int M;
    static int[] arr;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        while (M-- >0) {
            int num = Integer.parseInt(st.nextToken());
            sb.append(binarySearch(num) ? 1 : 0).append("\n");
        }
    
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
    
    public static boolean binarySearch(int target) {
        int lo = 0;
        int hi = N;
        int mid;
        
        // while 문을 빠져나왔을 때의 lo 값은 체크가 되기 전임!
        while (lo < hi) {
            mid = (lo + hi) / 2;
            
            if (arr[mid] == target) {
                return true;
            } else if (arr[mid] < target) {
                lo = mid + 1;
            } else {
                hi = mid -1;
            }
        }
        
        return lo < N && arr[lo] == target;
    }
}
