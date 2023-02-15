import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static int N, min = 2000000001, ans1, ans2;
	static int[] value;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		value = new int[N];
		String[] input = br.readLine().split(" ");
		for (int i = 0; i < N; i++) {
			value[i] = Integer.parseInt(input[i]);
		}
    //오름 차순 정렬
		Arrays.sort(value);

    //두 개의 포인터 left, right 초기 값 설정 
		int left = 0;
		int right = N-1;
		while(left < right) {
      //두 포인터가 만났다 == 배열 원소 다 봤다.
			int val = value[left] + value[right];
			if(min > Math.abs(val)) {
        //0에 가까운지 비교
				min = Math.abs(val);
				ans1 = value[left];
				ans2 = value[right]; 
			}

			if(val > 0) {
        //값이 양수면 0에 더 가까운 값을 만들기 위해 큰쪽인 right포인터를 내려줌
				right--;
			}else {
        //값이 음수면 작은 쪽 포인터 올려줌
				left++;
			}
		}
		System.out.println(ans1+" "+ans2);
	}
}
