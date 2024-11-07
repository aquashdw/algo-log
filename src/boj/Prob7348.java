package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.acmicpc.net/problem/7348
public class Prob7348 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(reader.readLine());
        StringBuilder answer = new StringBuilder();
        for (int test = 0; test < tests; test++) {
            int moves = Integer.parseInt(reader.readLine());
            int[] corridorUsage = new int[200];
            reader.lines().limit(moves).forEach(line -> {
                int[] move = Arrays.stream(line.split(" "))
                        .mapToInt(Integer::parseInt)
                        .map(room -> {
                            room -= 1;
                            room /= 2;
                            return room;
                        })
                        .sorted()
                        .toArray();
                for (int i = move[0]; i <= move[1]; i++) {
                    corridorUsage[i]++;
                }
            });
            answer.append(Arrays.stream(corridorUsage).max().orElse(0) * 10).append('\n');
        }
        System.out.print(answer);
    }
}
