import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q10816 {
    static final int NOT_EXIST = -1;

    static int N, M;
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
//        System.out.println("정렬된 배열");
//        System.out.println(Arrays.toString(arr));
//        System.out.println();

        M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        while (M-- > 0) {
            int num = Integer.parseInt(st.nextToken());
            sb.append(count(num)).append(" ");
        }



        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    public static int count(int num) {
//        System.out.printf("num : %d\n", num);
//        System.out.printf("[num = %d] ", num);
        int startIdx = binarySearchLb(num);
//        System.out.printf("startIdx : %d ", startIdx);
        int endIdx = binarySearchHb(num);
//        System.out.printf("endIdx : %d\n", endIdx);
        return startIdx == NOT_EXIST ? 0 : endIdx - startIdx + 1;
    }

    // lower bound : target이 처음 나오는 위치
    private static int binarySearchLb(int target) {
        int lo = 0;
        int hi = N;
        int mid;

        while (lo < hi) {
            mid = (lo + hi) / 2;
            /*
            * 1. arr[mid] == target => target 숫자를 찾은 경우
            * - LowerBound 를 찾는 것이 목적이기 때문에 target 값과 같으면 mid를 줄여야 한다.
            * - 즉, arr[mid] > target 인 경우와 처리 방식이 같다.
            * - 하지만 현재의 mid 값이 target 값의 lower bound 인덱스 일 수도 있으므로 hi를 mid-1 이 아닌 mid 로한다.
            * */

            /*
             * 2. arr[mid] < target => 현재 arr[mid] 값이 너무 작기 때문에 키워야 한다.
             * => mid 인덱스가 커질수록 값도 커지기 때문에 mid를 높여야 한다.
             * => lo 를 mid+1로 바꾸자!
             * */

            if (arr[mid] >= target) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }


        /*
        * 3. while 문을 빠져나갔을 때는 lo와 hi가 같아진 상태 => 둘 중 아무거나 반환
        * 이 때 target 값이 배열에 없을 수도 있으므로 그 경우엔 NOT_EXIST 반환
        * 만약, target 수가 현재 배열에 없는 큰 수 라면 arr.length가 반환 되어 OOB 런타임 에러 발생
        * */
        try {
            return arr[lo] == target ? lo : NOT_EXIST;
        } catch (ArrayIndexOutOfBoundsException e) {
            return NOT_EXIST;
        }

    }

    // upper bound : target 을 초과한 처음 위치
    private static int binarySearchHb(int target) {
        int lo = 0;
        int hi = N;
        int mid;

        while (lo < hi) {
            mid = (lo + hi) / 2;

            /*
             * 같으면 ? -> mid를 키워야함 -> lo를 높이자
             * 즉 mid를 키워야 하는, arr[mid] < target 일 경우와 처리를 같이함
             * 단, lower bound 와는 다르게 lo를 mid+1로 해야 한다.
             * - arr[mid] > target 이면?
             * 해당 값이 target을 초과한 처음 위치일 수 있으므로!
             * end를 줄이되 end는 현재 mid를 포함해야 한다!
             * */
            if (arr[mid] <= target) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }

        /*
         * 3. while 문을 빠져나갔을 때는 lo와 hi가 같아진 상태 => 둘 중 아무거나 반환
         * 이 때 lo나 hi 값은 target 값을 초과한 첫번째 값의 인덱스이므로 1을 빼준 값을 반환해야한다!
         * taget이 아닐때 처리는 lower bound와 동일
         * 만약, target 수가 현재 배열에 없는 작은 수 라면 -1이 반환 되어 OOB 런타임 에러 발생
         * */
        try {
            return arr[lo-1] == target ? lo-1 : NOT_EXIST;
        } catch (ArrayIndexOutOfBoundsException e) {
            return NOT_EXIST;
        }
    }


}
