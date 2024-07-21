import java.util.*;
import java.io.*;

/*
* 정령은 골렘의 아무 곳에서나 탈 수 있고 정해진 출구를 통해서만 나올 수 있음
* 골렘은 숲의 가장 북쪽에서 시작해 골렘의 중앙이 ci열이 되도록 하는 위치에서 내려오기 시작함, 초기 골렘의 출구는 di방향에 있음
* 1. 남쪽으로 한칸 내려간다
* 2. 남쪽으로 내려갈 수 없으면 서쪽 방향으로 회전하면서 내려간다.
* 3. 서쪽 방향으로 회전하면서도 내려갈 수 없으면 동쪽 방향으로 회전하면서 내려간다.
* 4. 골렘이 이동할 수 있는 가장 남쪽에 도달하여 더 이상 이동이 안되면 정령은 골렘 내에서 상하좌우 인접한 칸으로 이동이 가능
*/

public class Main {

    static int R, C, K;
    static int score, rMax;
    static boolean[] v;
    static int[][] magicForest, golemMap;

    // 북, 동, 남, 서
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        score = 0;
        initMap();
        golemMap = new int[K][];

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int c = Integer.parseInt(st.nextToken()) - 1;
            int d = Integer.parseInt(st.nextToken());

            rMax = 0;
            v = new boolean[K];
            drop(i, -2, c, d);
        }

        System.out.println(score);
    }

    static void drop(int idx, int ci, int cj, int e) {
        while (true) {
            if (ci == R - 2) break;

            if ((ci == -2 && magicForest[ci + 2][cj] == -1) || (magicForest[ci + 2][cj] == -1 && magicForest[ci + 1][cj - 1] == -1 && magicForest[ci + 1][cj + 1] == -1)) {
                ci += 1;
                continue;
            }

            if (cj >= 2) {
                if ((ci == -2 && magicForest[ci + 2][cj - 1] == -1) || ((ci == -1) && magicForest[ci + 2][cj - 1] == -1 && magicForest[ci + 1][cj - 1] == -1 && magicForest[ci + 1][cj - 2] == -1) || (magicForest[ci + 2][cj - 1] == -1 && magicForest[ci + 1][cj - 1] == -1 && magicForest[ci + 1][cj - 2] == -1 && magicForest[ci][cj - 2] == -1)) {
                    ci += 1;
                    cj -= 1;
                    e = (e + 3) % 4;
                    continue;
                }
            }

            if (cj < C - 2) {
                if ((ci == -2 && magicForest[ci + 2][cj + 1] == -1) || ((ci == -1) && magicForest[ci + 2][cj + 1] == -1 && magicForest[ci + 1][cj + 1] == -1 && magicForest[ci + 1][cj + 2] == -1) || (magicForest[ci + 2][cj + 1] == -1 && magicForest[ci + 1][cj + 1] == -1 && magicForest[ci + 1][cj + 2] == -1 && magicForest[ci][cj + 2] == -1)) {
                    ci += 1;
                    cj += 1;
                    e = (e + 1) % 4;
                    continue;
                }
            }

            break;
        }

        if (ci <= 0) {
            initMap();
            return;
        }

        magicForest[ci][cj] = magicForest[ci - 1][cj] = magicForest[ci][cj + 1] = magicForest[ci + 1][cj] = magicForest[ci][cj - 1] = idx;
        golemMap[idx] = new int[]{ci, cj, e};

        moveGolem(idx);
        score += rMax;
    }

    static void moveGolem(int idx) {
        v[idx] = true;

        int ri = golemMap[idx][0] + 2;
        rMax = ri > rMax ? ri : rMax;

        int e = golemMap[idx][2];
        ri = golemMap[idx][0] + dx[e];
        int rj = golemMap[idx][1] + dy[e];

        for (int d = 0; d < 4; d++) {
            int ni = ri + dx[d];
            int nj = rj + dy[d];

            if (ni < 0 || ni >= R || nj < 0 || nj >= C) continue;
            if (magicForest[ni][nj] == -1 || v[magicForest[ni][nj]]) continue;

            moveGolem(magicForest[ni][nj]);
        }
    }

    static void initMap() {
        magicForest = new int[R][];
        for (int r = 0; r < R; r++) {
            magicForest[r] = new int[C];
            Arrays.fill(magicForest[r], -1);
        }
    }
}