package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.acmicpc.net/problem/4589
public class Prob4589 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int tests = Integer.parseInt(reader.readLine());
        StringBuilder answer = new StringBuilder();
        answer.append("Gnomes:").append('\n');
        reader.lines().limit(tests)
                .map(line -> Arrays.stream(line.split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray())
                .forEach(beards -> {
                    boolean sorted = (beards[0] < beards[1] && beards[1] < beards[2])
                            || (beards[0] > beards[1] && beards[1] > beards[2]);
                    answer.append(sorted ? "Ordered" : "Unordered").append('\n');
                });
        System.out.print(answer);
    }
}
