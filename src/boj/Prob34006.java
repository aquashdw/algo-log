package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

// https://www.acmicpc.net/problem/34006
public class Prob34006 {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int[] gage = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        int[] attacks = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        if (!IntStream.range(0, 3).allMatch(i -> preCheck(n, gage[i], attacks[i], attacks[(i + 1) % 3]))) {
            System.out.println(-1);
            return;
        }

        int[][] deltas = {
                {attacks[0], 0},
                {-attacks[1], attacks[1]},
                {0, -attacks[2]},
        };

        Queue<int[]> toVisit = new LinkedList<>();
        int[][] visited = new int[2 * n][2 * n];
        Arrays.stream(visited).forEach(row -> Arrays.fill(row, -1));

        toVisit.offer(new int[]{gage[0], gage[1]});
        visited[gage[0]][gage[1]] = 4;
        while (!toVisit.isEmpty()) {
            int[] now = toVisit.poll();
            for (int i = 0; i < 3; i++) {
                int[] delta = deltas[i];
                int nextX = now[0] + delta[0];
                int nextY = now[1] + delta[1];
                if (nextX < 0 || nextX >= 2 * n || nextY < 0 || nextY >= 2 * n || nextX + nextY < n || nextX + nextY >= 3 * n || visited[nextX][nextY] != -1)
                    continue;
                visited[nextX][nextY] = i;
                toVisit.offer(new int[]{nextX, nextY});
            }
            if (visited[n][n] != -1) break;
        }

        if (visited[n][n] == -1) {
            System.out.println(-1);
            return;
        }

        int[] now = {n, n};
        List<Integer> sequence = new ArrayList<>();
        while (visited[now[0]][now[1]] != 4) {
            sequence.add(visited[now[0]][now[1]]);
            int forX = now[0] - deltas[visited[now[0]][now[1]]][0];
            int forY = now[1] - deltas[visited[now[0]][now[1]]][1];
            now[0] = forX;
            now[1] = forY;
        }
        Collections.reverse(sequence);
        System.out.printf("%d%n%s%n", sequence.size(), sequence.stream()
                .map(attack -> String.valueOf((char) (attack + 'A')))
                .collect(Collectors.joining()));
    }

    private static boolean preCheck(int n, int start, int add, int sub) {
        int now = start;
        Set<Integer> found = new HashSet<>();
        found.add(now);
        while (now != n) {
            if (now < n) {
                now += add;
            } else {
                now -= sub;
            }
            if (found.contains(now)) break;
            found.add(now);
        }
        return now == n;
    }
}
