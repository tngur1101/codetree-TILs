import java.util.*;
import java.io.*;

/*
* 최대공약수를 구하는 방법
* 유클리드 호제법을 사용하기 =>  유클리드 호제법은?
* 예) 270과 192의 최대 공약수를 구하기
* gcd(270, 192) = 270은 192*1 + 78이므로
* gcd(270, 192) = gcd(192, 78)
* 192 = 78*2 + 36이므로
* gcd(270, 192) = gcd(192, 78) = gcd(78, 36)
* 78 = 36*2 + 6이므로
* gcd(270, 192) = gcd(192, 78) = gcd(78,36) = gcd(36, 6)
* 36 = 6*6 + 0이므로
* gcd(270, 192) = gcd(192, 78) = gcd(78,36) = gcd(36, 6) = gcd(6,0) = 6
* 위 과정을 재귀를 통해서 구현하도록 하자
*/


public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        System.out.println(getGreatestCommonDivisor(n,m));
    }

    private static int getGreatestCommonDivisor(int a, int b){
        // 만약 gcd(a,b)가 있을 때 a와 b가 둘다 0이 아니면
        // a = b*Q + R이 되고
        // 그 결과 gcd(a,b) = gcd(b,R)이 된다.
        
        // 재귀를 끝내기 위한 조건
        // a 혹은 b가 0일 때
        if(a == 0 || b == 0){
            if(a == 0) return b;
            else return a;
        }

        // 만약 a가 b보다 크다면
        // a를 b로 나눠주고
        if(a >= b){
            return getGreatestCommonDivisor(b, a%b);
        }
        // 반대라면
        // b를 a로 나눠준다.
        else{
            return getGreatestCommonDivisor(a,b%a);
        }
    }
}