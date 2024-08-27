import java.util.*;
import java.io.*;

public class Main {
    static int N;
	static int[][] map;
	
	// 좌, 하, 우, 상
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {-1, 0, 1, 0};
	
	// 좌 하 우 상
	// a는 맨 마지막 인덱스 
	// 먼지가 퍼지는 x 방향
	static int[][] dsx = {{-1, 1, -2, 2, 0, -1, 1, -1, 1, 0}, {-1, -1, 0, 0, 2, 0, 0, 1, 1, 1}, {-1, 1, -2, 2, 0, -1, 1, -1, 1, 0}, {1, 1, 0, 0, -2, 0, 0, -1, -1, -1}};
	// 먼지가 퍼지는 y 방향
	static int[][] dsy = {{1, 1, 0, 0, -2, 0, 0, -1, -1, -1}, {-1, 1, -2, 2, 0, -1, 1, -1, 1, 0}, {-1, -1, 0, 0, 2, 0, 0, 1, 1, 1}, {-1, 1, -2, 2, 0, -1, 1, -1, 1, 0}};
	static int[] rate = {1, 1, 2, 2, 5, 7, 7, 10, 10};

	static int answer;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j <N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		broomstick();
		System.out.println(answer);
    }

    private static void broomstick() {
		int cr = N/2, cc = N/2, dir = 0, nr = 0, nc = 0, d = 1, cnt = 0, check = 0;
		
		while(true) {
			// 맨 왼쪽 꼭대기이면 종료
			if(cr == 0 && cc == 0) break;
			
			// 다음좌표 확인
			nr = cr + dx[dir];
			nc = cc + dy[dir];
			cnt++;
			
			move(cr, cc, nr, nc, dir);
			
			if(d == cnt) {
				cnt = 0;
				dir = (dir+1)%4;
				check++;
			}
			
			if(check == 2) {
				check = 0;
				d++;
			}
			cr = nr;
			cc = nc;
		}
	}

    // 이동하는 함수
	// cr : 현재 행, cc : 현재 열, nr : 다음 행, nc : 다음 열, curdir : 현재방향
	private static void move(int cr, int cc, int nr, int nc, int curdir) {
		// 자리 이동
		map[nr][nc] += map[cr][cc];
		// 모레 제거
		map[cr][cc] = 0;
		
		int dust = map[nr][nc];
		int a = dust;
		
		// 모래 행과 열 좌표
		int sr = 0;
		int sc = 0;
		
		for(int i = 0; i < 9; i++) {
			sr = nr + dsx[curdir][i];
			sc = nc + dsy[curdir][i];
			
			// 모래 계산
			int amount = (int)(dust * (rate[i]*0.01));
			
			if(sr < 0 || sc < 0 || sr >= N || sc >= N) answer += amount;
			else map[sr][sc] += amount;
			
			a -= amount;
		}
		
		// a칸 모래 업데이트
		// a칸 좌표 구하고
		int ar = nr + dsx[curdir][9];
		int ac = nc + dsy[curdir][9];
		
		if(ar < 0 || ac < 0 || ar >= N || ac >= N) answer += a;
		else map[ar][ac] += a;
		map[nr][nc] = 0;
		
	}
}