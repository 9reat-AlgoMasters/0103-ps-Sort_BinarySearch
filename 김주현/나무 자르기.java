import java.io.*;
import java.util.StringTokenizer;

public class Q2805 {
    static final int MAX = 1_000_000_000;
    
    static int N;
    static int M;
    static int[] trees;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        trees = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            trees[i] = Integer.parseInt(st.nextToken());
        }
        
        sb.append(binarySearchUb());
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
    
    // mid가 커질수록 가져가는 부분이 작아진다. -> isEnough가 false로 바뀌게 된다.
    // 즉 isEnough가 true가 되는 upperBound를 찾아야 한다.
    public static int binarySearchUb() {
        int lo = 0;
        int hi = MAX;
        int mid;
        
        while (lo < hi) {
            mid = (hi - lo) / 2 + lo;
            
            if (isEnough(mid)) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo-1;
    }
    
    public static boolean isEnough(int height) {
        long total = 0;
        for (int i=0; i<N; i++) {
            total += Math.max(trees[i] - height, 0);
            if (total >= M) {
                return true;
            }
        }
        return false;
    }
}
