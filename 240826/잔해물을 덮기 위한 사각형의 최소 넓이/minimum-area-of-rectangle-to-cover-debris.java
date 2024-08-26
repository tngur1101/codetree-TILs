import java.util.*;
import java.io.*;

public class Main {

    static boolean[][] map = new boolean[2001][2001];
	static int maxHeight=0, maxWidth=0;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int x1 = Integer.parseInt(st.nextToken()) + 1000;
		int y1 = Integer.parseInt(st.nextToken()) + 1000;
		int x2 = Integer.parseInt(st.nextToken()) + 1000;
		int y2 = Integer.parseInt(st.nextToken()) + 1000;
		
		drawFirstSquare(x1, x2, y1, y2);
		
		st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken()) + 1000;
		int b = Integer.parseInt(st.nextToken()) + 1000;
		int c = Integer.parseInt(st.nextToken()) + 1000;
		int d = Integer.parseInt(st.nextToken()) + 1000;
		
		coverSecondSqaure(a, c, b, d);
		
		getMaxWidthAndHeight(x1, x2, y1, y2);
		
		System.out.println("maxHeight: " + maxHeight);
		System.out.println("maxWidth: " + maxWidth);
		
		System.out.println(getAnswer());
    }

    private static void drawFirstSquare(int x1, int x2, int y1, int y2) {
		for(int i = x1; i <= x2; i++) {
			for(int j = y1; j <= y2; j++) {
				map[i][j] = true;
			}
		}
	}
	
	private static void coverSecondSqaure(int x1, int x2, int y1, int y2) {
		for(int i = x1; i <= x2; i++) {
			for(int j = y1; j <= y2; j++) {
				map[i][j] = false;
			}
		}
	}
	
	private static void getMaxWidthAndHeight(int x1, int x2, int y1, int y2) {
//		System.out.println("x1: " + x1 + ", x2: "+x2);
//		System.out.println("y1: " + y1 + ", y2: "+y2);
		
		for(int i = x1; i <= x2; i++) {
			int width = 0;
			for(int j = y1; j < y2; j++) {
				if(map[i][j]) width++;
			}
			maxWidth = Math.max(maxWidth, width);
		}
		
		for(int i = y1; i <= y2; i++) {
			int height = 0;
			for(int j = x1; j < x2; j++) {
				if(map[j][i]) {
					if(map[j][i]) height++;
				}
			}
			maxHeight = Math.max(maxHeight, height);
		}
	}
	
	private static int getAnswer() {
		return maxHeight*maxWidth;
	}
}