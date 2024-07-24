import java.util.*;
import java.io.*;

public class Main {

    static int n1, n2;
    static int[] n1Arr;
    static int[] n2Arr;
    

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        n1 = Integer.parseInt(st.nextToken());
        n2 = Integer.parseInt(st.nextToken());

        n1Arr = new int[n1];
        n2Arr = new int[n2];
        

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n1; i++){
            n1Arr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n2; i++){
            n2Arr[i] = Integer.parseInt(st.nextToken());
        }

        if(isSubsequence()) System.out.println("Yes");
        else System.out.println("No");

    }

    private static boolean isSame(int n){
        for(int i = 0; i < n2; i++){
            if(n1Arr[i + n] != n2Arr[i]) return false;
        }
        return true;
    }

    private static boolean isSubsequence(){
        for(int i = 0; i <= n1-n2; i++){
            if(isSame(i)) return true;
        }
        return false;
    }

    
}