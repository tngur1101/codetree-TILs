import java.util.*;
import java.io.*;

public class Main {
    static final int len = 8;
    static int N;
    static boolean[][] map = new boolean[201][201];

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken())+100;
            int c = Integer.parseInt(st.nextToken())+100;
            pastePaper(r,c);
            // printMap(r,c);
        }
        System.out.println(getAnswer());
    }

    private static void pastePaper(int r, int c){
        for(int i = r; i < r+8; i++){
            for(int j = c; j < c+8; j++){
                map[i][j] = true;
            }
        }
    }

    private static int getAnswer(){
        int answer = 0;
        for(int i =0; i < map.length; i++){
            for(int j = 0; j < map.length; j++){
                if(map[i][j]) answer++;
            }
        }
        return answer;
    }

    private static void printMap(int r, int c){
        for(int i = r; i < r+8; i++){
            for(int j = c; j < c+8; j++){
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }
}