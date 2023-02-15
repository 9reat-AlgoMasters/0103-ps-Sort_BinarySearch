import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int N;
    static int M;
    static int[] cards;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        cards = new int[N];
        String[] temp = br.readLine().split(" ");
        for (int i = 0;i < N; i++) {
            cards[i] = Integer.parseInt(temp[i]);
        }

        Arrays.sort(cards);


        M = Integer.parseInt(br.readLine());
        
        temp = br.readLine().split(" ");
        

        StringBuilder sb = new StringBuilder();

        for(int i=0; i < M; i++) {
            int t = Integer.parseInt(temp[i]);
            int lowerPos = lower_bound(t);
            int upperPos = upper_bound(t);

            int count = upperPos - lowerPos;
            sb.append(count).append(" ");
        }
        System.out.println(sb);
    }

    static int lower_bound(int n) {
        int first = 0;
        int last = N;
        int mid = 0;
        while (first < last) {
            mid = (first + last) / 2;

            if (cards[mid] < n) {
                first = mid + 1;
            }
            if (cards[mid] >= n) {
                last = mid;
            }
        }

        return last;
    }


    static int upper_bound(int n) {
        int first = 0;
        int last = N;
        int mid = 0;
        while (first < last) {
            mid = (first + last) / 2;

            if (cards[mid] <= n) {
                first = mid + 1;
            }
            if (cards[mid] > n) {
                last = mid;
            }

        }
        return last;
    }
}
