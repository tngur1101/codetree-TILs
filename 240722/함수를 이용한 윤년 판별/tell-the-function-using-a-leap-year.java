import java.util.*;
import java.io.*;

/*
*   윤년의 경우 4로 나누어 떨어진다.
*   이때 100으로 나누어 떨어지되 400으로 나누어 떨어지지 않는 해는 평년 처리한다. => 100으로 나누어 떨어지면서 400으로 나누어 떨어지면 윤년이다.
*/

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int y = Integer.parseInt(st.nextToken());

        if(checkLeapYear(y)) System.out.println("true");
        else System.out.println("false");
    }

    private static boolean checkLeapYear(int y){
        // 우선적으로 4로 나누어 떨어지는지 확인
        if(y%4 == 0){
            // 4로 나누어 떨어지면
            // 100으로 나누어 떨어지면서 400으로 나누어 떨어지지 않는지 확인
            if(y%100 == 0 && y%400 != 0){
                return false;
            }
            return true;
        }
        return false;
    }
}