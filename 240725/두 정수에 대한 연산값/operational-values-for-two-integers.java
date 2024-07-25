import java.util.*;
import java.io.*;

public class Main {

    static class IntegerWrapper{
        int value;
        public IntegerWrapper(int value){
            this.value = value;
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        IntegerWrapper aWrapper = new IntegerWrapper(a);
        IntegerWrapper bWrapper = new IntegerWrapper(b);

        operation(aWrapper, bWrapper);

        System.out.println(aWrapper.value + " " + bWrapper.value);

    }

    private static void operation(IntegerWrapper a, IntegerWrapper b){
        if(a.value > b.value){
            a.value += 25;
            b.value *= 2;
        } else {
            b.value += 25;
            a.value *= 2;
        }
    }
}