import java.util.*;
import java.io.*;

public class Main {
    static class Tile{
		int color;	// -1 : 회색, 1 : 흰색, 2 : 검은색
		int whiteCnt; // 흰색 횟수
		int blackCnt; // 검은색 횟수
		public Tile() {
			this.color = 0;
			this.whiteCnt = 0;
			this.blackCnt = 0;
		}
	}
	static Tile[] tiles = new Tile[200001];	// 타일 기
	static int N;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		
		for(int i = 0; i < tiles.length; i++) {
			tiles[i] = new Tile();
		}
		
		// 0번째 idx
		int idx = 100000;
		
		while(N-- > 0) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			String dir = st.nextToken();
			
			if(dir.equals("R")) {
//				System.out.println("계산 전 idx:" + idx);
				for(int i = idx; i < idx+x; i++) {
					tiles[i].whiteCnt+=1;
					if(tiles[i].blackCnt >= 2 && tiles[i].whiteCnt >= 2) {
						tiles[i].color = -1;
					} else {
						tiles[i].color = 2;
					}
				}
				idx += (x-1);
//				System.out.println("계산 후 idx:" + idx);
			} else {
//				System.out.println("계산 전 idx:" + idx);
				for(int i = idx; i > idx-x; i--) {
					tiles[i].blackCnt+=1;
					if(tiles[i].whiteCnt >= 2 && tiles[i].blackCnt >= 2) {
						tiles[i].color = -1;
					} else {
						tiles[i].color = 1;
					}
				}
				idx -= (x-1);
//				System.out.println("계산 후 idx:" + idx);
			}
		}
		
		
		int wCnt= 0, bCnt = 0, gCnt = 0;
		for(int i = 0; i < tiles.length; i++) {
			if(tiles[i].color == 1) {
				wCnt++;
			} else if(tiles[i].color == 2) {
				bCnt++;
			} else if(tiles[i].color == -1) {
				gCnt++;
			}
		}
		
		System.out.println(wCnt + " " + bCnt + " " + gCnt);
    }
}