import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int N;
    static int[] list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        list = new int[N];
        String[] temp = br.readLine().split(" ");
        for (int i = 0;i < N;i++) {
            list[i] = Integer.parseInt(temp[i]);
        }

        Arrays.sort(list);

        int M = Integer.parseInt(br.readLine());
        temp = br.readLine().split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = 0;i < M;i++) {
            sb.append(binarySearch(Integer.parseInt(temp[i]))).append("\n");
        }

        System.out.println(sb);
    }

    static int binarySearch(int target){
        int start = 0;
        int end = N - 1;
        int mid = 0;
        int answer = 0;

        while(start <= end) {
            mid = (start + end) / 2;

            if (list[mid] == target){
                answer = 1;
                break;
            }
            if (list[mid] < target) {
                start = mid + 1;
            }
            if (list[mid] > target) {
                end = mid - 1;
            }

        }
        return answer;
    }
}
