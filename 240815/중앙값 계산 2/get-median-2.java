import java.util.*;
import java.io.*;

public class Main {

    static int N;
    static ArrayList<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++){
            list.add(Integer.parseInt(st.nextToken()));
            if(i % 2 == 0){
                Collections.sort(list);
                int mid = (0+i)/2;
                sb.append(list.get(mid)).append(" ");
            }
        }

        System.out.println(sb);
    }
}