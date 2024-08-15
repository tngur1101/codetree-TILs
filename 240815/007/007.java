import java.util.*;
import java.io.*;

public class Main {

    static class Mission{
        String secretCode;
        char meetingPoint;
        int time;
        public Mission(String secretCode, char meetingPoint, int time){
            this.secretCode = secretCode;
            this.meetingPoint = meetingPoint;
            this.time = time;
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        String s = st.nextToken();
        char c  = st.nextToken().charAt(0);
        int t = Integer.parseInt(st.nextToken());

        Mission mission = new Mission(s, c, t);

        System.out.println("secret code : "+mission.secretCode);
        System.out.println("meeting point : "+mission.meetingPoint);
        System.out.println("time : "+mission.time);

    }
}