import java.util.*;
import java.io.*;

public class Main {

    static int N;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        System.out.println(getMultiple(N));

    }

    private static int getMultiple(int n){
        if(n < 10){
            return n*n;
        }

        int remain = n%10;
        int temp = remain*remain;
        return getMultiple(n/10) + temp;
    }
}