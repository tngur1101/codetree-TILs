import java.util.*;
import java.io.*;

/*
* 0차 드래곤 커브 : 길이가 1인 선분
* 1차 드래곤 커브 : 0차 드래곤 커브를 복제한 후, 해당 드래곤 커브의 끝점을 기준으로 시계 방향으로 90도 회전하여 연결한 것
* n차 드래곤 커브 : n-1차 드래곤 커브의 끝점에 n-1차 드래곤 커브를 복제한 뒤 시계방향으로 90도 회전시킨 뒤 연결한 도형
*
* d : 시작 방향 ( 0 : 오른쪽, 1 : 위쪽, 2: 왼쪽, 3: 아래쪽 )
* g : 차수
*
* 위 -> 왼
* 왼 -> 아래
* 아래 -> 오른
* 오른 -> 위
*/

public class Main {
    static class Point{
        int r;
        int c;
        int dir;
        int generation;
        public Point(int r, int c, int dir, int generation){
            this.r = r;
            this.c = c;
            this.dir = dir;
            this.generation = generation;
        }
    }
    static int N;
    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {1, 0, -1, 0};
    static boolean[][] map = new boolean[101][101];
    static int minR = 0, maxR = 100, minC = 0, maxC = 100;
    static Point[] arr;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        arr = new Point[N];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int dir = Integer.parseInt(st.nextToken());
            int generation = Integer.parseInt(st.nextToken());

            updateMinMax(r,c);
            arr[i] = new Point(r,c,dir, generation);
        }

        for(int i = 0; i < N; i++){
            draw(arr[i]);
        }

        int answer = countSquare();
        System.out.println(answer);
    }

    private static void draw(Point point){
        // 시작 지점 true
        map[point.r][point.c] = true;
        
        int r = point.r + dx[point.dir];
        int c = point.c + dy[point.dir];

        // 0차 드래곤 커브 끝 지점 true
        map[r][c] = true;
        updateMinMax(r,c);

        // 방향을 저장할 리스트
        ArrayList<Integer> dirList = new ArrayList<>();

        dirList.add(point.dir);

        while(point.generation > 0){
            for(int i = dirList.size() - 1; i >=0; i--){
                int nextDir = (dirList.get(i) + 1) % 4;
                r = r + dx[nextDir];
                c = c + dy[nextDir];
                updateMinMax(r,c);

                map[r][c] = true;
                dirList.add(nextDir);
            }
            point.generation--;
        }


    }


    private static void updateMinMax(int r, int c){
        if(r < minR) minR = r;
        if(r > maxR) maxR = r;
        if(c < minC) minC = c;
        if(c > maxC) maxC = c;
    }

    // 네모 개수 세는 함수
    private static int countSquare(){
        int cnt = 0;
        for(int i = minR; i < maxR; i++){
            for(int j = minC; j < maxC; j++){
                // map[i][j]가 false이면 볼 필요 없으니 건너뛰기
                if(!map[i][j]) continue;
                // 만약 true이면 내 중심으로 아래, 오른쪽, 오른쪽 아래 확인
                if(map[i+1][j] & map[i][j+1] && map[i+1][j+1]) cnt++;
            }
        }
        return cnt;
    }
}