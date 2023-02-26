import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
	static int N;
	static int[][] arr;
	static int[] ans;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N][2];
		ans = new int[N];
		String[] input = br.readLine().split(" ");
		for (int i = 0; i < N; i++) {
			int val = Integer.parseInt(input[i]);
      //값과 순서 저장
			arr[i][0] = val;
			arr[i][1] = i;
		}
    
    //값으로 정렬
		Arrays.sort(arr, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0] - o2[0];
			}
		});
		int count = -1;
		int prev = 1000000001;
		for (int i = 0; i < N; i++) {
      //이전 값과 같다면 count그대로, 이전값보다 크면 count올린 채로 저장
			if(prev == arr[i][0]) {
				ans[arr[i][1]] = count;
			}else {
				ans[arr[i][1]] = ++count;
				prev = arr[i][0];
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			sb.append(ans[i]).append(' ');
		}
		System.out.println(sb);
	}

}
