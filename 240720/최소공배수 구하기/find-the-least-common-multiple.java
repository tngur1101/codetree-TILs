import java.util.*;
import java.io.*;

/*
* 최소공배수 = A * B / A와 B의 최대공약수
*/

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        if(n >= m){
            System.out.println(lcm(n,m));
        } else {
            System.out.println(lcm(m,n));
        }

    }

    private static int lcm(int a, int b){
        return a*b/gcd(a,b);
    }

    private static int gcd(int a, int b){
        if(b == 0){
            return a;
        }

        return gcd(b, a%b);
    }
}