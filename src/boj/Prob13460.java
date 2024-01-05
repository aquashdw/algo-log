package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

// https://www.acmicpc.net/problem/13460
public class Prob13460 {
    private static char[][] board;
    private static final int[][] deltas = {
            {-1, 0},  // UP
            {1, 0},   // DOWN
            {0, -1},  // LEFT
            {0, 1}    // RIGHT
    };

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] boardSize = reader.readLine().split(" ");
        int height = Integer.parseInt(boardSize[0]);
        int width = Integer.parseInt(boardSize[1]);
        board = new char[height][];
        int[] startR = null;
        int[] startB = null;
        int[] hole = null;
        for (int i = 0; i < height; i++) {
            String line = reader.readLine();
            if (line.contains("R")) startR = new int[]{i, line.indexOf('R')};
            if (line.contains("B")) startB = new int[]{i, line.indexOf('B')};
            if (line.contains("O")) hole = new int[]{i, line.indexOf('O')};
            board[i] = line.toCharArray();
        }

        Queue<int[]> toVisit = new LinkedList<>();
        toVisit.add(new int[]{startR[0], startR[1], startB[0], startB[1], 0});
        boolean success = false;
        int minMove = Integer.MAX_VALUE;
        while (!toVisit.isEmpty() && !success) {
            int[] now = toVisit.poll();
            int[] nowR = {now[0], now[1]};
            int[] nowB = {now[2], now[3]};
            for (int i = 0; i < 4; i++) {
                int[] nextB = nextPos(nowB[0], nowB[1], i, nowR);
                // 어떤 식이든 B가 구멍에 도달하면 오답
                if (Arrays.equals(hole, nextB)) continue;

                int[] nextR = nextPos(nowR[0], nowR[1], i, nowB);
                // B는 구멍에 안들어가고 R이 들어가면 성공
                if (Arrays.equals(hole, nextR)) {
                    // 이번에 한번 움직이면 성공하는 것이다.
                    minMove = now[4] + 1;
                    success = true;
                    break;
                }

                else if (now[4] < 9)
                    toVisit.offer(new int[]{nextR[0], nextR[1], nextB[0], nextB[1], now[4] + 1});
            }
        }

        if (success)
            System.out.println(minMove);
        else
            System.out.println(-1);
    }


    private static int[] nextPos(int startY, int startX, int dir, int[] other) {
        int[] delta = deltas[dir];
        char now = board[startY][startX];
        char moving = now;
        int nowY = startY;
        int nowX = startX;
        // 가던길에 다른 구슬을 만났는지 확인
        boolean collide = false;
        while (now != '#' && now != 'O') {
            nowY += delta[0];
            nowX += delta[1];
            // 여기 다른 구슬이 있었다면 부딫힌다.
            if (other[0] == nowY && other[1] == nowX) collide = true;
            now = board[nowY][nowX];
        }
        // 벽을 만났다면,
        if (now == '#') {
            // 우선 그 직전에 멈추지만,
            int[] next = new int[]{nowY - delta[0], nowX - delta[1]};
            // 이동중에 두 구슬이 만난적 없다면 상관없지만
            if (!collide) return next;
            // 만난적 있다면 내 앞의 구슬이 벽의 앞에 멈추고, 난 그 전칸에 멈춘다.
            else return new int[]{next[0] - delta[0], next[1] - delta[1]};
        }
        // 구멍으로 나오면 충돌의 의미가 사라진다.
        else return new int[]{nowY, nowX};
    }
}
