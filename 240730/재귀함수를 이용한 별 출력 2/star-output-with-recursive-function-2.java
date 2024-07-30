import java.util.*;
import java.io.*;

public class Main {

    static int N;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        printStars(1, N);

    }

    private static void printStars(int depth, int cnt){
        if(depth == 2*N){
            print(cnt);
            return;
        }

        if(depth < N){
            printStars(depth+1, cnt-1);
        } else if(depth == N){
            printStars(depth+1, cnt);
        } else {
            printStars(depth+1, cnt+1);
        }

        print(cnt);
    }

    private static void print(int cnt){
        for(int i = 0; i < cnt; i++){
            System.out.print("* ");
        }
        System.out.println();
    }
}