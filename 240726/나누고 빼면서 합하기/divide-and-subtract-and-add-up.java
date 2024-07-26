import java.util.*;
import java.io.*;

public class Main {

    static int n,m;
    static int[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n+1];

        st = new StringTokenizer(br.readLine());

        for(int i = 1; i <= n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(getAnswer());

    }

    private static int getAnswer(){
        int sum = 0;

        while(m != 1){
            sum += arr[m];
            // 짝수면
            if(m % 2 == 0) {
                m /= 2;
            }
            // 홀수면
            else {
                m -= 1;
            }
        }

        sum += arr[m];

        return sum;
    }
}