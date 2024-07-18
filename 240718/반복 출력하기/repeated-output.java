import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        print(n);
        
    }

    private static void print(int n){
        for(int i = 0; i < n; i++){
            System.out.println("12345^&*()_");
        }
    }
}