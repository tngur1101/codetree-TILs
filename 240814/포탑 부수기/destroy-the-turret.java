import java.util.*;
import java.io.*;

public class Main {

    static class Tower implements Comparable<Tower>{

        int r;
        int c;
        int power;
        int lastAttack;
        boolean isRelevantWithAttack;
        public Tower(int r, int c, int power, int lastAttack, boolean isRelevantWithAttack){
            this.r = r;
            this.c = c;
            this.power = power;
            this.lastAttack = lastAttack;
            this.isRelevantWithAttack = isRelevantWithAttack;
        }
        public int compareTo(Tower t){
            // 만약 공격력이 같다면
//            if(power == t.power){
//                // 만약 최근 공격한 턴 수가 같다면
//                if(lastAttack == t.lastAttack){
//                    // 열과 합이 같다면
//                    if(r+c == t.r+t.c){
//                        return t.c - c;
//                    }
//                    return (t.r + t.c) - (r+c);
//                }
//                // 최근 공격한 턴이 더 적은애를 선택
//                return t.lastAttack - lastAttack;
//            }
//            // 가장 우선 조건인 더 공격력이 작은 순으로 정렬
//            return power - t.power;
            if(power != t.power){
                return power - t.power;
            }

            if(lastAttack != t.lastAttack){
                return t.lastAttack - lastAttack;
            }

            if(r+c != t.r+t.c){
                return (t.r + t.c) - (r+c);
            }

            return t.c - c;
        }
    }
    static int N,M,K;
    static Tower[][] map;
    static Tower attacker, target;
    static int answer;
    // 우 우하 하 좌하 좌 좌상 상 우상
    static int[] dx = {0, 1, 1, 1, 0, -1, -1, -1};
    static int[] dy = {1, 1, 0, -1, -1, -1, 0, 1};

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new Tower[N][M];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                map[i][j] = new Tower(i,j,Integer.parseInt(st.nextToken()),0, false);
            }
        }

//        printMap();

        answer = 0;

        simulate();

        System.out.println(answer);
    }

    private static void simulate(){
        for(int k = 1; k <= K ; k++){

            boolean isEnd = setTowerAndAttacker(k);
//            System.out.println("k: "+k);
//            System.out.println("isEnd: "+isEnd);
            if(!isEnd) break;

            attack();
            repair();
        }
        getAnswer();
    }

    private static boolean setTowerAndAttacker(int k){
        ArrayList<Tower> list = new ArrayList<>();
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(map[i][j].power > 0){
//                    System.out.println("map["+i+"]["+j+"].power: "+map[i][j].power);
                    map[i][j].isRelevantWithAttack=false;
                    list.add(map[i][j]);
                }
            }
        }

        if(list.size() <= 1) return false;

        Collections.sort(list);

//        System.out.println("after sort list");
//        for(Tower t : list){
//            System.out.println(t.power);
//        }

        attacker = list.get(0);

//        System.out.println("attacker.r: "+attacker.r+", attacker.c: "+attacker.c+", attacker.power: "+attacker.power);

        attacker.power += (N+M);
        attacker.lastAttack = k;
        attacker.isRelevantWithAttack = true;

//        System.out.println("attacker.power: "+attacker.power);

        target = list.get(list.size()-1);

