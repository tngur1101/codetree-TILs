import java.util.*;
import java.io.*;

/*
* 1. 말의 다음 이동 칸에 대한 정보 확인
* 2. 흰색,빨간색의 경우 바로 이동
* 3. 파란색이나 범위 밖이면 이동방향 바꾸고 다음 칸 정보 확인
*   3-1. 다음 칸이 흰색이나 빨간색이면 이동
*   3-2. 파란색이나 범위 밖이면 아무것도 안함
* 4. 현재 말에 업혀있는 말의 정보를 list에 넣어두고 현재 칸 0으로 만들기
* 5. 말이 4개 이상 업히면 모든 반복문 종료
* 6. 턴의 수가 1000이상이면 종료
*/

public class Main {
    static class Piece{
        int r;
        int c;
        int dir;
        int idx;
        public Piece(int r, int c, int dir, int idx){
            this.r = r;
            this.c = c;
            this.dir = dir;
            this.idx = idx;
        }
    }
    static int N,K;
    static int[][] board;
    static int[][][] move;  // 게임판 말 이동 정보 저장하는 배열
    static Piece[] pieces;
    static boolean check;
    static int answer;

    static int[] dx = {0, 0, 0, -1, 1};
    static int[] dy = {0, 1, -1, 0, 0};

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        board = new int[N][N];
        move = new int[N][N][K+1];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        pieces = new Piece[K+1];

        for(int i = 1; i <= K; i++){
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            int dir = Integer.parseInt(st.nextToken());
            pieces[i] = new Piece(r, c, dir, 0);
            move[r][c][0] = i;
        }

        answer = 1;
        simulation();
        if(answer > 1000){
            System.out.println(-1);
        } else {
            System.out.println(answer);
        }
        
    }

    private static void simulation(){
        while(true){
            for(int i = 1; i < K+1; i++){
                Piece piece = pieces[i];

                int nr = piece.r + dx[piece.dir];
                int nc = piece.c + dy[piece.dir];

                // 흰색이거나 빨간색이면
                if(isInRange(nr, nc) && (board[nr][nc] == 0 || board[nr][nc] == 1)){
                    movePiece(nr, nc, piece, board[nr][nc]);
                } else if(!isInRange(nr, nc) || board[nr][nc] == 2){    // 범위 밖이거나 파란색이면
                    // 방향 바꾸기
                    if(piece.dir == 1 || piece.dir == 3) piece.dir += 1;
                    else piece.dir -= 1;

                    // 다음 칸 확인하기
                    nr = piece.r + dx[piece.dir];
                    nc = piece.c + dy[piece.dir];

                    if(isInRange(nr, nc) && (board[nr][nc] == 0 || board[nr][nc] == 1)){
                        movePiece(nr, nc, piece, board[nr][nc]);
                    }
                }
                if(check) break;
            }
            if(answer > 1000 || check) break;
            answer++;
        }
    }

    private static void movePiece(int r, int c, Piece p, int color){
        List<Integer> list = new ArrayList<>();

        for(int i = p.idx; i <= K; i++){
            if(move[p.r][p.c][i] == 0) break;
            list.add(move[p.r][p.c][i]);
            move[p.r][p.c][i] = 0;
        }

        for(int i = 0; i <= K; i++){
            if(move[r][c][i] == 0){
                p.idx = i;
                // 흰색이면
                if(color == 0){
                    for(int j = 0; j < list.size(); j++){
                        move[r][c][i+j] = list.get(j);
                        pieces[list.get(j)] = new Piece(r, c, pieces[list.get(j)].dir, i+j);
                    }
                } else {
                    for(int j = list.size() - 1, k = 0; j >= 0; j--, k++){
                        move[r][c][i+k] = list.get(j);
                        pieces[list.get(j)] = new Piece(r, c, pieces[list.get(j)].dir, i+k);
                    }
                }

                if(i + list.size() >= 4) check = true;
                break;
            }
        }

        p.r = r;
        p.c = c;

    }

    private static boolean isInRange(int r, int c){
        return r >= 0 && c >= 0 && r < N && c < N;
    }
}