import java.util.*;
import java.io.*;

public class Main {

    static int N;
    static int[] arr;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        arr = new int[201];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken())+100;
            int x2 = Integer.parseInt(st.nextToken())+100;

            for(int x = x1; x < x2; x++){
                arr[x] += 1;
            }
        }

        // System.out.println(Arrays.toString(arr));

        int answer = 0;
        for(int i = 0; i < arr.length; i++){
            answer = Math.max(answer, arr[i]);
        }

        System.out.println(answer);

    }
}