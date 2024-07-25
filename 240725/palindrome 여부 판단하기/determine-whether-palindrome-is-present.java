import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String s = br.readLine();

        char[] sArr = s.toCharArray();

        // for(int i = 0; i < sArr.length; i++){
        //     System.out.println(sArr[i]);
        // }

        if(isPalindrome(sArr)) System.out.println("Yes");
        else System.out.println("No");
        
    }

    private static boolean isPalindrome(char[] arr){
        int n = arr.length;

        for(int i = 0; i < n/2; i++){
            if(arr[i] != arr[n-1-i]){
                return false;
            }
        }

        return true;
    }
}