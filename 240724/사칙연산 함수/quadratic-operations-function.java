import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        char operator = st.nextToken().charAt(0);
        int b = Integer.parseInt(st.nextToken());

        if(operator == '+'){
            System.out.println(a + " " + operator + " " + b + " " + "= "+add(a,b));
        } else if(operator == '-'){
            System.out.println(a + " " + operator + " " + b + " " + "= "+minus(a,b));
        } else if(operator == '*'){
            System.out.println(a + " " + operator + " " + b + " " + "= "+multiple(a,b));
        } else if(operator == '/'){
            System.out.println(a + " " + operator + " " + b + " " + "= "+divide(a,b));
        } else {
            System.out.println("False");
        }
    }

    private static int add(int a, int b){
        return a + b;
    }

    private static int minus(int a, int b){
        return a -b;
    }

    private static int multiple(int a, int b){
        return a * b;
    }

    private static int divide(int a, int b){
        return (int)a/b;
    }
}