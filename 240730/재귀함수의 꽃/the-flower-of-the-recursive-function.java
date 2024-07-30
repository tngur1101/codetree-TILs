import java.util.*;
import java.io.*;

public class Main {
    
    static int N;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        printNum(1, N);

    } 

    private static void printNum(int depth, int cnt){
        if(depth == 2*N){
            System.out.print(cnt +" ");
            return;
        }

        if(depth < N){
            printNum(depth+1, cnt-1);
        } else if(depth == N){
            printNum(depth+1, cnt);
        } else {
            printNum(depth+1, cnt+1);
        }

        System.out.print(cnt + " ");

    }
}