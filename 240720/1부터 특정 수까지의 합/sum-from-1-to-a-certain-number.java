import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        System.out.println(divide(n));
    }

    private static int divide(int n){
        int ans = 0;
        for(int i = 1; i <= n; i++){
            ans += i;
        }

        ans /= 10;
        return ans;
    }
}