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

        System.out.println(getMin(a,b,c));

    }

    private static int getMin(int a, int b, int c){
        int ans = Integer.MAX_VALUE;
        
        ans = Math.min(ans, a);
        ans = Math.min(ans, b);
        ans = Math.min(ans, c);

        return ans;
    }


}