import java.util.*;
import java.io.*;

public class Main {

    static boolean[][] map = new boolean[2001][2001];
    static BufferedReader br;
    static StringTokenizer st;
    static int x1,y1,x2,y2;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        x1 = Integer.parseInt(st.nextToken()) + 1000;
        y1 = Integer.parseInt(st.nextToken()) + 1000;
        x2 = Integer.parseInt(st.nextToken()) + 1000;
        y2 = Integer.parseInt(st.nextToken()) + 1000;
        pasteAOrB(x1, y1, x2, y2);
        st = new StringTokenizer(br.readLine());
        x1 = Integer.parseInt(st.nextToken()) + 1000;
        y1 = Integer.parseInt(st.nextToken()) + 1000;
        x2 = Integer.parseInt(st.nextToken()) + 1000;
        y2 = Integer.parseInt(st.nextToken()) + 1000;
        pasteAOrB(x1, y1, x2, y2);
        st = new StringTokenizer(br.readLine());
        x1 = Integer.parseInt(st.nextToken()) + 1000;
        y1 = Integer.parseInt(st.nextToken()) + 1000;
        x2 = Integer.parseInt(st.nextToken()) + 1000;
        y2 = Integer.parseInt(st.nextToken()) + 1000;
        coverM(x1, y1, x2, y2);
        System.out.println(getAnswer());

    }

    private static void pasteAOrB(int x1, int y1, int x2, int y2){
        for(int i = x1; i < x2; i++){
            for(int j = y1; j < y2; j++){
                map[i][j] = true;
            }
        }
    }

    private static void coverM(int x1, int y1, int x2, int y2){
        for(int i = x1; i < x2; i++){
            for(int j = y1; j < y2; j++){
                if(map[i][j]) map[i][j] = false;
            }
        }
    }

    private static int getAnswer(){
        int answer = 0;
        for(int i = 0; i < 2001; i++){
            for(int j = 0; j < 2001; j++){
                if(map[i][j]) answer += 1;
            }
        }
        return answer;
    }
}