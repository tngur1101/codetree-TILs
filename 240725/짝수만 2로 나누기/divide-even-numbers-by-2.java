import java.util.*;
import java.io.*;

public class Main {

    static int N;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        printEven(arr);

    }

    private static void printEven(int[] arr){
        for(int i = 0; i < N; i++){
            if(arr[i] % 2 == 0){
                arr[i] /= 2;
            }
        }

        for(int i = 0; i < N; i++){
            System.out.print(arr[i] + " ");
        }
    }  
}