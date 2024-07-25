import java.util.*;
import java.io.*;

public class Main {

    static int n;
    static int[][] map;
    static boolean[][] border;
    
    static int totalSum;

    static int[] dx = {-1, -1, 1, 1};
    static int[] dy = {1, -1, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());

        map = new int[n+1][n+1];
        border = new boolean[n+1][n+1];

        totalSum = 0;

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                totalSum += map[i][j];
            }
        }

        int answer = Integer.MAX_VALUE;

        for(int i = 0; i < n; i++)
            for(int j = 0; j < n; j++)
                for(int k = 1; k < n; k++)
                    for(int l = 1; l < n; l++)
                        // 직사각형을 그릴 수 있는 경우에만 답을 갱신하기
                        if(possibleToDraw(i, j, k, l))
                            answer = Math.min(answer, getScore(i, j, k, l));

        System.out.print(answer);

    }


    private static int getScore(int x, int y, int k, int l) {
        int[] population = new int[5];
        
        // 경계 표시
        drawRectBorder(x, y, k, l);
        
        // 좌측 상단
        for(int i = 0; i < x - l; i++)
            for(int j = 0; j <= y + k - l && !border[i][j]; j++)
                population[0] += map[i][j]; 
        
        // 좌측 하단
        for(int i = x - l; i < n; i++)
            for(int j = 0; j < y && !border[i][j]; j++)
                population[1] += map[i][j]; 
        
        // 우측 상단
        for(int i = 0; i <= x - k; i++)
            for(int j = n - 1; j >= y + k - l + 1 && !border[i][j]; j--)
                population[2] += map[i][j]; 
        
        // 우측 하단
        for(int i = x - k + 1; i < n; i++)
            for(int j = n - 1; j >= y && !border[i][j]; j--)
                population[3] += map[i][j]; 
        
        int tempSum = 0;
        for(int i = 0; i < 4; i++){
            tempSum += population[i];
        }
        population[4] = totalSum - tempSum;
        
        int maxVal = Integer.MIN_VALUE;
        int minVal = Integer.MAX_VALUE;
        for(int i = 0; i < 5; i++) {
            maxVal = Math.max(maxVal, population[i]);
            minVal = Math.min(minVal, population[i]);
        }
        return maxVal - minVal;
    }

    public static void drawRectBorder(int x, int y, int k, int l) {
        int[] moveNum = new int[]{k, l, k, l};
        
        for(int i = 0; i < n; i++)
            for(int j = 0; j < n; j++)
                border[i][j] = false;
        
        // 기울어진 직사각형의 경계를 따라가기
        for(int d = 0; d < 4; d++)
            for(int q = 0; q < moveNum[d]; q++) {
                x += dx[d]; y += dy[d];
                border[x][y] = true;
            }
    }

    // 가장 아래 지점을 제외한 3개의 꼭짓점이 전부 격자 안에 있는 경우에만 정사각형 그리기 가능
    public static boolean possibleToDraw(int x, int y, int k, int l) {
        return inRange(x - k, y + k) && inRange(x - k - l, y + k - l)
            && inRange(x - l, y - l);
    }

    private static boolean inRange(int x, int y) {
        return 0 <= x && x < n && 0 <= y && y < n;
    }
    
}