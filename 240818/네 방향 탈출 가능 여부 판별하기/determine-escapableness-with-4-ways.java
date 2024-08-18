import java.util.*;
import java.io.*;

public class Main {
    static class Node{
        int r;
        int c;
        public Node(int r, int c){
            this.r = r;
            this.c = c;
        }
    }
    static int[][] map;
    static int N,M;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        if(bfs(new Node(0,0))) System.out.println(1);
        else System.out.println(0);

    }

    private static boolean bfs(Node start){
        Queue<Node> q = new LinkedList<>();
        visited[start.r][start.c] = true;

        q.offer(start);

        while(!q.isEmpty()){
            Node now = q.poll();

            if(now.r == N-1 && now.c == M-1) return true;

            for(int d = 0; d < 4; d++){
                int nr = now.r + dx[d];
                int nc = now.c + dy[d];
                // System.out.println("nr: " + nr);
                // System.out.println("nc: " + nc);
                if(isInRange(nr, nc) && !visited[nr][nc] && map[nr][nc]==1){
                    // System.out.println("if문 들어옴");
                    visited[nr][nc] = true;
                    q.offer(new Node(nr, nc));
                }
            }
        }
        return false;
    }

    private static boolean isInRange(int r, int c){
        return r >= 0 && c >= 0 && r < N && c < M;
    }
}