import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        if(isEven(n) && isFiveMultiple(n)) System.out.println("Yes");
        else System.out.println("No");
    }

    private static boolean isEven(int n){
        if(n%2 == 0) return true;
        return false;
    }

    private static boolean isFiveMultiple(int n){
        int a = n/10;
        int b = n%10;

        if((a+b) % 5 == 0) return true;
        return false;
    }
}