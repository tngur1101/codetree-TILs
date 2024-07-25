import java.util.*;
import java.io.*;

public class Main {

    static class IntegerWrapper{
        int val;
        public IntegerWrapper(int val){
            this.val = val;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        IntegerWrapper aWrapper = new IntegerWrapper(a);
        IntegerWrapper bWrapper = new IntegerWrapper(b);

        calculate(aWrapper, bWrapper);

        System.out.println(aWrapper.val + " " + bWrapper.val);

    }

    private static void calculate(IntegerWrapper a, IntegerWrapper b){
        if( a.val > b.val ){
            a.val *= 2;
            b.val += 10;
        } else {
            a.val += 10;
            b.val *= 2;
        }
    }
}