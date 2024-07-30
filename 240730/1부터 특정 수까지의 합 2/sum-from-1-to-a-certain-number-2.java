import java.util.*;
import java.io.*;

public class Main {
    
    static int N;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        System.out.println(sumNumber(N));

    }

    private static int sumNumber(int num){
        if(num == 1){
            return 1;
        }

        return sumNumber(num-1) + num;
    }
}