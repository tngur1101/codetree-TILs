import java.util.*;
import java.io.*;

public class Main {

    static int N;
    static int[] A,B;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        A = new int[N];
        B = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i= 0; i < N; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i= 0; i < N; i++){
            B[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(A);
        Arrays.sort(B);

        if(isSame()){
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }

    private static boolean isSame(){
        for(int i = 0; i < N; i++){
            if(A[i] != B[i]) return false;
        }
        return true;
    }


}