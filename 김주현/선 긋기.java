import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Q2170 {
    
    static int N;
    static PriorityQueue<Line> pq = new PriorityQueue<>();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        
        N = Integer.parseInt(br.readLine());
        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            pq.add(new Line(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        
        int end = -1_000_000_001;
        int lineLength = 0;
        while(!pq.isEmpty()) {
            Line line = pq.poll();
//            System.out.printf("start : %d, end : %d\n", line.start, line.end);
            
            if (line.end <= end) continue;
            
            if (line.start >= end) {
                lineLength += line.getLength();
//                System.out.printf("%d 추가!\n", line.getLength());
            } else {
                lineLength += line.end - end;
//                System.out.printf("%d 추가!\n", line.end - end);
            }
    
            end = line.end;
        }
        
        sb.append(lineLength);
    
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
    
    static class Line implements Comparable<Line> {
        int start;
        int end;
    
        public Line(int start, int end) {
            this.start = start;
            this.end = end;
        }
        
        public int getLength() {
            return end - start;
        }
    
        @Override
        public int compareTo(Line o) {
            return this.start == o.start ? o.end - this.end : this.start - o.start;
        }
    }
}
