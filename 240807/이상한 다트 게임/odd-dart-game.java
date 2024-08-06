import java.io.*;
import java.util.*;

/*
* r번째 원판 : 반지름이 r인 원판
* 각 원판에는 m개의 숫자가 적혀있음 => r번째 원판에 적힌 m번째 정수 (r,m)
* 12시 방향부터 m개의 정수가 시계방향 순서대로 매겨짐

* 원판을 회전하려고 하며 원판의 회전은 독립적
* 원판의 회전 요청 : 회전하는 원판의 종류 x, 방향 d, 회전 칸 수 k
* x의 경우 회전하는 원판의 번호가 x의 배수이면 회전
* d의 경우 시계방향 반시계 방향
* k의 경우 몇 칸 회전할 것인지 if 시계방향 => 1번째 정수를 1+k 번째에 위치하도록 하며 if 반시계 방향 => m번째 정수를 m-k 번째에 위치하도록 함

* 회전시킨 이후 원판에 수가 남아있으면 인접하면서 숫자가 같은 수를 지운다.
* 게임판에서 인접한 위치는 아래와 같이 결정
* (r,1)은 (r,2), (r,m)과 인접
* (n,j)는 (n-1,j)와 인접
* (r,j)는 (r-1, j), (r+1, j)와 인접
*/


public class Main {

    static int n,m,q,x,d,k;
    static int[][] map;
    static boolean[][] visited;
    static boolean flag;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int answer;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        q = Integer.parseInt(st.nextToken());

        map = new int[n][m];

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < q; i++){
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            d = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());

            simulate(x,d,k);
        }

        answer = 0;
        getAnswer();

        System.out.println(answer);

    }

    private static void getAnswer(){
        for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] != -1) {
					answer += map[i][j];
				}
			}
		}
    }

    private static void simulate(int x, int d, int k){
        int tempX = x;
		while (tempX - 1 < n) { // 회전
			if (d == 0) { // 시계방향
				for (int j = 0; j < k; j++) {
					int temp = map[tempX - 1][m - 1];
					for (int i = m - 1; i >= 1; i--) {
						map[tempX - 1][i] = map[tempX - 1][i - 1];
					}
					map[tempX - 1][0] = temp;
				}
			} else if (d == 1) { // 반시계방향
				for (int j = 0; j < k; j++) {
					int temp = map[tempX - 1][0];
					for (int i = 0; i < m - 1; i++) {
						map[tempX - 1][i] = map[tempX - 1][i + 1];
					}
					map[tempX - 1][m - 1] = temp;
				}
			}

			tempX += x;
		}

		flag = false;
		visited = new boolean[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (!visited[i][j] && map[i][j] != -1) {
					check(i, j, map[i][j]); // 인접확인하기
				}
			}
		}

		if (!flag) { // 인접하는 값이 없을때, 처리
			normalize();
		}
    }

    private static void rotate(int x, int d, int k){
        // for(int i = x; i <= n; i+=x){
        //     if(d == 0){
        //         for(int j = 0; j < k; j++){
        //             int temp = map[i -1][m-1];
        //             for(int l = m-1; l >= 1; l--){
        //                 map[i - 1][l] = map[i -1][l-1];
        //             }
        //             map[i - 1][0] = temp;
        //         }
        //     } else if( d== 1){
        //         for(int j = 0; j < k; j++){
        //             int temp = map[i - 1][0];
        //             for(int l = 0; l < m-1; l++){
        //                 map[i - 1][l] = map[i - 1][l+1];
        //             }
        //             map[i -1][m-1] = temp;
        //         }
        //     }
        // }
    }

    private static void normalize(){
        int sum = 0;
		int cnt = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] != -1) {
					sum += map[i][j];
					cnt++;
				}
			}
		}

		float avg = (float) (sum) / cnt;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] != -1) {
					if (map[i][j] < avg) {
						map[i][j] += 1;
					} else if (map[i][j] > avg) {
						map[i][j] -= 1;
					}
				}
			}
		}
    }

    private static void check(int r, int c, int v){
        visited[r][c] = true;
		for (int d = 0; d < 4; d++) {
			int nr = r + dx[d];
			int nc = c + dy[d];

			if (nc < 0) {
				nc = m - 1;
			} else if (nc >= m) {
				nc = 0;
			}

			if (0 <= nr && nr < n) {
				if (!visited[nr][nc] && map[nr][nc] == v) {
					flag = true;
					map[r][c] = -1; // -1로 변환
					map[nr][nc] = -1;
					check(nr, nc, v); // 값이 같으면 반복
				}
			}

		}
    }
}