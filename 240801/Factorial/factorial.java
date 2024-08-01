import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        System.out.println(factorial(n));

    }

    private static int factorial(int n){
        if(n == 0){
            return 1;
        }

        return n*factorial(n-1);
    }
}