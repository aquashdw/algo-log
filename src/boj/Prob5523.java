package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.acmicpc.net/problem/5523
public class Prob5523 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());

        int[] results = reader.lines()
                .limit(n)
                .map(line -> Arrays.stream(line.split(" "))
                        .mapToInt(Integer::parseInt).toArray())
                .reduce(new int[2], (outcome, scores) -> {
                    if (scores[0] > scores[1]) outcome[0]++;
                    else if (scores[0] < scores[1]) outcome[1]++;
                    return outcome;
                });

        System.out.printf("%d %d%n", results[0], results[1]);
    }

}
