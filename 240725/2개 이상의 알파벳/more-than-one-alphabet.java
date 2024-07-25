import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        char[] cArr = s.toCharArray();
        if(!isAnswer(cArr)) System.out.println("Yes");
        else System.out.println("No");
    }

    private static boolean isAnswer(char[] arr){
        for(int i = 0; i < arr.length-1; i++){
            if(arr[i] != arr[i+1]) return false;
        }
        return true;
    }
}