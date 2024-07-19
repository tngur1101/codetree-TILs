import java.util.*;
import java.io.*;

public class Main {

    static int N;
    static int[][] map;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        map = new int[N][N];

        int ans = 1;

        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(ans > 9) ans = 1;
                System.out.print(ans);
                ans++;
                if(j == N-1) continue;
                System.out.print(" ");
            }
            System.out.println();
        }

    }
}