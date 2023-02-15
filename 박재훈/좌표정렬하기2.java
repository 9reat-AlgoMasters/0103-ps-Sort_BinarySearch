import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
	static int N;
	static int[][] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N][2];
		for (int i = 0; i < N; i++) {
			String[] temp = br.readLine().split(" ");
			arr[i][0] = Integer.parseInt(temp[0]);
			arr[i][1] = Integer.parseInt(temp[1]);
		}
		
		Arrays.sort(arr, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
        //comparator 객체 선언
        //y좌표로 정렬, 같다면 x좌표로 정렬
				if(o1[1] != o2[1]) {
					return o1[1] - o2[1];
				}
				return o1[0] - o2[0];
			}
		});
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			sb.append(arr[i][0]).append(" ").append(arr[i][1])
			.append('\n');
		}
		System.out.println(sb);
	}

}
