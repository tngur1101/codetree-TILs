import java.util.*;
import java.io.*;

public class Main {

    static class Player{
        String nickname;
        int level;
        public Player(String nickname, int level){
            this.nickname = nickname;
            this.level = level;
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        String nickname = st.nextToken();
        int level = Integer.parseInt(st.nextToken());

        Player code = new Player("codetree", 10);
        Player player = new Player(nickname, level);

        System.out.println("user "+code.nickname+" lv "+code.level);
        System.out.println("user "+player.nickname+" lv "+player.level);

    }
}