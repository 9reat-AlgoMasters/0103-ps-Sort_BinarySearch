import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeMap;

public class Main {
	static int N;
	static int[] arr;
  //treemap 자료구조 이용
	static TreeMap<Integer, Integer> map = new TreeMap<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		String[] input = br.readLine().split(" ");
		for (int i = 0; i < N; i++) {
			int val = Integer.parseInt(input[i]);
			map.put(val, 0);
			arr[i] = val;
		}
		int count = 0;
		for(int i : map.keySet()){ 
      //map에 정렬된 순서대로 count값 부여 
			map.put(i, count++);
		}
		StringBuilder sb = new StringBuilder();
		for(int i : arr){
      //map에서 찾아서 저장해준 count값 출력
			sb.append(map.get(i)+" ");
		}
		System.out.println(sb);
	}

}
