import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
	static int N;
	static String[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new String[N];
		for (int i = 0; i < N; i++) {
			arr[i] = br.readLine();
		}

		Arrays.sort(arr, new Comparator<String>() {
    //comparator 객체 선언
			@Override
			public int compare(String o1, String o2) {
				if(o1.length() == o2.length()) {
          //길이로 정렬, 같다면 합으로 정렬
					int s1 = sum(o1);
					int s2 = sum(o2);
					if(s1 == s2) {
            //합도 같다면 사전순
						return dict(o1, o2);
					}
					return s1 - s2;
				}
				return o1.length() - o2.length();
			}
		});

		StringBuilder sb = new StringBuilder();
		for (String s : arr) {
			sb.append(s).append('\n');
		}
		System.out.println(sb);
	}
	public static int sum(String s) {
		char[] arr = s.toCharArray();
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
      //문자열의 문자가 숫자인지 확인
      //'0'이 아스키 코드 48인것 활용
			int val = arr[i]-48;
			if(val >=0 && val < 10) {
				sum += val;
			}
		}
		return sum;
	}
	public static int dict(String s1, String s2) {
    //길이는 s1 s2같음
		int size = s1.length();
		for (int i = 0; i < size; i++) {
			char c1 = s1.charAt(i);
			char c2 = s2.charAt(i);
			if(c1 != c2) {
        //자리마다 비교해서 다른 문자면 뺀 후 리턴
        //c1이 사전 상 먼저오는 문자면 음수, 아니면 양수 리턴됨
				return c1 - c2;
			}
		}
		return 0;
	}
}
