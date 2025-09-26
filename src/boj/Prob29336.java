package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

// https://www.acmicpc.net/problem/29336
public class Prob29336 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] nm = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        PriorityQueue<Long> competencies = new PriorityQueue<>(Comparator.reverseOrder());
        Arrays.stream(reader.readLine().split(" "))
                .mapToLong(Long::parseLong)
                .boxed()
                .forEach(competencies::offer);
        long[][] conditions = reader.lines().limit(nm[1])
                .map(line -> Arrays.stream(line.split(" "))
                        .mapToLong(Long::parseLong).toArray())
                .toArray(long[][]::new);

        long days = 0;
        long sum = 0;
        for (long[] condition : conditions) {
            days = condition[0];
            long required = condition[1];
            while (!competencies.isEmpty() && sum < required) {
                sum += competencies.poll() + days;
            }
            if (sum < required) {
                System.out.println(-1);
                return;
            }
        }

        for (long competency : competencies) {
            sum += competency + days;
        }
        System.out.println(sum);
    }
}
/*
1 3 4 6
0 -> pass sum 0, 2 4 5 7
1 -> add 2, sum 2, 5 6 8
2 -> pass, sum 2, 6 7 9
3 -> add 6, sum 8, 8 10
4 -> add 18, sum 26


0 -> pass, sum 0, 2 4 5 7
1 -> add 4, sum 4, 2 5 7
2 -> pass, sum 4, 3 6 8
3 -> add 6, sum 10, 4 9
4 -> add 13, sum 23
 */