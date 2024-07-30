import java.util.*;
import java.io.*;

public class Main {

    static int[][] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        arr = new int[4][8];
        for(int i = 0; i < 4; i++){
            String s = br.readLine();
            for(int j = 0; j < 8; j++){
                arr[i][j] = s.charAt(j) - '0';
            }
        }

        st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());

        for(int i = 0; i < k; i++){
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken())-1;
            int d = Integer.parseInt(st.nextToken());

            simulate(n,d);
        }

        int answer = 0;
        for(int i = 0; i < 4; i++){
            answer += Math.pow(2, i) * arr[i][0];
        }

        System.out.println(answer);
    }

    private static void simulate(int n, int d){
        // 왼쪽 오른쪽 확인해주고 돌리기
        left(n-1,-d);
        right(n+1, -d);
        rotate(n,d);
    }

    private static void left(int n, int d){
        if(n >= 0){
            // 다르면 돌아야 함
            if(arr[n][2] != arr[n+1][6]){
                left(n-1, -d);
                rotate(n,d);
            }
        }
    }

    private static void right(int n, int d){
        if(n <= 3){
            if(arr[n][6] != arr[n-1][2]){
                right(n+1, -d);
                rotate(n,d);
            }
        }
    }

    private static void rotate(int n, int d){
        // 시계방향이면
        if(d == 1){
            int temp = arr[n][7];
            for(int i = 7; i > 0; i--){
                arr[n][i] = arr[n][i-1];
            }
            arr[n][0] = temp;
        } else {
            int temp = arr[n][0];
            for(int i = 0; i < 7; i++){
                arr[n][i] = arr[n][i+1];
            }
            arr[n][7] = temp;
        }
    }


}