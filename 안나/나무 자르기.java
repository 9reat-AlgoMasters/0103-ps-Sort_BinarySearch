import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N; //나무의 수
	static long M; //필요한 나무 길이
	static int[] tree;
	static long result=100000;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Long.parseLong(st.nextToken());
		tree = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i <N; i++) {
			tree[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(tree);
		
		
		long h = cut(M);
		System.out.println(h);
	}
	
	static int cut(long target) {
		//target은 가져가야하는 나무의 길이
		int low = 0;
		int high =tree[tree.length-1];
		int mid=-1;
		long s;
		
		while(true) {
			mid = (low+high)/2;

			if(low == mid) {
				break;
			}
			s =sum(mid);
			if(s > target) {
				low = mid;
			}else if(s == target) {
				break;
			}else {
				high = mid;
			}
		}
		return mid;
	}

	static long sum(int mid) {
		long s=0;
		for (int j = 0; j < N; j++) {
			if(tree[j]>mid) {
				s+=tree[j]-mid;
			}
		}
		return s;
	}
}