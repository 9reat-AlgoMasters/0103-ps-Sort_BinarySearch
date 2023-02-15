import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
* < i 번째 탐색 >
* i+1 ~ 끝까지 0이 되는 수를 ub로 탐색
* 만약 양수라면 바로 다음수임
* 그리고 양수라면 그 이후의 수들은 보지 않아도 상관없다.
* 일단 양수만 있을 때와 음수만 있을 때는 따로 처리를 하고 가자!
*
* */

public class Q2470 {
    static int N;
    static int[] arr;
    static int[] selected = new int[2];
    static int minSum = Integer.MAX_VALUE;

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

        // 1. 양수만 있을 때
        if (arr[0] > 0) {
            sb.append(arr[0]).append(" ").append(arr[1]);
        } else if (arr[N-1] < 0) {
            sb.append(arr[N-2]).append(" ").append(arr[N-1]);
        } else {
            selected = solve();
            sb.append(selected[0]).append(" ").append(selected[1]);
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static int[] solve() {
        int[] selected = new int[2];

        for (int i=0; i<N-1; i++) {
//            System.out.printf("\n## %d 와의 짝을 찾습니다. (현재 minSum : %d)\n", arr[i], minSum);
            // 1. 양수일 경우
            if (arr[i] >= 0) {
                if (minSum > Math.abs(arr[i] + arr[i+1])) {
                    minSum = arr[i] + arr[i+1];
                    System.arraycopy(arr, i, selected, 0, 2);
                }
                break;
            }

            /*
            * 2. 음수일 경우는 합해서 0이되는 인덱스를 찾는다.
            * 2-1. 0이 되는 인덱스가 있다면 바로 return
            * 2-2. 그렇지 않다면 반환된 인덱스와 그 전 인덱스 두개를 확인해서 적은 쪽에 대한 정보를 minDiff와 selected에 저장한다.
            * */
            int targetIdx = binarySearchUb(i);
//            System.out.printf("%d가 찾아졌습니다\n",arr[targetIdx]);
            if (arr[i] + arr[targetIdx] == 0) {
//                System.out.println("minSum = 0 발견!!!!!");
                minSum = 0;
                selected[0] = arr[i];
                selected[1] = arr[targetIdx];
                break;
            } else {
                for (int j=0; j<2; j++) {
                    if (isValidIndex(i, targetIdx+j) && Math.abs(arr[i] + arr[targetIdx+j]) < minSum) {
                        minSum = Math.abs(arr[i] + arr[targetIdx+j]);
//                        System.out.printf("(%d, %d)로 minSum 갱신 -> %d\n", arr[i], arr[targetIdx+j], minSum);
                        selected[0] = arr[i];
                        selected[1] = arr[targetIdx+j];
                    }
                }
            }
        }
        return selected;
    }

    public static boolean isValidIndex(int i, int targetIdx) {
        return i != targetIdx && targetIdx < N;
    }

    private static int binarySearchUb(int loIdx) {
        int target = -arr[loIdx];
        int lo = loIdx;
        int hi = N;
        int mid;

        while (lo < hi) {
            mid = (lo + hi) / 2;

            // 같으면 ? -> 왼쪽 범위를 줄인다! 초과하는 원소이므로 mid는 포함하지 않는다. -> 작을 때랑 같다!
            if (arr[mid] <= target) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo - 1;
    }
}
