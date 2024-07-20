import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        System.out.println(countThose(a,b));
    }

    private static int countThose(int a, int b){
        int ans = 0;
        for(int i = a; i <= b; i++){
            if(isContainThree(i) || isThreeMultiple(i)) ans++;
        }
        return ans;
    }

    private static boolean isContainThree(int n){
        while(n > 0){
            int digit = n%10;
            if(digit == 3 || digit == 6 || digit == 9) return true;
            n/=10;
        }
        return false;
    }

    private static boolean isThreeMultiple(int n){
        if(n%3 == 0) {
            // System.out.println(n);
            return true;
        }
        else return false;
    }
}