import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        System.out.println(divide(0, n));

    }

    private static int divide(int depth, int n){
        if(n == 1){
            return depth;
        }

        if(n%2 == 0){
            return divide(depth+1, n/2);
        } else {
            return divide(depth+1, n/3);
        }
    }
}