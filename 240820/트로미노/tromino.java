import java.util.*;
import java.io.*;

/*
* 문제 풀이
* 완전탐색을 통한 최댓값 구하기
* 1. 한 블럭을 선택한다.
* 2. 한칸마다 회전시키면서 최댓값을 구한다.
* 3. 다른 블럭도 마찬가지로 진행한다.
*/

public class Main {
    static int N,M;
    static int[][] map;
    static int answer;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        answer = 0;

        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                checkFirst(i,j);
                rotate90First(i,j);
                rotate180First(i,j);
                rotate270First(i,j);
                checkStraight(i,j);
                rotateStraight(i,j);
            }
        }

        System.out.println(answer);
        
    }

    private static void checkFirst(int r, int c){
        int prevR = r-1;
        int nextC = c+1;
        if(isInRange(prevR, c) && isInRange(r, nextC)){
            int temp = map[prevR][c] + map[r][c] + map[r][nextC];
            answer = Math.max(answer, temp);
        }
    }

    private static void rotate90First(int r, int c){
        int nextR = r+1;
        int nextC = c+1;
        if(isInRange(nextR, c) && isInRange(r, nextC)){
            int temp = map[r][c] + map[r][nextC] + map[nextR][c];
            answer = Math.max(answer, temp);
        }
    }

    private static void rotate180First(int r, int c){
        int prevC = c-1;
        int nextR = r+1;
        if(isInRange(r, prevC) && isInRange(nextR, c)){
            int temp = map[r][c] + map[r][prevC] + map[nextR][c];
            answer = Math.max(answer, temp);
        }
    }

    private static void rotate270First(int r, int c){
        int prevC = c-1;
        int prevR = r-1;
        if(isInRange(prevR, c) && isInRange(r, prevC)){
            int temp = map[r][c] + map[prevR][c] + map[r][prevC];
            answer = Math.max(answer, temp);
        }
    }

    // 일자 타일은 선택하여 진행할 때
    private static void checkStraight(int r, int c){
        int prevC = c-1;
        int nextC = c+1;
        if(isInRange(r, prevC) && isInRange(r, nextC)){
            int temp = map[r][prevC] + map[r][c] + map[r][nextC];
            answer = Math.max(answer, temp);
        }
    }

    // 일자 타일을 회전하여 확인
    // r : 가운데 있는 중심 좌표의 행
    // c : 가운데 있는 중심 좌표의 열
    private static void rotateStraight(int r, int c){
        int prevR = r-1;
        int nextR = r+1;
        if(isInRange(prevR, c) && isInRange(nextR, c)){
            int temp = map[prevR][c] + map[r][c] + map[nextR][c];
            answer = Math.max(answer, temp);
        }
    }

    // 해당 좌표가 범위 안에 있는지 확인하는 함수
    private static boolean isInRange(int r, int c){
        return r >= 0 && c >= 0 && r < N && c < M;
    }
}