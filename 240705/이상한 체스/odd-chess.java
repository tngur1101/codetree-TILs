import java.util.*;
import java.io.*;

/*
* 상 우 하 좌 기준
* 1번 말 : pawn => 한 방향으로만 이동 가능 (1,0,0,0), (0,1,0,0), (0,0,1,0), (0,0,0,1)
* 2번 말 : knight => (1,0,1,0), (0,1,0,1)
* 3번 말: rook => (1,1,0,0), (0,1,1,0), (0,0,1,1), (1,0,0,1)
* 4번 말 : queen => (1,1,0,1), (1,1,1,0), (0,1,1,1), (1,0,1,1)
* 5번 말 : king => (1,1,1,1)
*
* 1. 순열을 통해 모든 경우의 수를 다 고려해준다.
*/

public class Main {
    static class Piece{
        int r;
        int c;
        int number;
        int dir;    // 방향
        int dirCnt; // 돌려봐야 할 방향의 개수
        public Piece(int r, int c, int number){
            this.r = r;
            this.c = c;
            this.number = number;
            // knight면 좌우, 상하 2가지 방향만 보면 됨
            if(number==2){
                dirCnt = 2;
            } else if(number==5){   // king이면 방향 변환이 의미 없음
                dirCnt = 1;
            } else {
                dirCnt = 4;
            }
        }
    }
    static int N,M;
    static int[][] map;
    static int[][] copyMap;
    static int answer;
    static List<Piece> pieces = new ArrayList<>();
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1}; 

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        copyMap = new int[N][M];
        answer = Integer.MAX_VALUE;

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] != 0 && map[i][j] != 6){
                    pieces.add(new Piece(i,j,map[i][j]));
                }
            }
        }

        DFS(0);
        System.out.println(answer);
        // printMap();

    }

    private static void DFS(int depth){
        if(depth == pieces.size()){
            copyArray();
            
            for(int i = 0; i < pieces.size(); i++){
                movePiece(pieces.get(i));
            }

            int sumWidth = getAnswer();
            answer = Math.min(answer, sumWidth);

            return;
        }

        Piece piece = pieces.get(depth);

        for(int d = 0; d < piece.dirCnt; d++){
            piece.dir = d;
            DFS(depth+1);
        }

    }

    private static void movePiece(Piece piece){
        int r = piece.r;
        int c = piece.c;
        int number = piece.number;
        int dir = piece.dir;

        adjustDir(r,c,dir);

        if(number == 2){
            adjustDir(r,c,(dir+2)%4);
        }
        else if(number == 3){
            adjustDir(r,c,(dir+1)%4);
        }
        else if(number == 4){
            adjustDir(r,c,(dir+1)%4);
            adjustDir(r,c,(dir+2)%4);
        }
        else if(number == 5){
            adjustDir(r,c,(dir+1)%4);
            adjustDir(r,c,(dir+2)%4);
            adjustDir(r,c,(dir+3)%4);
        }
    }

    private static void adjustDir(int r, int c, int dir){
        while(true){
            int nr = r+dx[dir];
            int nc = c+dy[dir];

            if(isInRange(nr, nc) && copyMap[nr][nc]!=6){
                copyMap[nr][nc]=-1;
                r = nr;
                c = nc;
            }

            if(!isInRange(nr, nc) || copyMap[nr][nc]==6){
                break;
            }
        }
    }

    private static boolean isInRange(int r, int c){
        return r>=0 && r<N && c>=0 && c<M;
    }

    private static int getAnswer(){
        int cnt = 0;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(copyMap[i][j] == 0){
                    cnt++;
                }
            }
        }
        return cnt;
    }

    private static void copyArray(){
        for(int i = 0; i < N; i++){
            System.arraycopy(map[i], 0, copyMap[i], 0, M);
        }
    }

    private static void printMap(){
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }
    }

    private static void printCopyMap(){
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                System.out.print(copyMap[i][j]+" ");
            }
            System.out.println();
        }
    }
}