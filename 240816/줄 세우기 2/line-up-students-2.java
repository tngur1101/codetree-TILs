import java.util.*;
import java.io.*;

public class Main {
    static class Student implements Comparable<Student>{
        int idx;
        int h;
        int w;
        public Student(int idx, int h, int w){
            this.idx = idx;
            this.h = h;
            this.w = w;
        }
        public int compareTo(Student o){
            if(h != o.h) return h - o.h;
            return o.w - w;
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        Student[] students = new Student[N];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int h = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            students[i] = new Student(i+1, h, w);
        }

        Arrays.sort(students);

        for(int i = 0; i < N; i++){
            System.out.println(students[i].h + " " + students[i].w + " " + students[i].idx);
        }

    }
}