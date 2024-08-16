import java.util.*;
import java.io.*;

public class Main {

    static class Grade implements Comparable<Grade>{
        String name;
        int a;
        int b;
        int c;
        public Grade(String name, int a, int b, int c){
            this.name = name;
            this.a = a;
            this.b = b;
            this.c = c;
        }
        public int compareTo(Grade g){
            return (this.a + this.b + this.c) - (g.a + g.b + g.c);
        }
    }
    static int N;
    static Grade[] grades;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        grades = new Grade[N];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            grades[i] = new Grade(name, a,b,c);
        }

        Arrays.sort(grades);

        for(int i = 0; i < N; i++){
            System.out.println(grades[i].name + " " + grades[i].a + " " + grades[i].b + " " + grades[i].c);
        }


    }
}