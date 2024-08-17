import java.util.*;
import java.io.*;

public class Main {

    static int N;
    static Stack<Integer> stack = new Stack<>();

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        N= Integer.parseInt(st.nextToken());

        decToBi();
        
        System.out.println(getAnswer());

    }

    private static void decToBi(){
        while(N > 1){
            stack.push(N % 2);
            N /= 2;
        }
        stack.push(N);
    }

    private static String getAnswer(){
        String answer = "";
        
        while(!stack.isEmpty()){
            answer += stack.pop();
        }

        return answer;
    }
}