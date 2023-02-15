import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] points = new int[N][2];

        for(int i = 0;i<N;i++){
            String[] temp = br.readLine().split(" ");
            points[i][0] = Integer.parseInt(temp[0]);
            points[i][1] = Integer.parseInt(temp[1]);

        }

        // lamda사용 안한 버전
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] == o2[1]) {
                    return o1[0] - o2[0];
                }
                return o1[1] - o2[1];
            }
        });

        // lamda사용한 버전
//        Arrays.sort(points, (o1, o2) ->{
//            if (o1[1] == o2[1]) {
//                return o1[0] - o2[0];
//            }
//            return o1[1] - o2[1];
//        });

        StringBuilder sb = new StringBuilder();
        for(int i = 0;i<N;i++){
            sb.append(points[i][0]).append(" ").append(points[i][1]);
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}
