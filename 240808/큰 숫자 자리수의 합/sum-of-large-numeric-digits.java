import java.util.*;
import java.io.*;

public class Main {

    static int[] arr = new int[3];

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < 3; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int result = multiple(0);

        result = sumEachNumber(result);
        System.out.println(result);

    }

    private static int multiple(int depth){
        if(depth == 2){
            return arr[depth];
        }

        return arr[depth] * multiple(depth+1);
    }

    private static int sumEachNumber(int num){
        int sum = 0;
        while(num > 10){
            sum += num%10;
            num /= 10;
        }

        sum += num;
        return sum;
    }
}