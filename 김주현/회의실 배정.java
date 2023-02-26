import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Q1931 {
    
    static int N;
    static PriorityQueue<Lecture> pq = new PriorityQueue<>();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        
        N = Integer.parseInt(br.readLine());
        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            pq.add(new Lecture(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        
        int end = 0;
        int count = 0;
        while (!pq.isEmpty()) {
            Lecture lecture = pq.poll();
//            System.out.printf("start : %d, end : %d\n", lecture.start, lecture.end);
            if (lecture.start < end) continue;
    
//            System.out.println("추가됨!");
            count++;
            end = lecture.end;
        }
        sb.append(count);
    
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
    
    static class Lecture implements Comparable<Lecture> {
        int start;
        int end;
    
        public Lecture(int start, int end) {
            this.start = start;
            this.end = end;
        }
    
        @Override
        public int compareTo(Lecture o) {
//            return this.end == o.end ? o.start - this.start : this.end - o.end;
            return this.end == o.end ? this.start - o.start : this.end - o.end;
        }
    }
}
