import java.util.*;
import java.io.*;

public class Main {

    static int n1, n2;
    static int[] n1Arr;
    static int[] n2Arr;
    static int[] sliceArr;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        n1 = Integer.parseInt(st.nextToken());
        n2 = Integer.parseInt(st.nextToken());

        n1Arr = new int[n1];
        n2Arr = new int[n2];
        sliceArr = new int[n2];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n1; i++){
            n1Arr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n2; i++){
            n2Arr[i] = Integer.parseInt(st.nextToken());
        }

        int startIdx = getStartIdx();
        if(n1 >= n2){
            if(startIdx != -1){
                putArr(startIdx);
                if(isAnswer()) System.out.println("Yes");
                else System.out.println("No");
            } else {
                System.out.println("No");
            }
        } else {
            System.out.println("No");
        }

    }

    private static int getStartIdx(){
        for(int i = 0; i < n1Arr.length; i++){
            if(n1Arr[i] == n2Arr[0]) return i;
        }

        return -1;
    }

    private static boolean isAnswer(){
        for(int i = 0; i < n2Arr.length; i++){
            if(n2Arr[i] != sliceArr[i]) return false;
        }

        return true;
    }

    private static void putArr(int idx){
        for(int i = 0; i < n2Arr.length; i++){
            sliceArr[i] = n1Arr[idx++];
        }
    }
}