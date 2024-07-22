import java.util.*;
import java.io.*;

/*
*   소수 판별 알고리즘 : 에라토스테네스의 체
*   에라토스테네스의 체 : 소수들을 대량으로 빠르고 정확하게 구하는 알고리즘
*   1. 2부터 소수를 구하고자 하는 구간의 모든 수를 나열한다.
*   2. 소수가 되는 수의 배수를 지우면 남은 건은 소수만 된다.
*   3. 자기 자신을 제외한 2의 배수를 모두 지운다.
*   4. 남아있는 수 가운데 3은 소수이므로 오른쪽에 3을 쓴다.
*   5. 자기 자신을 제외한 3의 배수를 모두 지운다.
*   6. 남아 있는 수 가운데 5는 소수이므로 오른쪽에 5를 쓴다.
*   7. 자기 자신을 제외한 5의 배수를 모두 지운다.
8   8. 위 과정을 반복한다.
*/

public class Main {

    static boolean[] isPrime;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        isPrime = new boolean[b+1];

        isPrime();
        System.out.println(sumPrime(a,b));
    }

    private static void isPrime(){
        
        isPrime[0] = false;
        isPrime[1] = false;

        // 2부터 판별한 소수의 제곱근까지 나눈다.
        for(int i = 2; i <= Math.sqrt(isPrime.length); i++){

            // 소수라면 넘어간다.
            if(isPrime[i] == true) continue;

            for(int j = i*i; j < isPrime.length; j = j+i){
                isPrime[j] = true;
            }

        }
    }

    private static int sumPrime(int a, int b){
        int ans = 0;
        for(int i = a; i <= b; i++){
            if(!isPrime[i]) {
                // System.out.println("i: "+i);
                ans += i;
            }
        }

        return ans;
    }
}