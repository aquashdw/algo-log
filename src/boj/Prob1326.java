package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;


// https://www.acmicpc.net/problem/1326
public class Prob1326 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int[] rocks = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int[] path = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        int start = path[0] - 1;
        int goal = path[1] - 1;
        if (start == goal) {
            System.out.println(0);
            return;
        }
        int[] jumps = new int[n];
        Arrays.fill(jumps, -1);
        jumps[start] = 0;
        Queue<Integer> toVisit = new ArrayDeque<>();
        toVisit.add(start);
        while (!toVisit.isEmpty() && jumps[goal] == -1) {
            int now = toVisit.poll();
            int jump = rocks[now];
            int next = now + jump;
            while (next < n) {
                jumps[next] = Math.min(jumps[now] + 1, jumps[next] == -1 ? Integer.MAX_VALUE : jumps[next]);
                toVisit.add(next);
                next += jump;
            }
            next = now - jump;
            while (next >= 0) {
                jumps[next] = Math.min(jumps[now] + 1, jumps[next] == -1 ? Integer.MAX_VALUE : jumps[next]);
                toVisit.add(next);
                next -= jump;
            }
        }

        System.out.println(jumps[goal]);
    }
}
