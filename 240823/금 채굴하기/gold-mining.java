import java.util.*;
import java.io.*;

public class Main {

    static int N,M;
    static int[][] map;
    static int answer = Integer.MIN_VALUE;
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

        simulate();
        System.out.println(answer);

    }

    private static void simulate(){
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                for(int k = 0; k <= 2*(N-1); k++){
                    int gc = searchGold(i,j,k);

                    if(isBenefit(k, gc)){
                        answer = Math.max(answer, gc);
                    }
                }
            }
        }
    }

    // 금을 찾는 함수 (0,0)부터 (N-1, N-1)까지 돈다
    private static int searchGold(int r, int c, int k){
        int gc = 0;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(Math.abs(r - i) + Math.abs(c - j) <= k){
                    gc += map[i][j];
                }
            }
        }
        return gc;
    }

    // 손해인지 아닌지 판별하는 함수
    // 손해라면 false를 손해가 아니라면 true를 리턴
    // k : 마름모 중심에서부터 몇번째인지
    // gc : 금의 개수
    private static boolean isBenefit(int k, int gc){
        int profit = gc * M - ((k*k) + (k+1)*(k+1));
        if(profit >= 0) return true;
        else return false;
    }
}