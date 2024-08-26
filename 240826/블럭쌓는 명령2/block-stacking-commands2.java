import java.util.*;
import java.io.*;

public class Main {

    static int N,K;
    static int[] arr;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new int[N+1];

        for(int k = 0; k < K; k++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            for(int i = s; i <= e; i++){
                arr[i] += 1;
            }
        }

        // System.out.println(Arrays.toString(arr));

        int answer = 0;
        for(int i = 1; i <= N; i++){
            answer = Math.max(answer, arr[i]);
        }

        System.out.println(answer);

    }
}