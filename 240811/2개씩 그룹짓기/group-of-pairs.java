import java.util.*;
import java.io.*;

public class Main {

    static int N;
    static int[] arr;
    static int answer;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        arr = new int[2*N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < 2*N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        answer = 0;
        Arrays.sort(arr);
        for(int i = 0; i < N; i++){
            int temp = arr[i] + arr[2*N-1-i];
            answer = Math.max(answer, temp);
        }

        System.out.println(answer);

    }
}