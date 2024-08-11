import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String s1 = br.readLine();
        String s2 = br.readLine();

        char[] c1 = s1.toCharArray();
        char[] c2 = s1.toCharArray();

        if(c1.length != c2.length){
            System.out.println("No");
        } else {
            Arrays.sort(c1);
            Arrays.sort(c2);

            s1 = new String(c1);
            s2 = new String(c2);

            if(s1.equals(s2)) System.out.println("Yes");
            else System.out.println("No");
        }
    }
}