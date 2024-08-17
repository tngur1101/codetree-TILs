import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int[] months = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        int m1 = Integer.parseInt(st.nextToken());
        int d1 = Integer.parseInt(st.nextToken());
        int m2 = Integer.parseInt(st.nextToken());
        int d2 = Integer.parseInt(st.nextToken());

        int addAll = 0;
        int temp = 0;

        for(int i = 0; i < m2; i++){
            addAll += months[i];
        }
        addAll += d2;

        for(int i = 0; i < m1; i++){
            temp += months[i];
        }
        temp += (d1-1);

        System.out.println(addAll - temp);
    }
}