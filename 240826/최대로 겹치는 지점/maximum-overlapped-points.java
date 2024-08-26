import java.util.*;
import java.io.*;

public class Main {

    static int[] arr;   // 지점 기준 배열
    static int N;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        arr = new int[101];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            for(int j = s; j <= e; j++){
                arr[j] += 1;
            }
        }

        // System.out.println(Arrays.toString(arr));

        int answer = 0;
        for(int i = 1; i < arr.length; i++){
            answer = Math.max(answer, arr[i]);
        }

        System.out.println(answer);
    }
}