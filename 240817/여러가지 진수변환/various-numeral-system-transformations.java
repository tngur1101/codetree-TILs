import java.util.*;
import java.io.*;

public class Main {

    static int B;
    static Stack<Integer> stack = new Stack<>();

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st =new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());


        DectoN(N);
        System.out.println(getAnswer());

    }

    private static void DectoN(int n){
        if(n < B){
            stack.push(n);
            return;
        }

        stack.push(n % B);
        DectoN(n/B);
    }

    private static String getAnswer(){
        String answer = "";
        while(!stack.isEmpty()){
            answer += stack.pop();
        }
        return answer;
    }
}