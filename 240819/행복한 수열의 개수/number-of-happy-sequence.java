import java.util.*;
import java.io.*;

/*
* 행복한 수열 = 연속하여 m개 이상의 동일한 원소가 나오는 순간이 존재하는 수열
* 
*/

public class Main {
    static int N,M;
    static int[][] map;
    static int ans;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][N];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < N; i++){
            checkRow(i);
            checkColumn(i);
        }
        System.out.println(ans);
    }

    // 행을 체크하는 함수
    // r: 체크할 행의 인덱스
    private static void checkRow(int r){
        // System.out.println("r: " + r);
        int cnt = 1;
        for(int i = 0; i < N-1; i++){
            // System.out.println("map["+r+"]["+i+"]: "+map[r][i]);
            // System.out.println("map["+r+"]["+(i+1)+"]: "+map[r][i+1]);
            if(map[r][i] == map[r][i+1]) cnt++;
            if(cnt >= M){
                ans++;
                return;
            }
            else cnt=1;
        }
        // if(cnt >= M) ans++;
    }

    // 열을 체크하는 함수
    // c : 체크할 열의 인덱스
    private static void checkColumn(int c){
        int cnt = 1;
        for(int i = 0; i < N-1; i++){
            if(map[i][c] == map[i+1][c]) cnt++;
            if(cnt >= M){
                ans++;
                return;
            }
            else cnt=1;
        }
        // if(cnt >= M) ans++;
    }
}