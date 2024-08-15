import java.util.*;
import java.io.*;

public class Main {
    static class Bomb{
        String code;
        char color;
        int time;
        public Bomb(String code, char color, int time){
            this.code = code;
            this.color = color;
            this.time = time;
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        String s = st.nextToken();
        char c = st.nextToken().charAt(0);
        int t = Integer.parseInt(st.nextToken());

        Bomb info = new Bomb(s,c,t);
        System.out.println("code : "+info.code);
        System.out.println("color : "+info.color);
        System.out.println("second : "+info.time);
    }
}