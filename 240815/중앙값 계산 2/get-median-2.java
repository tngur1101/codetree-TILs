import java.util.*;
import java.io.*;

public class Main {

    static int N;
    static int[] arr;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        arr = new int[N];

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            if(i % 2 == 0){
                int mid = (0+i)/2;
                sb.append(arr[mid]).append(" ");
            }
        }

        System.out.println(sb);
    }
}