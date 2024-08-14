import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken())-1;
        String T = st.nextToken();

        char[] t = T.toCharArray();
        // System.out.println(t.length);

        boolean flag = true;
        ArrayList<String> list = new ArrayList<>();

        for(int i = 0; i < n; i++){
            String temp = br.readLine();
            char[] tempArr = temp.toCharArray();
            flag = true;

            for(int j = 0; j < t.length; j++){
                if(t[j] != tempArr[j]) flag = false;
            }

            if(flag) list.add(temp);
        }

        Collections.sort(list);

        // for(int i = 0; i < list.size(); i++){
        //     System.out.println(list.get(i));
        // }
        System.out.println(list.get(k));

    }
}