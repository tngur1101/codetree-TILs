import java.util.*;
import java.io.*;

// a진수로 표현된 어떤 수를 10진수로 변환 후, 해당 수를 다시 b진수로 변환한다.

public class Main {
    static int[] arr;
    static  Stack<Integer> stack = new Stack<>();
    static int A,B;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        char[] origin = br.readLine().toCharArray();
        arr = new int[origin.length];
        for(int i = 0; i < arr.length; i++){
            arr[i] = origin[i] - '0';
        }

        int temp = convertToDec();
        decToB(temp);
        System.out.println(getAnswer());

    }

    private static int convertToDec(){
        int dec = 0;
        for(int i = arr.length -1; i >= 0; i--){
            dec += (int)Math.pow(A, arr.length-1-i)*arr[i];
        }
        return dec;
    }

    private static void decToB(int n){
        if(n < B){
            stack.push(n);
            return;
        }

        stack.push(n % B);
        decToB(n / B);
    }

    private static String getAnswer(){
        String answer = "";
        while(!stack.isEmpty()){
            answer += stack.pop();
        }
        return answer;
    }
}