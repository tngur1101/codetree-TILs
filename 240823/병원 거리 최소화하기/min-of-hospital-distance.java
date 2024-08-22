import java.util.*;
import java.io.*;

/**
 * N x N 도시
 * 사람 - 병원 거리 : 가장 가까운 병원까지의 거리
 * 거리 계산 : Math.abs(x2-x1) + Math.abs(y2-y1)
 * m개의 병원만을 남겨두고 나머지 폐쇄 => 남은 m개의 병원에 대한 각 사람들의 병원 거리의 총 합이 최소가 되도록 설정
 *
 * 사람인 경우 1, 병원인 경우 2
 * 총 병원의 개수 중에서 m개만 남겨야 하기 때문에 m개를 뽑아야한다. 그렇다면 순서가 중요한가?
 * 순서는 별로 중요해보이지 않는다는 생각이 든다 -> 조합?
 */

public class Main {
    static class Point{
        int r;
        int c;
        public Point(int r, int c){
            this.r = r;
            this.c = c;
        }
    }
    static int N,M;
    static int[][] map;
    static List<Point> people = new ArrayList<>();
    static List<Point> hospitals = new ArrayList<>();
    static int[] selected;   // 뽑은 hospital의 idx가 들어갈 배열
    static int answer = Integer.MAX_VALUE;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        selected = new int[M];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                int temp = Integer.parseInt(st.nextToken());
                // 사람이면
                if(temp == 1) people.add(new Point(i,j));
                // 병원이면
                else if(temp == 2) hospitals.add(new Point(i,j));
            }
        }

        combination(0,0);
        System.out.println(answer);
    }

    // 조합 함수
    private static void combination(int start, int depth){
        // 기저 조건
        if(depth == M){
            int dist = calcDistance();
            answer = Math.min(answer, dist);
            return;
        }

        for(int i = start; i < hospitals.size(); i++){
            selected[depth] = i;
            combination(i+1, depth+1);
        }
    }

    private static int calcDistance(){
        int sum = 0;

        // 전체 사람들의 거리 총합을 구해야 하므로 사람을 기준으로 돈다.
        for(Point p: people){
            int minDist = Integer.MAX_VALUE;    // 가장 짧은 거리를 저장할 함수
            // 사람과 뽑힌 병원중에서 가장 가까운 거리를 찾는다.
            for(int idx: selected){
                Point h = hospitals.get(idx);
                // 거리 계산
                int dist = getDistance(p.r, h.r, p.c, h.c);
                minDist = Math.min(minDist, dist);
            }

            // 해당 사람과 가장 가까운 병원의 거리를 계산했으니 sum에 더해준다.
            sum += minDist;
        }

        return sum;
    }

    private static int getDistance(int x1, int x2, int y1, int y2){
        return Math.abs(x2 - x1) + Math.abs(y2 - y1);
    }
}