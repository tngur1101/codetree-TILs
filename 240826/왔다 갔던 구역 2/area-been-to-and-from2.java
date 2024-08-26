import java.util.*;
import java.io.*;

/*
* 고려해야 할 것 : 만약 x L만 100번 나오고 그 모든 x가 10이라면 -10*100 = -1000
* 따라서 배열의 0번째 인덱스는 -1000부터 시작한다고 생각한다면 최대 1000이므로 배열 전체 크기를 2001로 해야한다.
*/

public class Main {
    static int N;
    static int[] arr = new int[2000]; // 이 배열은 구간기준 배열이 되어야 한다.
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        // arr[1000] : 0-1 구간이다.
        // 식 : idx - 구간의 시작 위치 = 1000;
        int idx = 1000;

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            String dir = st.nextToken();

            if(dir == "R"){
                // 2 R이면 nextIdx = 1002가 되고 이는 2-3구간이다. 따라서 포함하면 안된다.
                for(int j = idx; j <idx+x; j++){
                    arr[j] += 1;
                }
                idx = idx+x;
            } else {
                // 6 L이면 nextIdx = 996이 되고 이는 -4 ~ -3구간이다.
                for(int j = idx - x; j < idx; j++){
                    arr[j] += 1;
                }
                idx = idx-x;
            }
        }

        // System.out.println(Arrays.toString(arr));

        int answer = 0;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] > 1){
                answer += 1;
            }
        }

        System.out.println(answer);
    }
}