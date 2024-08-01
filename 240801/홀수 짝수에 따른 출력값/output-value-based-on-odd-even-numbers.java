import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        System.out.println(getSum(n));
    }

    private static int getSum(int n){
        // 짝수면
        if(n % 2 == 0){
            if(n == 2){
                return n;
            }
        } else {    // 홀수면
            if(n == 1){
                return n;
            }
        }

        return n+getSum(n-2);
    }
}