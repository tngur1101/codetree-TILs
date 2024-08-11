import java.util.*;
import java.io.*;

public class Main {

    static List<String> arr;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken())-1;

        String start = st.nextToken();
        arr = new ArrayList<>();
        int idx = 0;
        for(int i = 0; i < n; i++){
            String temp = br.readLine();
            if(temp.contains(start)){
                arr.add(temp);
            }
        }

        Collections.sort(arr);
        System.out.println(arr.get(k));

    }
}