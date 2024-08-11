import java.util.*;
import java.io.*;

public class Main {

    static int N;
    static int[] arr;
    static int answer;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        answer = Integer.MAX_VALUE;
        getAnswer();

        System.out.println(answer);
    }

    private static void getAnswer(){
        // 1번째 집부터 N번째 집까지 하나씩 선택하면서 거리 계산
        for(int i = 0; i < N; i++){
            int tempDist = 0;

            // i: 선택한 집의 번호
            // j: 각 집
            for(int j = 0; j < N; j++){
                // i와 j가 같으면 continue
                if(i == j) continue;
                // 거리 계산은 절댓값으로 계산한다.
                int dist = Math.abs(i - j);
                tempDist += arr[j] * dist;
            }
            answer = Math.min(tempDist, answer);
        }
    }
}