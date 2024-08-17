import java.util.*;
import java.io.*;

public class Main {

    static int[] arr;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        char[] origin = br.readLine().toCharArray();

        arr = new int[origin.length];
        for(int i = 0; i < arr.length; i++){
            arr[i] = origin[i] - '0';
        }
        
        int answer = 0;
        for(int i = arr.length - 1; i >= 0; i--){
            int temp = (int) Math.pow(2, arr.length-1-i)*arr[i];
            answer += temp;
        }
        
        System.out.println(answer);
    }
}