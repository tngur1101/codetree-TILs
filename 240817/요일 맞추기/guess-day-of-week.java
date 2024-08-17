import java.util.*;
import java.io.*;

public class Main {

    static int[] month = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    static String[] date = {"Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"};

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int m1 = Integer.parseInt(st.nextToken());
        int d1 = Integer.parseInt(st.nextToken());
        int m2 = Integer.parseInt(st.nextToken());
        int d2 = Integer.parseInt(st.nextToken());

        int diff = getGap(m1, d1, m2, d2);

        while(diff < 0){
            diff += 7;
        }

        System.out.println(date[diff % 7]);

    }

    private static int addMonth(int n){
        int temp  = 0;
        for(int i = 0; i < n; i++){
            temp += month[i];
        }
        return temp;
    }

    private static int getGap(int m1, int d1, int m2, int d2){
        return addMonth(m2) - addMonth(m1) + d2 - d1;
    }
}