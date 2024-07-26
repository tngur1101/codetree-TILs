import java.util.*;
import java.io.*;

public class Main {

    static char[] origin;
    static char[] obj;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        origin = s.toCharArray();

        String o = br.readLine();
        obj = o.toCharArray();

        System.out.println(findIdx());

    }

    private static int findIdx(){
        int idx = -1;

        // 입력 문자열을 돌면서
        for(int i = 0; i < origin.length; i++){
            // obj[0]과 같은 애가 있으면
            if(origin[i] == obj[0]){
                // System.out.println("origin[i] == obj[0] if문 안에 들어옴");
                // System.out.println("i: "+i);

                // obj의 길이만큼 돌면서 체크
                for(int j = 1; j < obj.length; j++){
                    // 만약 i+j가 origin.length 이상이면 break
                    if(i+j > origin.length) break;
                    if(origin[i+j] != obj[j]) break;  
                    if(i+j == i+obj.length-1) {
                        idx = i;
                        return idx;
                    }
                }
            }
        }

        return idx;
    }
}