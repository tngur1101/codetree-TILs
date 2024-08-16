import java.util.*;
import java.io.*;

public class Main {
    static class Person implements Comparable<Person>{
        String name;
        int height;
        int weight;
        public Person(String name, int height, int weight){
            this.name = name;
            this.height = height;
            this.weight = weight;
        }
        public int compareTo(Person p){
            return this.height - p.height;
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
            int height = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            persons[i] = new Person(name, height, weight);
        }

        Arrays.sort(persons);
        for(int i = 0; i < N; i++){
            System.out.println(persons[i].name + " "+persons[i].height+" "+persons[i].weight);
        }

    }
}