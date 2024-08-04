import java.util.*;
import java.io.*;

public class Main {
    static class Person implements Comparable<Person>{
        String name;
        int height;
        double weight;
        public Person(String name, int height, double weight){
            this.name = name;
            this.height = height;
            this.weight = weight;
        }
        @Override
        public int compareTo(Person p){
            return this.name.compareTo(p.name);
        }
    }

    static class heightComparator implements Comparator<Person> {
        @Override
        // 내림차순 : p1.height - p2.height
        // 오름차순 : p2.height - p1.height
        public int compare(Person p1, Person p2){
            return p2.height - p1.height;
        }
    }
    static Person[] persons = new Person[5];
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for(int i = 0; i < 5; i++){
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int height = Integer.parseInt(st.nextToken());
            double weight = Double.parseDouble(st.nextToken());
            persons[i] = new Person(name, height, weight);
        }

        Arrays.sort(persons);
        System.out.println("name");  
        for(Person p: persons){
            System.out.println(p.name + " " + p.height + " " + p.weight);
        }

        System.out.println();  
        Arrays.sort(persons, new heightComparator());
        System.out.println("height");
        for(Person p: persons) {
            System.out.println(p.name + " " + p.height + " " + p.weight);
        }
    }
}