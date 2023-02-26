import java.io.*;
import java.util.*;

public class Q18870 {
    static int N;
    static int[] arr;
    static Integer[] sortedArr;
    static Set<Integer> numbers = new HashSet<>();
    static Map<Integer, Integer> countMap = new HashMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            arr[i]  = Integer.parseInt(st.nextToken());
            numbers.add(arr[i]);
        }
        sortedArr = numbers.toArray(new Integer[0]);
        Arrays.sort(sortedArr);
        
        for (int num : arr) {
            if (!countMap.containsKey(num)) {
                countMap.put(num, binarySearchLb(num));
            }
            sb.append(countMap.get(num)).append(" ");
        }
        
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
    
    public static int binarySearchLb(int target) {
        int lo = 0;
        int hi = sortedArr.length;
        int mid;
        
        while(lo < hi) {
            mid = (lo + hi) / 2;
            
            // 같으면 ? 포함하면서 내려! -> mid가 클때와 같다!
            if (sortedArr[mid] >= target) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }
}