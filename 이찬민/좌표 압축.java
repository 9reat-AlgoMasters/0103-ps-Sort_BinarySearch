import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int N;
    static int[] list;
    static int[] list2;
    static int[] result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        list = new int[N]; // 정렬될 배열
        list2 = new int[N]; // 원래 배열
        String[] temp = br.readLine().split(" ");
        for (int i = 0;i < N;i++) {
            list[i] = Integer.parseInt(temp[i]);
            list2[i] = list[i];
        }

        Arrays.sort(list);
        result = new int[N];

        int start = 0;
        result[0] = start++;
        
        // 정렬결과에 0부터 순위 매기기
        // 예제 1의 경우 0 1 2 3 3
        for (int i = 1; i < N; i++) {
            if(list[i] == list[i-1]){
                result[i] = result[i-1];
            } else {
                result[i] = start++;
            }
        }
        
        int[] answer = new int[N];
        
        for(int i =0; i < N; i++){
            //정렬된 list에서 원래 값의 위치 find
            int idx = binarySearch(list, list2[i]);
            answer[i] = result[idx];
        }

        StringBuilder sb = new StringBuilder();
        for(int i =0; i < N; i++){
            sb.append(answer[i]).append(" ");
        }

        System.out.println(sb.toString());
    }

    static int binarySearch(int[] list, int val){
        int start = 0;
        int end = list.length - 1;

        // lower bound
        while(start < end) {
            int mid = (start + end) / 2;

            if (list[mid] < val) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return end;
    }
}
