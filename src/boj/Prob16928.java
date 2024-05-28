package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

// https://www.acmicpc.net/problem/16928
public class Prob16928 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] lns = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[] ladders = new int[101];
        int[] snakes = new int[101];
        reader.lines().limit(lns[0])
                .map(line -> Arrays.stream(line.split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray())
                .forEach(ladder -> ladders[ladder[0]] = ladder[1]);
        reader.lines().limit(lns[1])
                .map(line -> Arrays.stream(line.split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray())
                .forEach(snake -> snakes[snake[0]] = snake[1]);

        int[] distance = new int[101];
        Queue<int[]> toVisit = new LinkedList<>();
        toVisit.offer(new int[]{1, 0});
        while (distance[100] == 0 && !toVisit.isEmpty()) {
            int[] now = toVisit.poll();
            for (int i = 1; i < 7; i++) {
                int next = now[0] + i;
                if (next > 100) continue;
                if (ladders[next] != 0) next = ladders[next];
                else if (snakes[next] != 0) next = snakes[next];
                int nextDist = now[1] + 1;
                if (distance[next] == 0 || distance[next] > nextDist) {
                    distance[next] = nextDist;
                    toVisit.offer(new int[]{next, nextDist});
                }
            }
        }

        System.out.println(distance[100]);
    }
}
