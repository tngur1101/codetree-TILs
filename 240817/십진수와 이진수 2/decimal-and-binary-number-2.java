import java.util.*;
import java.io.*;

public class Main {

    static int[] arr;
    static Stack<Integer> stack = new Stack<>();

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] origin = br.readLine().toCharArray();

        arr = new int[origin.length];

        for(int i = 0; i < origin.length; i++){
            arr[i] = origin[i] - '0';
        }

        int temp = BiToDec();
        temp *= 17;
        DectoBi(temp);
        System.out.println(getAnswer());

    }

    private static int BiToDec(){
        int dec = 0;
        for(int i = arr.length-1; i >= 0; i--){
            dec += (int)Math.pow(2, arr.length-1-i)*arr[i];
        }
        return dec;
    }

    private static void DectoBi(int n){
        if(n == 1){
            stack.push(n);
            return;
        }

        stack.push(n % 2);
        DectoBi(n/2);
    }

    private static String getAnswer(){
        String answer = "";
        while(!stack.isEmpty()){
            answer += stack.pop();
        }
        return answer;
    }
}