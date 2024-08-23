import java.util.*;
import java.io.*;

/*
* N x N 격자 : 1이상 100이하의 숫자로 구성
* 기울어진 직사각형 : 격자내에 있는 한 지점으로부터 체스의 비숍처럼 대각선으로 움직이며 반시계 순회를 했을 때 지나왔던 지점들의 집합
* 각 방향으로 최소 1번은 움직여야 하고, 격자 밖으로 넘어가면 안됨
*
* 최댓값을 구하는 거기 때문에 무조건 벽에 닿았을 때 방향을 트는 것이 좋다. -> 한 군데라도 더 포함해야 값을 더 더할 수 있기 때문
*/


public class Main {
    static int N;
    static int[][] map;
    static int answer;
    // 북동, 북서, 남서, 남동
    static int[] dx = {-1, -1, 1, 1};
    static int[] dy = {1, -1, -1, 1};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        map = new int[N][N];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        answer = 0;
        simualte();
        System.out.println(answer);

    }

    private static void simualte(){
        for(int i = 2; i < N; i++){
            for(int j = 1; j < N-1; j++){
                // if(i==4 && j == 1){
                //     System.out.println("i :"+i);
                //     System.out.println("j :"+j);
                //     inclinedSquare(i,j);
                // }
                inclinedSquare(i,j);
            }
        }
    }


    private static void inclinedSquare(int r, int c){
        int d = 0;
        int nr = 0;
        int nc = 0;
        int originR = r;
        int originC = c;
        // System.out.println("originR : "+originR);
        // System.out.println("originC : "+originC);
        int sum = 0;

        // 시작 지점으로 돌아올때까지
        // while(nr != originR || nc != originC){
        //     nr = r + dx[d];
        //     nc = c + dy[d];
        //     // System.out.println("nr: "+nr);
        //     // System.out.println("nc: "+nc);

        //     if(isInRange(nr, nc)){
        //         // System.out.println("nr과 nc가 범위 안임");
        //         // System.out.println("map["+nr+"]["+nc+"]: "+ map[nr][nc]);
        //         sum += map[nr][nc];
        //         // System.out.println("sum: "+sum);
        //         r = nr;
        //         c = nc;
        //     } else {
        //         d++;
        //     }
        // }
        while(d < 4){
            nr = r + dx[d];
            nc = c + dy[d];
            // System.out.println("nr: "+nr);
            // System.out.println("nc: "+nc);

            if(isInRange(nr, nc)){
                // System.out.println("nr과 nc가 범위 안임");
                // System.out.println("map["+nr+"]["+nc+"]: "+ map[nr][nc]);
                sum += map[nr][nc];
                // System.out.println("sum: "+sum);
                r = nr;
                c = nc;
            } else {
                d++;
            }
        }
        answer = Math.max(answer, sum);
    }


    // 다음 위치가 격자 밖인지를 판단하는 함수
    // 만약 격자 밖이면 방향을 바꾸도록 할 것임
    private static boolean isInRange(int r, int c){
        return r >= 0 && c >= 0 && r < N && c < N;
    }
}