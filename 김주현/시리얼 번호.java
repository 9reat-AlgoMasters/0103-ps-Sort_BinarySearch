import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q1431 {
    static final int NOTHING = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        MyString[] strings = new MyString[N];
        for (int i=0; i<N; i++) {
            strings[i] = new MyString(br.readLine());
        }

        Arrays.sort(strings);
        for (MyString s : strings) {
            sb.append(s.str).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    static class MyString implements Comparable<MyString> {
        String str;

        public MyString(String str) {
            this.str = str;
        }

        @Override
        public int compareTo(MyString o) {
            if (this.str.length() != o.str.length()) {
                return str.length() - o.str.length();
            }

            int thisValue = calculateSumValue(this.str);
            int oValue = calculateSumValue(o.str);
            if (thisValue != oValue) {
                return thisValue - oValue;
            }

            return this.str.compareTo(o.str);
        }
    }

    public static int calculateSumValue(String str) {
        int total = 0;
        for (char c : str.toCharArray()) {
            total += isDigit(c) ? c - '0' : 0;
        }
        return total;
    }

    public static boolean isDigit(char c) {
        return c >= '0' && c <= '9';
    }
}
