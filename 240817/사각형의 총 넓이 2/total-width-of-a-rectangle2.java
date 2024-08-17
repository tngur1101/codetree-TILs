import java.util.*;
import java.io.*;

public class Main {

    static int N;
    static boolean[][] map;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        map = new boolean[101][101];
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            checkWidth(x1, y1, x2, y2);
        }
        System.out.println(getAnswer());
    }

    private static void checkWidth(int x1, int y1, int x2, int y2){
        for(int i = x1; i < x2; i++){
            for(int j = y1; j < y2; j++){
                map[i][j] = true;
            }
        }
    }

    private static int getAnswer(){
        int answer = 0;
        for(int i = 0; i < 101; i++){
            for(int j = 0; j < 101; j++){
                if(map[i][j]) answer += 1; 
            }
        }
        return answer;
    }
}