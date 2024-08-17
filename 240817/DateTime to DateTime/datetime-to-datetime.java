import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        if(a < 11){
            System.out.println(-1);
            return;
        }
        if(a == 11){
            if(b < 11){
                System.out.println(-1);
                return;
            }
            if(b == 11){
                if(c < 11){
                    System.out.println(-1);
                    return;
                }
            }
        }

        int total = 1440 * (a - 11) + 60 * (b - 0) + (c - 0);
        System.out.println(total - (60*11 + 11));

    }
}