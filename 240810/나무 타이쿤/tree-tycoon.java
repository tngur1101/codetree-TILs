import java.util.*;
import java.io.*;

public class Main {
    static class moveRule{
        int dir;
        int len;
        public moveRule(int dir, int len){
            this.dir = dir;
            this.len = len;
        }
    }
    static class Point{
        int r;
        int c;
        public Point(int r, int c){
            this.r = r;
            this.c = c;
        }

        @Override
        public boolean equals(Object o) {
            if(this == o) return true;
            if(o == null || getClass() != o.getClass()) return false;
            Point point = (Point) o;
            return this.r == point.r && this.c == point.c;
        }
    }
    static int N, M;
    static int[][] map;
    static Queue<moveRule> moveQueue = new LinkedList<>();
    static Queue<Point> nutritionQueue = new LinkedList<>();
    static int answer;
    static int[] dx = {-1, -1, 1, 1};
    static int[] dy = {-1, 1, 1, -1};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N ;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());
            moveQueue.offer(new moveRule(d,l));
        }

        answer = 0;

        simulate();

        System.out.println(answer);
    }

    private static void simulate(){
        initialNutrition();

        for(int i = 0; i < M; i++){
            moveRule thisRound = moveQueue.poll();
//            System.out.println("before move nutrition");
//            for(Point p: nutritionQueue){
//                System.out.println("("+p.r+", "+p.c+")");
//            }
            moveNutrition(thisRound);
//            System.out.println("after move nutrition");
//            for(Point p: nutritionQueue){
//                System.out.println("("+p.r+", "+p.c+")");
//            }
//            System.out.println("before grow");
//            printMap();
            plusLibro();
            growLibro();
//            System.out.println("after grow");
//            printMap();
//
//            System.out.println("before prepare Next Year");
//            for(Point p: nutritionQueue){
//                System.out.println("("+p.r+", "+p.c+")");
//            }
            prepareNextYear();
//            System.out.println("after prepare Next Year");
//            for(Point p: nutritionQueue){
//                System.out.println("("+p.r+", "+p.c+")");
//            }

        }

        getAnswer();
    }

    private static void initialNutrition(){
        for(int i = N-2; i<= N-1; i++){
            for(int j = 0; j <= 1; j++){
                nutritionQueue.offer(new Point(i,j));
            }
        }
    }

    private static void moveNutrition(moveRule thisRound){
        // 영쟝제가 뿌려져있는 땅의 개수만큼 돌면서
        for(int i = 0; i < nutritionQueue.size(); i++){
            Point now = nutritionQueue.poll();
            int nr = 0;
            int nc = 0;
            switch (thisRound.dir){
                // 우
                case 1:
                    nc = (now.c + thisRound.len) % N;
                    nutritionQueue.offer(new Point(now.r, nc));
                    break;
                case 2: // 우상
                    if(now.r - thisRound.len < 0){
                        nr = (now.r - thisRound.len) + N;
                    } else {
                        nr = now.r - thisRound.len;
                    }
                    nc = (now.c + thisRound.len) % N;
                    nutritionQueue.offer(new Point(nr, nc));
                    break;
                case 3: // 상
                    if(now.r - thisRound.len < 0){
                        nr = (now.r - thisRound.len) + N;
                    } else {
                        nr = now.r - thisRound.len;
                    }
                    nutritionQueue.offer(new Point(nr, now.c));
                    break;
                case 4: // 좌상
                    if(now.r - thisRound.len < 0){
                        nr = (now.r - thisRound.len) + N;
                    } else {
                        nr = now.r - thisRound.len;
                    }
                    if(now.c - thisRound.len < 0){
                        nc = (now.c - thisRound.len) + N;
                    } else {
                        nc = now.c - thisRound.len;
                    }
                    nutritionQueue.offer(new Point(nr, nc));
                    break;
                case 5: // 좌
                    if(now.c - thisRound.len < 0){
                        nc = (now.c - thisRound.len) + N;
                    } else {
                        nc = now.c - thisRound.len;
                    }
                    nutritionQueue.offer(new Point(now.r, nc));
                    break;
                case 6: // 좌하
                    nr = (now.r + thisRound.len) % N;
                    if(now.c - thisRound.len < 0){
                        nc = (now.c - thisRound.len) + N;
                    } else {
                        nc = now.c - thisRound.len;
                    }
                    nutritionQueue.offer(new Point(nr, nc));
                    break;
                case 7: // 하
                    nr = (now.r + thisRound.len) % N;
                    nutritionQueue.offer(new Point(nr, now.c));
                    break;
                case 8: // 우하
                    nr = (now.r + thisRound.len) % N;
                    nc = (now.c + thisRound.len) % N;
                    nutritionQueue.offer(new Point(nr, nc));
                    break;
                default: break;
            }
        }
    }

    private static void growLibro(){
        for(Point now: nutritionQueue){
            for(int d = 0; d < 4; d++){
                int nr = now.r + dx[d];
                int nc = now.c + dy[d];

                if(isInRange(nr, nc) && map[nr][nc] != 0){
                    map[now.r][now.c] += 1;
                }
            }
        }
    }

    private static void plusLibro(){
        for(Point now: nutritionQueue){
            map[now.r][now.c] += 1;
        }
    }

    private static void prepareNextYear(){
        int qSize = nutritionQueue.size();
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(nutritionQueue.contains(new Point(i,j))) continue;
                if(map[i][j] >= 2){
                    map[i][j] -= 2;
                    nutritionQueue.offer(new Point(i,j));
                }
            }
        }
        for(int i = 0; i < qSize; i++){
            nutritionQueue.poll();
        }
    }

    private static void getAnswer(){
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                answer += map[i][j];
            }
        }
    }

    // 범위 밖으로 벗어나는지 확인하는 함수
    private static boolean isInRange(int r, int c){
        return r >= 0 && c >= 0 && r < N && c < N;
    }

    private static void printMap(){
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }
}