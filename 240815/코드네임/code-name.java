import java.util.*;
import java.io.*;

public class Main {
    static class Agent implements Comparable<Agent>{
        char name;
        int score;
        public Agent(char name, int score){
            this.name = name;
            this.score = score;
        }
        public int compareTo(Agent a){
            return this.score - a.score;
        }
    }

    static Agent[] arr = new Agent[5];
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for(int i = 0; i < 5; i++){
            st = new StringTokenizer(br.readLine());
            char code = st.nextToken().charAt(0);
            int score = Integer.parseInt(st.nextToken());
            arr[i] = new Agent(code, score);
        }

        Arrays.sort(arr);
        System.out.println(arr[0].name+" "+arr[0].score);
    }
}