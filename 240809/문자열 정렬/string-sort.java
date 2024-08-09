import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String s = br.readLine();
        char[] arr = s.toCharArray();

        Arrays.sort(arr);

        String newS = new String(arr);
        System.out.println(newS);

    }
}