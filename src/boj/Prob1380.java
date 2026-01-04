package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.IntStream;

// https://www.acmicpc.net/problem/1380
public class Prob1380 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();
        String line;
        int test = 0;
        while (!(line = reader.readLine()).equals("0")) {
            test++;
            int n = Integer.parseInt(line);
            String[] names = reader.lines().limit(n).toArray(String[]::new);
            int[] count = new int[n];
            reader.lines().limit(2 * n - 1)
                    .map(earing -> earing.split(" ")[0])
                    .mapToInt(Integer::parseInt)
                    .forEach(i -> count[i - 1]++);
            int mad = IntStream.range(0, n).filter(i -> count[i] == 1).findFirst().orElseThrow();
            answer.append(test).append(' ').append(names[mad]).append('\n');
        }
        System.out.print(answer);
    }
}