//        System.out.println("target.r: "+target.r+", target.c: "+target.c+", target.power: "+target.power);
//        System.out.println("target.power: "+target.power);
        return true;
    }

    private static void attack(){
        Queue<Tower> q = new LinkedList<>();
        boolean canAttackWithLaser = false;
        boolean[][] visited = new boolean[N][M];
        visited[attacker.r][attacker.c] = true;
        q.offer(attacker);
//        System.out.println("attacker.r: "+attacker.r+", attacker.c: "+attacker.c);

        while(!q.isEmpty()){
            Tower curTower = q.poll();

//            System.out.println("curTower.r: "+curTower.r+", curTower.c: "+curTower.c);

            if(curTower.r == target.r && curTower.c == target.c){
                canAttackWithLaser = true;
                break;
            }

            for(int d = 0; d < 8; d+=2){
//                System.out.println("d: "+d);
//                System.out.println("dx["+d+"]: "+dx[d]);
//                System.out.println("dy["+d+"]: "+dy[d]);
                int nr = (curTower.r + dx[d] + N) % N;
//                System.out.println("nr: "+nr);
                int nc = (curTower.c + dy[d] + M) % M;
//                System.out.println("nc: "+nc);
//                System.out.println("map["+nr+"]["+nc+"].power: "+map[nr][nc].power);
//                System.out.println("visited[nr][nc]: "+visited[nr][nc]);
                if(!visited[nr][nc] && map[nr][nc].power > 0){
//                    System.out.println("bfs if문 안에 들어옴");
                    visited[nr][nc] = true;
                    q.offer(map[nr][nc]);
                    break;
                }
            }
        }

//        for(int i = 0; i < N; i++){
//            for(int j = 0; j < M; j++){
//                System.out.print(visited[i][j] + " ");
//            }
//            System.out.println();
//        }

        // 레이저 공격
        if(canAttackWithLaser){
//            System.out.println("레이저 공격!");
            int curR = target.r;
            int curC = target.c;

//            System.out.println("curR: "+curR);
//            System.out.println("curC: "+curC);

            while(curR != attacker.r || curC != attacker.c){
//                System.out.println("laser 공격 while문 안에 들어옴");
                Tower tower = map[curR][curC];

//                System.out.println("map["+curR+"]["+curC+"].r: "+tower.r+ ", c: "+tower.c+", power: "+tower.power);

                for(int d = 0; d < 8; d+=2){
                    int prevR = (curR - dx[d] + N) % N;
//                    System.out.println("curR: "+curR);
//                    System.out.println("prevR: "+prevR);
                    int prevC = (curC - dy[d] + M) % M;
//                    System.out.println("curC: "+curC);
//                    System.out.println("prevC: "+prevC);

//                    System.out.println("visited[prevR][prevC]: "+visited[prevR][prevC]);
                    if(visited[prevR][prevC]){
                        curR = prevR;
                        curC = prevC;
                        break;
                    }
                }
//                System.out.println("tower.r: "+tower.r+", tower.c: "+tower.c+", tower.power: "+tower.power);
                if(tower.r != target.r  || tower.c != target.c){
                    tower.power -= attacker.power/2;
                    tower.isRelevantWithAttack = true;
                }
            }

            target.power -= attacker.power;
            target.isRelevantWithAttack = true;
//            System.out.println("target.power: "+target.power);
            return;
        } else {
            // 포탄공격
            // System.out.println("포탄 공격!");
            for(int d = 0; d < 8; d++){
                int nr = (target.r + dx[d] + N) % N;
                int nc = (target.c + dx[d] + M) % M;
                // System.out.println("nr: "+nr+", nc: "+nc);
                // System.out.println("공격력 감소 전");
                // System.out.println("map["+nr+"]["+nc+"].power: "+map[nr][nc].power);
                if(map[nr][nc].power <= 0) continue;
                if(nr == attacker.r && nc == attacker.c)continue;
                map[nr][nc].isRelevantWithAttack = true;
                map[nr][nc].power -= (attacker.power/2);
                // System.out.println("공격력 감소 후");
                // System.out.println("map["+nr+"]["+nc+"].power: "+map[nr][nc].power);
            }
            target.power -= attacker.power;
            target.isRelevantWithAttack = true;
        }
    }

    private static void repair(){
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(map[i][j].power <= 0) continue;

                if(map[i][j].isRelevantWithAttack) continue;

                map[i][j].power++;
            }
        }
    }

    private static void getAnswer(){
//        System.out.println("getAnswer");
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
//                if(map[i][j].power > answer) System.out.println("map["+i+"]["+j+"].power: "+map[i][j].power);
                answer = Math.max(map[i][j].power, answer);
            }
        }
    }
}