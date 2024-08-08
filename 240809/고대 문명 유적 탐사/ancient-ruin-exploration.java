import java.util.*;
import java.io.*;

public class Main {

    static class Node{
        int r, c;
        public Node(int r, int c){
            this.r = r;
            this.c = c;
        }
    }
    
    static class PositionWithAngle{
        Node position;
        int direction;
        public PositionWithAngle(Node position, int direction){
            this.position = position;
            this.direction = direction;
        }
    }
    
    static int K, M, maxScore;
    static int[][] map;
    static Queue<Integer> pieceQueue = new LinkedList<>();
    static StringBuilder sb = new StringBuilder();
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        K = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[5][5];
        for(int i = 0; i < 5; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 5; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < M; i++){
            pieceQueue.offer(Integer.parseInt(st.nextToken()));
        }

        simulate();

        System.out.println(sb.toString().trim());
    }
    
    private static void simulate(){
        for(int k = 0; k < K; k++){
            maxScore = 0;
            PositionWithAngle bestNode = getBestNode();

            if (bestNode.position == null) break; // No valid moves

            rotate(bestNode.position.r, bestNode.position.c, bestNode.direction);
            removeItems();
            fillMap();
            accumulateExtraScore();

            sb.append(maxScore).append(" ");
        }
    }

    private static PositionWithAngle getBestNode(){
        int max = 0;
        Node bestPos = null;
        int bestDir = -1;

        for (int d = 1; d <= 3; d++) {
            for (int i = 1; i < 4; i++) {
                for (int j = 1; j < 4; j++) {
                    int[][] rotatedMap = copyMap();
                    rotate(i, j, d);
                    int score = calculateScore(rotatedMap);

                    if (score > max) {
                        max = score;
                        bestPos = new Node(i, j);
                        bestDir = d;
                    }
                }
            }
        }
        maxScore += max;
        return new PositionWithAngle(bestPos, bestDir);
    }

    private static int[][] copyMap() {
        int[][] copy = new int[5][5];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                copy[i][j] = map[i][j];
            }
        }
        return copy;
    }

    private static void rotate(int x, int y, int d) {
        int[][] rotated = new int[3][3];
        int[][] tempMap = copyMap();

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (d == 1) // 90 degrees
                    rotated[i][j] = tempMap[3 - j + x - 2][i + y - 1];
                else if (d == 2) // 180 degrees
                    rotated[i][j] = tempMap[3 - i + x - 2][3 - j + y - 2];
                else // 270 degrees
                    rotated[i][j] = tempMap[j + x - 1][3 - i + y - 2];
            }
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                map[i + x - 1][j + y - 1] = rotated[i][j];
            }
        }
    }

    private static int calculateScore(int[][] rotatedMap) {
        visited = new boolean[5][5];
        int score = 0;

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (!visited[i][j]) {
                    int groupScore = bfs(i, j, rotatedMap);
                    score += groupScore;
                }
            }
        }
        return score;
    }

    private static int bfs(int x, int y, int[][] rotatedMap) {
        int count = 1;
        Queue<Node> q = new LinkedList<>();
        visited[x][y] = true;
        q.offer(new Node(x, y));

        while (!q.isEmpty()) {
            Node cur = q.poll();

            for (int d = 0; d < 4; d++) {
                int nx = cur.r + dx[d];
                int ny = cur.c + dy[d];

                if (isInRange(nx, ny) && !visited[nx][ny] && rotatedMap[nx][ny] == rotatedMap[x][y]) {
                    visited[nx][ny] = true;
                    q.offer(new Node(nx, ny));
                    count++;
                }
            }
        }

        if (count > 2) {
            return count;
        }
        return 0;
    }

    private static void removeItems() {
        visited = new boolean[5][5];

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (!visited[i][j] && map[i][j] != 0) {
                    if (bfs(i, j, map) > 0) {
                        removeGroup(i, j);
                    }
                }
            }
        }
    }

    private static void removeGroup(int x, int y) {
        Queue<Node> q = new LinkedList<>();
        int base = map[x][y];
        visited[x][y] = true;
        map[x][y] = 0;
        q.offer(new Node(x, y));

        while (!q.isEmpty()) {
            Node cur = q.poll();

            for (int d = 0; d < 4; d++) {
                int nx = cur.r + dx[d];
                int ny = cur.c + dy[d];

                if (isInRange(nx, ny) && !visited[nx][ny] && map[nx][ny] == base) {
                    visited[nx][ny] = true;
                    map[nx][ny] = 0;
                    q.offer(new Node(nx, ny));
                }
            }
        }
    }

    private static void accumulateExtraScore() {
        while (true) {
            visited = new boolean[5][5];
            int count = 0;
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    if (map[i][j] != 0) {
                        count += bfs(i, j, map);
                    }
                }
            }

            if (count == 0) break;

            removeItems();
            fillMap();
            maxScore += count;
        }
    }

    private static boolean isInRange(int x, int y) {
        return x >= 0 && x < 5 && y >= 0 && y < 5;
    }

    // Filling the map with new pieces from the queue
    private static void fillMap() {
        for (int j = 0; j < 5; j++) {
            for (int i = 4; i >= 0; i--) {
                if (map[i][j] == 0 && !pieceQueue.isEmpty()) {
                    map[i][j] = pieceQueue.poll();
                }
            }
        }
    }
}