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

    // 상, 좌, 하, 우
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

        // bfs 결과 true이면 갈 수 있다고 판단 false이면 갈 수 없다고 판단한다.
        if(bfs(new Node(0,0))) System.out.println(1);
        else System.out.println(0);

    }

    private static boolean bfs(Node start){
        // Queue에는 갈 수 있는 노드들이 담기게 된다.
        Queue<Node> q = new LinkedList<>();

        // 시작 지점을 방문처리한다.
        visited[start.r][start.c] = true;

        q.offer(start);

        // Queue가 빌 때까지 반복하면서 모든 지점을 탐색한다.
        while(!q.isEmpty()){
            // 현재 위치
            Node now = q.poll();

            // 만약 목적지에 다다랐다면 도달 가능하기 때문에 true를 리턴한다.
            if(now.r == N-1 && now.c == M-1) return true;

            for(int d = 0; d < 4; d++){
                // 다음 탐색할 노드를 계산한다.
                // 위 dx, dy 배열을 기준으로 상, 좌, 하, 우순으로 탐색한다.
                int nr = now.r + dx[d];
                int nc = now.c + dy[d];

                // 만약 범위 안에 있으면 아직 방문하지 않은곳이고 뱀이 없는 지역이면
                if(isInRange(nr, nc) && !visited[nr][nc] && map[nr][nc]==1){
                    // 해당 지역을 방문처리하고
                    visited[nr][nc] = true;
                    // Queue에 넣어 해당 노드부터 탐색을 가능하도록 한다.
                    q.offer(new Node(nr, nc));
                }
            }
        }
        // Queue를 다 돌았는데 도착하지 못했다면 도달 불가하기 때문에 false를 반환한다.
        return false;
    }

    // 해당 좌표가 map의 범위 안에 있는지 확인하는 함수
    private static boolean isInRange(int r, int c){
        return r >= 0 && c >= 0 && r < N && c < M;
    }
}