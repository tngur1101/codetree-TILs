import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static class Car{
        int r;
        int c;
        int d;
        public Car(int r, int c, int d){
            this.r = r;
            this.c = c;
            this.d = d;
        }
    }

    static int N,M;
    static int[][] map;
    static boolean[][] visited;

    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};

    static Car car;

    public static void main(String[] args) throws Exception{
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M];

        st = new StringTokenizer(br.readLine());

        int startX = Integer.parseInt(st.nextToken());
        int startY = Integer.parseInt(st.nextToken());
        int startD = Integer.parseInt(st.nextToken());
        car = new Car(startX, startY, startD);

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        visited[startX][startY] = true;

        boolean flag = true;
        int answer = 1;

        while(flag){
            int cX = car.r;
            int cY = car.c;
            int cD = car.d;

            for(int i = 3; i >= 0 ; i--){
                int nextDir = (cD + i) % 4;
                int nX = cX + dx[nextDir];
                int nY = cY + dy[nextDir];

                if(visited[nX][nY] || map[nX][nY]==1)
                    continue;

                if(!visited[nX][nY] && map[nX][nY]==0){
                    car.r = nX;
                    car.c = nY;
                    car.d = nextDir;
                    break;
                }
            }

            if(cX == car.r && cY == car.c){
                int nX = cX + dx[(cD+2)%4];
                int nY = cY + dy[(cD+2)%4];

                if(map[nX][nY]==0){
                    car.r = nX;
                    car.c = nY;
                } else {
                    flag = false;
                }
            } else {
                if(!visited[car.r][car.c]){
                    answer++;
                }
                visited[car.r][car.c] = true;
            }
        }
        System.out.println(answer);
    }
}