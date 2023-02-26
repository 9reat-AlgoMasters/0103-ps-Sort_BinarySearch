import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Q10989 {
    static final int MAX = 10000;

    static int N;
    static int[] count = new int[MAX+1];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
//        StringBuilder sb = new StringBuilder(2*N);
        // count 배열 생성
        for (int i=0; i<N; i++) {
            count[Integer.parseInt(br.readLine())]++;
        }

        for (int i=1; i<=MAX; i++) {
            for (int j=0; j<count[i]; j++) {
                bw.append(String.valueOf(i)).append("\n");
            }
        }

//        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
