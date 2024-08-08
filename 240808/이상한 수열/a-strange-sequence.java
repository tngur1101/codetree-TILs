import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        System.out.println(getAnswer(n));
    }

    private static int getAnswer(int depth){
        if(depth == 1){
            return 1;
        }
        if(depth == 2){
            return 2;
        }

        return getAnswer(depth / 3) + getAnswer(depth - 1);
    }
}