import java.util.*;
import java.io.*;

public class Main {

    static class Person implements Comparable<Person>{
        String name;
        int h;
        int w;
        public Person(String name, int h, int w){
            this.name = name;
            this.h = h;
            this.w = w;
        }
        public int compareTo(Person p){
            if(this.h != p.h) return this.h - p.h;
            return p.w - this.w;
        }
    }

    static int N;
    static Person[] persons;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        persons = new Person[N];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int h = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            persons[i] = new Person(name, h, w);
        }

        Arrays.sort(persons);

        for(int i = 0; i < N; i++){
            System.out.println(persons[i].name + " " + persons[i].h + " " + persons[i].w);
        }

    }
}