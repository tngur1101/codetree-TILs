import java.util.*;
import java.io.*;

public class Main {

    static int[] arr;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int temp = lcm(arr[0], arr[1]);
        for(int i = 2; i < n; i++){
            temp = lcm(temp, arr[i]);
        }

        System.out.println(temp);

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