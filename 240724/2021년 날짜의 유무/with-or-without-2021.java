import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());

        if(isExist(M,D)) System.out.println("Yes");
        else System.out.println("No");

    }

    private static boolean isExist(int M, int D){
        if(M > 12) return false;
        if(M == 1 || M == 3 || M == 5 || M == 7 || M == 8 || M == 10 || M == 12){
            if(D > 31) return false;
        }
        if(M == 4 || M == 6 || M == 9 || M == 11){
            if(D > 30) return false;
        }
        if(M==2){
            if(D > 28) return false;
        }
        return true;
    }
}