import java.util.*;
import java.io.*;

public class Main {

    static boolean[] prime;
    static int a,b;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());

        prime = new boolean[b+1];

        // System.out.println("에라토스테네스의 체 하기 전");
        // System.out.println(Arrays.toString(prime));

        isPrime();

        // System.out.println("에라토스테네스의 체 한 후");
        // System.out.println(Arrays.toString(prime));

        int ans = 0;
        for(int i = a; i <= b; i++){
            if(i>=2 && !prime[i] && isEven(i)) ans++;
        }

        System.out.println(ans);

    }

    private static void isPrime(){
        for(int i = 2; i <= Math.sqrt(b); i++){
            if(prime[i]) continue;
            for(int j = i*i; j < prime.length; j = j+i){
                prime[j] = true;
            }
        }
    }

    private static boolean isEven(int num){
        int sum = 0;
        while(num > 0){
            sum += num%10;
            num /= 10;
        }
        sum += num;
        if(sum % 2 == 0) return true;
        return false;
    }
}