import java.util.*;
import java.io.*;

public class Main {

    static int[] months = {0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    static String[] dates = {"Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"};

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int m1 = Integer.parseInt(st.nextToken());
        int d1 = Integer.parseInt(st.nextToken());
        int m2 = Integer.parseInt(st.nextToken());
        int d2 = Integer.parseInt(st.nextToken());

        String date = br.readLine();

        int diff = getGap(m1, d1, m2, d2);

        int a = diff / 7;

        int b = diff % 7;
        
        int idx = 0;
        for(int i = 0; i < dates.length; i++){
            if(date.equals(dates[i])) idx = i;
        }
        if(idx <= b) a += 1;
        System.out.println(a);

    }

    private static int getDate(int n){
        int temp = 0;
        for(int i = 0; i < n; i++){
            temp += months[i];
        }
        return temp;
    }

    private static int getGap(int m1, int d1, int m2, int d2){
        return getDate(m2) - getDate(m1) + d2 - d1;
    }
}