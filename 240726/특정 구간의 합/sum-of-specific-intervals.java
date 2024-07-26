import java.util.*;
import java.io.*;

public class Main {

    static int n,m;
    static int[] A;
    

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        A = new int[n+1];
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            System.out.println(getAnswer(from, to));
        }

    }

    private static int getAnswer(int from, int to){
        int sum = 0;
        for(int i = from; i <= to; i++){
            sum += A[i];
        }
        return sum;
    }
}