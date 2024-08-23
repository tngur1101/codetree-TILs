import java.util.*;
import java.io.*;

public class Main {

    static int N;
    static int[][] map;
    static int[] dx = {-1, -1, 1, 1};
    static int[] dy = {1, -1, -1, 1};
    static int answer;
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

        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                for(int k = 1; k < N; k++){
                    for(int l = 1; l < N; l++){
                        answer = Math.max(answer, getScore(i,j,k,l));
                    }
                }
            }
        }

        System.out.println(answer);

    }

    private static int getScore(int r, int c, int k, int l){
        int[] moveArr = {k, l, k, l};
        int sum = 0;

        for(int d = 0; d < 4; d++){
            for(int q = 0; q < moveArr[d]; q++){
                r += dx[d];
                c += dy[d];

                if(!isInRange(r,c)){
                    return 0;
                }

                sum += map[r][c];
            }
        }
        return sum;
    }


    private static boolean isInRange(int r, int c){
        return r >= 0 && c >= 0 && r < N && c < N;
    }
}