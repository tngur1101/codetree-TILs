import java.util.*;
import java.io.*;

public class Main {

    static class Number implements Comparable<Number>{
        int num;
        int idx;
        public Number(int num, int idx){
            this.num = num;
            this.idx = idx;
        }
        public int compareTo(Number n){
            if(this.num != n.num) return this.num - n.num;
            return idx - n.idx;
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        Number[] numbers = new Number[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            numbers[i] = new Number(Integer.parseInt(st.nextToken()), i);
        }

        Arrays.sort(numbers);

        int[] answer = new int[N];
        for(int i = 0; i < N; i++){
            answer[numbers[i].idx] = i + 1;
        }

        for(int i = 0; i < N; i++){
            System.out.print(answer[i] + " ");
        }
    }
}