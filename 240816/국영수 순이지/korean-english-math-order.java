import java.util.*;
import java.io.*;

public class Main {
    static class Grade implements Comparable<Grade>{
        String name;
        int kor;
        int eng;
        int math;
        public Grade(String name, int kor, int eng, int math){
            this.name = name;
            this.kor = kor;
            this.eng = eng;
            this.math = math;
        }
        public int compareTo(Grade g){
            if(this.kor != g.kor) return g.kor - this.kor;
            if(this.eng != g.eng) return g.eng - this.eng;
            return g.math - this.math;
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
            int kor = Integer.parseInt(st.nextToken());
            int eng = Integer.parseInt(st.nextToken());
            int math = Integer.parseInt(st.nextToken());
            grades[i] = new Grade(name, kor, eng, math);
        }

        Arrays.sort(grades);

        for(int i = 0; i < N; i++){
            System.out.println(grades[i].name + " " + grades[i].kor + " " + grades[i].eng + " " + grades[i].math);
        }

    }
}