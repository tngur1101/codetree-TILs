import java.util.*;
import java.io.*;

/*
* 격자의 크기 : N x N
* 동전이 있으면 1, 없으면 0
* 3 x 3 격자를 만들어서 동전의 개수를 최대로 하기
*
* 문제 풀이
* (0,0)을 시작으로 (N-2, N-2)까지 격자를 만들어보면서 동전의 개수를 세본다.
* 가장 큰 값을 업데이트한다.
*/


public class Main {

    static int N;   // 격자의 크기
    static int[][] map; // 격자 정보
    static int ans; // 정답

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

        search();
        System.out.println(ans);
    }

    private static void search(){
        for(int i = 0; i < N-2; i++){
            for(int j = 0; j < N-2; j++){
                ans = Math.max(ans, countCoin(i,j));
            }
        }
    }

    // r : 시작위치의 행
    // c : 시작위치의 열
    private static int countCoin(int r, int c){
        int cnt = 0;
        for(int i = r; i < r+3; i++){
            for(int j = c; j < c+3; j++){
                if(map[i][j] == 1) cnt++;
            }
        }
        return cnt;
    }
}