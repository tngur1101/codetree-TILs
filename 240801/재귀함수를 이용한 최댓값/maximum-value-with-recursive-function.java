import java.util.*;
import java.io.*;

public class Main {

    static int N;
    static int[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        arr = new int[N];

        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(getMax(0, arr[0]));
    }

    private static int getMax(int depth, int num){
        if(depth == N-1){
            // System.out.println("depth: "+depth);
            // System.out.println("num: "+num);
            // System.out.println("arr[depth]: "+arr[depth]);
            return Math.max(arr[depth], num);
        }

        return getMax(depth+1, Math.max(arr[depth], num));
    }
}