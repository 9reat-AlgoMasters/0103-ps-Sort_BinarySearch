import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws  IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		int n = Integer.parseInt(br.readLine());
		int[] nums = new int[n];
		for (int i = 0; i < n; i++) {
			nums[i] = Integer.parseInt(br.readLine());	
		}
		
		Arrays.sort(nums);
		
		StringBuilder sb = new StringBuilder();
		for (int i : nums) {
			sb.append(i).append('\n');
		}
		System.out.print(sb);
	}
}