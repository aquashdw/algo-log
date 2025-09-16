package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Collectors;

// https://www.acmicpc.net/problem/9433
public class Prob9433 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(reader.readLine());
        StringBuilder answer = new StringBuilder();
        for (int test = 0; test < tests; test++) {
            int[] people = Arrays.stream(reader.readLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();

            for (int i = 19; i > 0; i--) {
                people[i - 1] += people[i] / 2;
                people[i] %= 2;
            }
            answer.append(Arrays.stream(people)
                            .mapToObj(String::valueOf)
                            .collect(Collectors.joining(" ")))
                    .append('\n');
        }
        System.out.print(answer);
    }
}
