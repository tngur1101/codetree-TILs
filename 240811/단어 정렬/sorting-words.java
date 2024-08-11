import java.util.*;
import java.io.*;

public class Main {

    static String[] arr;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        arr = new String[n];

        for(int i = 0; i < n; i++){
            arr[i] = br.readLine();
        }

        Arrays.sort(arr);

        for(int i = 0; i < n; i++){
            System.out.println(arr[i]);
        }

    }
}