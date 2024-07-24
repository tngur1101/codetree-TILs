import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int cnt = 0;

        for(int i = a; i <= b; i++){
            if(!isDivideByTwo(i) && !isUnitFive(i) && !isDivideByThreeButNotDivideByNine(i)) cnt++;
        }

        System.out.println(cnt);

    }

    private static boolean isDivideByTwo(int a){
        if(a % 2 == 0) return true;
        return false;
    }

    private static boolean isUnitFive(int a){
        if(a%10 == 5) return true;
        return false;
    }

    private static boolean isDivideByThreeButNotDivideByNine(int a){
        if(a % 3 == 0 && a % 9 != 0) return true;
        return false;
    }
}