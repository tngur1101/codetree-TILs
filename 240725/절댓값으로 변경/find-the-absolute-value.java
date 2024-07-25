import java.util.*;
import java.io.*;

public class Main {

    static int N;
    static class IntegerWrapper{
        int val;
        public IntegerWrapper(int val){
            this.val = val;
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        IntegerWrapper[] arr = new IntegerWrapper[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){

            arr[i] = new IntegerWrapper(Integer.parseInt(st.nextToken()));
        }

        convertAbs(arr);

        for(int i = 0; i < N; i++){
            System.out.print(arr[i].val + " ");
        }

    }

    private static void convertAbs(IntegerWrapper[] arr){
        for(int i = 0; i < N; i++){
            arr[i].val = Math.abs(arr[i].val);
        }
    }
}