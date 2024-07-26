import java.util.*;
import java.io.*;

public class Main {

    static int N;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        printStar(N);
    }

    private static void printStar(int depth){
        if(depth == 0) return;

        printStar(depth-1);
        for(int i = 0; i < depth; i++){
            System.out.print("*");
        }
        System.out.println();
    }
}