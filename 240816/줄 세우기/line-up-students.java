import java.util.*;
import java.io.*;

public class Main {
    static class Student implements Comparable<Student>{
        int idx
        int height;
        int weight;
        public Student(int idx, int height, int weight){
            this.idx = idx;
            this.height = height;
            this.weight = weight;
        }
        public int compareTo(Student s){
            if(this.height != s.height) return s.height - this.height;
            if(this.weight != s.weight) return s.weight - this.weight;
            return this.idx - s.idx;
        }
    }

    static int N;
    static Student[] students;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int h = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            students[i] = new Student(i+1, h, w);
        }

        Arrays.sort(students);

        for(int i = 0; i < N; i++){
            System.out.println(students[i].height + " " + students[i].weight + " " + students[i].idx);
        }

    }
}