import java.util.*;
import java.io.*;

public class Main {
    static int n;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        Integer[] arr2 = new Integer[n];

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            arr2[i] = arr[i];
        }

        Arrays.sort(arr);
        printArr(arr);

        Arrays.sort(arr2, Collections.reverseOrder());
        printArr2(arr2);


    }

    private static void printArr(int[] arr){
        for(int i = 0; i < n; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    private static void printArr2(Integer[] arr){
        for(int i = 0; i < n; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}