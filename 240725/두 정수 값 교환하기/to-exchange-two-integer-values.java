import java.util.*;
import java.io.*;

/*
*   Java의 경우, 두 변수를 넘겨 swap을 하기 위해서는 Class를 새로 선언하여 진행한다.
*/

public class Main {

    static class IntWrapper{
        int value;
        public IntWrapper(int value){
            this.value = value;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        // 새로운 객체를 선언해주고 해당 객체 안에 입력받은 값을 넣어준다.
        IntWrapper nWrapper = new IntWrapper(n);
        IntWrapper mWrapper = new IntWrapper(m);

        swap(nWrapper,mWrapper);

        System.out.println(nWrapper.value+" "+mWrapper.value);

    }

    // 객체를 인자로 넣어준다. 함수는 객체를 참조하게 된다.
    private static void swap(IntWrapper a, IntWrapper b){
        int temp = b.value;
        b.value = a.value;
        a.value = temp;
    }

    
}