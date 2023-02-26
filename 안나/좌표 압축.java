import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static HashMap<Integer,Integer> map = new HashMap<>();
	static int[] points;
	static int[] sorted;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st =new StringTokenizer(br.readLine());
		points= new int[N];
		sorted= new int[N];
		for (int i = 0; i < N; i++) {
			points[i] = Integer.parseInt(st.nextToken());
			map.put(points[i],0);
		}

		System.arraycopy(points, 0, sorted, 0, points.length);
		Arrays.sort(sorted);
		
		for (int i = 1; i < sorted.length; i++) {
			if(sorted[i-1]==sorted[i]) {
				continue;
			}
			map.put(sorted[i], map.get(sorted[i-1])+1);
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			sb.append(map.get(points[i])).append(" ");
		}
//		System.out.println(map);
//		System.out.println(Arrays.toString(sorted));
//		System.out.println(Arrays.toString(points));
		
		System.out.println(sb);
	}
}
/*
5
2 4 -10 4 -9
{2=0, 4=0, -9=0, -10=0}
[-10, -9, 2, 4, 4]
[2, 4, -10, 4, -9]
*/