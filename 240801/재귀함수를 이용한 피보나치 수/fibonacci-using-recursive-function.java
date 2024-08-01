import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        
        System.out.println(fibo(n));
    }

    private static int fibo(int n){
        if(n == 1){
            return 1;
        }
        if(n == 2){
            return 1;
        }

        return fibo(n-1)+fibo(n-2);
        
    }
}