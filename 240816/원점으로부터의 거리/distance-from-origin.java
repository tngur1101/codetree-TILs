import java.util.*;
import java.io.*;

public class Main {
    static class Point implements Comparable<Point>{
        int idx;
        int r;
        int c;
        public Point(int idx, int r, int c){
            this.idx = idx;
            this.r = r;
            this.c = c;
        }
        public int compareTo(Point p){
            int dist = Math.abs(this.r - 0) + Math.abs(this.c - 0);
            int pDist = Math.abs(p.r - 0) + Math.abs(p.c - 0);
            if(dist != pDist) return dist - pDist;
            return this.idx - p.idx;
        }
    }
    static Point[] points;
    static int N;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        points = new Point[N];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            points[i] = new Point(i+1,r,c);
        }

        Arrays.sort(points);

        for(int i = 0; i < N; i++){
            System.out.println(points[i].idx);
        }

    }
}