package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.IntStream;

// https://www.acmicpc.net/problem/4435
public class Prob4435 {
    private static final int[] goodScores = {1, 2, 3, 3, 4, 10};
    private static final int[] badScores = {1, 2, 2, 2, 3, 5, 10};

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(reader.readLine());
        StringBuilder answer = new StringBuilder();
        for (int test = 0; test < tests; test++) {
            answer.append(String.format("Battle %d: ", test + 1));
            int[] goodForces = Arrays.stream(reader.readLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();
            int goodTotal = IntStream.range(0, goodForces.length).map(i -> goodScores[i] * goodForces[i])
                    .sum();
            int[] badForces = Arrays.stream(reader.readLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();
            int badTotal = IntStream.range(0, badForces.length).map(i -> badScores[i] * badForces[i])
                    .sum();

            if (badTotal > goodTotal) answer.append("Evil eradicates all trace of Good\n");
            else if (goodTotal > badTotal) answer.append("Good triumphs over Evil\n");
            else answer.append("No victor on this battle field\n");
        }
        System.out.print(answer);

    }
}
