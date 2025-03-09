package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.acmicpc.net/problem/2476
public class Prob2476 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        reader.lines().limit(n).mapToInt(line -> {
            int[] dice = Arrays.stream(line.split(" ")).mapToInt(Integer::parseInt).toArray();
            if (dice[0] == dice[1] && dice[1] == dice[2]) return 10000 + dice[0] * 1000;
            else if (dice[0] == dice[1]) return 1000 + dice[0] * 100;
            else if (dice[1] == dice[2]) return 1000 + dice[1] * 100;
            else if (dice[2] == dice[0]) return 1000 + dice[2] * 100;
            else return Math.max(dice[0], Math.max(dice[1], dice[2])) * 100;
        }).max().ifPresent(System.out::println);
    }
}
