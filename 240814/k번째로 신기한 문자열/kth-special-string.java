import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken()) - 1;
        String t = st.nextToken();

        String[] strArr = new String[n];
        ArrayList<String> list = new ArrayList<>();

        for(int i = 0; i < n; i++){
            strArr[i] = br.readLine();
            if(startsWith(strArr[i], t)){
                list.add(strArr[i]);
            }
        }

        Collections.sort(list);
        System.out.println(list.get(k));

    }

    private static boolean startsWith(String a, String b){
        if((int) a.length() < (int) b.length()) return false;
        for(int i = 0; i < (int) b.length(); i++){
            if(a.charAt(i) != b.charAt(i)) return false;
        }

        return true;
    }
}