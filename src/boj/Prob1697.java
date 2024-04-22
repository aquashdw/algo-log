package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

// https://www.acmicpc.net/problem/1697
public class Prob1697 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] nm = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int start = nm[0];
        int goal = nm[1];
        boolean[] visited = new boolean[100001];
        visited[start] = true;
        Queue<int[]> toVisit = new LinkedList<>();
        toVisit.offer(new int[]{start, 0});
        int sec = 0;
        while (!toVisit.isEmpty()) {
            int[] nowRep = toVisit.poll();
            if (nowRep[0] == goal) {
                sec = nowRep[1];
                break;
            }
            int nextR = nowRep[0] + 1;
            if (checkBounds(nextR) && !visited[nextR]) {
                toVisit.offer(new int[]{nextR, nowRep[1] + 1});
                visited[nextR] = true;
            }
            int nextL = nowRep[0] - 1;
            if (checkBounds(nextL) && !visited[nextL]) {
                toVisit.offer(new int[]{nextL, nowRep[1] + 1});
                visited[nextL] = true;
            }
            int nextBi = nowRep[0] * 2;
            if (checkBounds(nextBi) && !visited[nextBi]) {
                toVisit.offer(new int[]{nextBi, nowRep[1] + 1});
                visited[nextBi] = true;
            }
        }
        System.out.println(sec);
    }

    private static boolean checkBounds(int x) {
        return -1 < x && x < 100001;
    }
}
