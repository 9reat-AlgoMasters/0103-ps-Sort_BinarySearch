import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        List<String> serials = new ArrayList<>();
        for(int i = 0;i < N; i++) {
            serials.add(br.readLine());
        }

        Collections.sort(serials, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                // 길이가 다르면 길이의 오름 차순으로 정렬
                if (o1.length() != o2.length()) {
                    return o1.length() - o2.length();
                } else if(o1.length() == o2.length()){  // 길이가 같다면 A의 모든 자리수의 합과 B의 모든 자리수의 합을 비교,작은 합을 가지는 것이 먼저, 숫자만 더함 
                    int sum1 = 0;
                    int sum2 = 0;
                    
                    for(int i = 0;i < o1.length(); i++) {
                        char t1 = o1.charAt(i);
                        if (Character.isDigit(t1)) { // 숫자인지 확인
                            sum1 += t1 -'0';
                        }
                    }

                    for(int i = 0;i < o2.length(); i++) {
                        char t2 = o2.charAt(i);
                        if (Character.isDigit(t2)) {
                            sum2 += t2 -'0';
                        }
                    }
                    if (sum1==sum2) { // 길이고 같은데 합도 같다면 이제 사전순 정렬
                        return o1.compareTo(o2);
                    }

                    return sum1 - sum2;
                }

                return 1;
            }
        });

        StringBuilder sb = new StringBuilder();
        for(String serial:serials) {
            sb.append(serial+ "\n");
        }
        System.out.println(sb);
    }
}
