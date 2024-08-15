import java.util.*;
import java.io.*;

public class Main {

    static int N;
    static class Person implements Comparable<Person>{
        String name;
        String address;
        String region;
        public Person(String name, String address, String region){
            this.name = name;
            this.address = address;
            this.region = region;
        }
        public int compareTo(Person p){
            return p.name.compareTo(this.name);
        }
    }
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
            String address = st.nextToken();
            String region = st.nextToken();
            persons[i] = new Person(name, address, region);
        }

        Arrays.sort(persons);
        System.out.println("name " + persons[0].name);
        System.out.println("addr " + persons[0].address);
        System.out.println("city " + persons[0].region);

    }
}