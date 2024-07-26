import java.util.*;
import java.io.*;

public class Main {

    static int N;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        printNum(N);
        printNumReverse(1);
    }

    private static void printNum(int depth){
        if(depth == 0){
            return;
        }

        printNum(depth-1);
        System.out.print(depth + " ");
    }

    private static void printNumReverse(int depth){
        if(depth == N+1){
            System.out.println();
            return;
        }

        printNumReverse(depth+1);
        System.out.print(depth + " ");
    }
}