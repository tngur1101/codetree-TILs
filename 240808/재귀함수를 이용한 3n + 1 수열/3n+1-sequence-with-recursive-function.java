import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        System.out.println(getAnswer(n));

    }

    private static int getAnswer(int n){
        if(n == 1){
            return 0;
        }

        if(n % 2 == 0){
            n /= 2;
        } else {
            n = 3*n + 1;
        }

        return getAnswer(n)+1;
    }
}