import java.util.*;
import java.io.*;

public class Main {

    static class Knight{
        int r, c;
        int h, w;
        int k;
        boolean inBoard;
        boolean isDamaged;
        int damage;

        public Knight(int r, int c, int h, int w, int k){
            this.r= r;
            this.c= c;
            this.h= h;
            this.w= w;
            this.k= k;
            inBoard = true;
            isDamaged = false;
            damage = 0;
        }
    }

    static int L,N,Q;
    static int[][] board;
    static int[][] knightBoard;
    static Knight[] knights;

    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());
        
        board = new int[L][L];
        knightBoard = new int[L][L];
        knights = new Knight[N];

        for(int i = 0; i < L; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < L; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());

            int r = Integer.parseInt(st.nextToken())-1;
            int c = Integer.parseInt(st.nextToken())-1;
            int h = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            knights[i] = new Knight(r,c,h,w,k);

            for(int j = 0; j < h; j++){
                for(int l = 0; l < w; l++){
                    knightBoard[r+j][c+l] = (i+1);
                }
            }

        }

        for(int q = 0; q < Q; q++){
            st = new StringTokenizer(br.readLine());

            int i = Integer.parseInt(st.nextToken()) - 1;
            int d = Integer.parseInt(st.nextToken());

            if(!knights[i].inBoard) continue;

            simulation(i,d);
            initIsDamaged();
        }

        System.out.println(getAnswer());
    }

    private static void simulation(int i, int d){
        if(!checkMovable(i,d)){
            return;
        }

        moveKnight(i,d);
        knights[i].isDamaged = false;
        checkDamage();
    }

    private static boolean checkMovable(int i, int d){
        for(int r = knights[i].r; r < knights[i].r + knights[i].h; r++){
            for(int c = knights[i].c; c < knights[i].c + knights[i].w; c++){
                int nr = r + dx[d];
                int nc = c + dy[d];

                if(isInRangeOrWall(nr, nc)){
                    return false;
                }

                int prevKnight = knightBoard[nr][nc];

                if(prevKnight == 0 || prevKnight == (i+1)){
                    continue;
                }
                
                // 이동하려는 위치에 다른 기사가 있는 경우, 그 기사도 함께 연쇄적으로 한칸 밀려나야함.
                if(!checkMovable(prevKnight-1, d)){
                    return false;
                }
            }
        }
        return true;
    }

    private static void moveKnight(int i, int d){
        for(int r = knights[i].r; r < knights[i].r + knights[i].h; r++){
            for(int c = knights[i].c; c < knights[i].c + knights[i].w; c++){
                int nr = r + dx[d];
                int nc = c + dy[d];

                int prevKnight = knightBoard[nr][nc];

                if(prevKnight == 0 || prevKnight == (i+1))continue;

                moveKnight(prevKnight -1, d);
            }
        }

        if(d == 0) moveUp(i,d);
        else if(d == 1) moveRight(i,d);
        else if(d == 2) moveDown(i,d);
        else if(d == 3) moveLeft(i,d);

        knights[i].isDamaged = true;
        knights[i].r += dx[d];
        knights[i].c += dy[d];
    }

    private static void moveUp(int i, int d){
        for(int r = knights[i].r; r < knights[i].r+knights[i].h; r++){
            for(int c = knights[i].c; c < knights[i].c+knights[i].w; c++){
                int nr = r + dx[d];
                int nc = c + dy[d];

                knightBoard[r][c] = 0;
                knightBoard[nr][nc] = (i+1);
            }
        }
    }

    private static void moveDown(int i, int d){
        for(int r = knights[i].r + knights[i].h -1; r >= knights[i].r; r--){
            for(int c = knights[i].c; c < knights[i].c + knights[i].w; c++){
                int nr = r + dx[d];
                int nc = c + dy[d];

                knightBoard[r][c] = 0;
                knightBoard[nr][nc] = (i+1);
            }
        }
    }

    private static void moveLeft(int i, int d){
        for(int c = knights[i].c; c < knights[i].c + knights[i].w; c++){
            for(int r = knights[i].r; r < knights[i].r + knights[i].h; r++){
                int nr = r + dx[d];
                int nc = c + dy[d];

                knightBoard[r][c] = 0;
                knightBoard[nr][nc] = (i+1);
            }
        }
    }

    private static void moveRight(int i, int d){
        for(int c = knights[i].c + knights[i].w -1; c >= knights[i].c; c--){
            for(int r = knights[i].r; r < knights[i].r + knights[i].h; r++){
                int nr = r + dx[d];
                int nc = c + dy[d];

                knightBoard[r][c] = 0;
                knightBoard[nr][nc] = (i+1);
            }
        }
    }

    private static void checkDamage(){
        for(int i = 0; i < N; i++){
            if(!knights[i].isDamaged) continue;

            int damage = countTrap(i);

            knights[i].damage += damage;
            knights[i].k -= damage;

            if(knights[i].k <= 0){
                deleteKnight(i);
            }
        }
    }

    private static int countTrap(int i){
        int cnt = 0;

        for(int r = knights[i].r; r < knights[i].r+knights[i].h; r++){
            for(int c = knights[i].c; c < knights[i].c+knights[i].w; c++){
                if(isInRangeOrWall(r,c)) continue;

                if(board[r][c] == 1) cnt++;
            }
        }

        return cnt;
    }

    private static void deleteKnight(int i){
        knights[i].inBoard = false;

        for(int r = knights[i].r; r < knights[i].r+knights[i].h; r++){
            for(int c = knights[i].c; c < knights[i].c+knights[i].w; c++){
                knightBoard[r][c] = 0;
            }
        }
    }
    
    private static void initIsDamaged(){
        for(int i = 0; i < N; i++){
            knights[i].isDamaged = false;
        }
    }

    private static int getAnswer(){
        int answer = 0;

        for(Knight knight: knights){
            if(knight.inBoard){
                answer += knight.damage;
            }
        }

        return answer;
    }

    private static boolean isInRangeOrWall(int r, int c){
        return r < 0 || c < 0 || r >= L || c >= L || board[r][c] == 2;
    }
}