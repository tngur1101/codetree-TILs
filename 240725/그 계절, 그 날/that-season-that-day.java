import java.util.*;
import java.io.*;

public class Main {

    static int y,m,d;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        y = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        if(decideSeason() == 0) System.out.println("Spring");
        else if(decideSeason() == 1) System.out.println("Summer");
        else if(decideSeason() == 2) System.out.println("Fall");
        else if(decideSeason() == 3) System.out.println("Winter");
        else System.out.println("-1");

    }

    private static boolean isLeapYear(){
        // 4의 배수인가
        if(y % 4 == 0){
            // 100의 배수인가
            if(y % 100 == 0){
                // 400의 배수인가
                if( y % 400 == 0){
                    return true;
                }
                return false;
            }
            return true;
        }
        return false;
    }

    private static boolean isDayAvaiable(){
        // 2월인데
        if(m == 2){
            // 윤년이면
            if(isLeapYear()){
                if(d > 29) return false;
            } else {
                if(d > 28) return false;
            }
        }

        if(m == 1 || m == 3 || m == 5 || m == 7 || m == 8 || m == 10 || m == 12){
            if( d > 31) return false;
        }

        if(m == 4 || m == 6 || m == 9 || m == 11){
            if( d > 30) return false;
        }

        return true;
    }

    private static int decideSeason(){
        if(isDayAvaiable()){
            if(m >= 3 && m <= 5){
                // System.out.println("봄");
                return 0;
            } else if( m >= 6 && m <= 8){
                // System.out.println("여름");
                return 1;
            } else if( m >= 9 && m <= 11){
                // System.out.println("가을");
                return 2;
            } else if( m <=2 || m >= 12){
                // System.out.println("겨울");
                return 3;
            }
        }
        return -1;
    }
}