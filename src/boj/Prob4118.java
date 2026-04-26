package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

// https://www.acmicpc.net/problem/4118
public class Prob4118 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line;
        StringBuilder answer = new StringBuilder();
        while (!(line = reader.readLine()).equals("0")) {
            int n = Integer.parseInt(line);
            Set<Integer> used = new HashSet<>();
            reader.lines().limit(n)
                    .map(lotto -> Arrays.stream(lotto.split(" "))
                            .mapToInt(Integer::parseInt).toArray())
                    .forEach(arr -> Arrays.stream(arr).forEach(used::add));
            answer.append(used.size() == 49 ? "Yes" : "No").append('\n');
        }
        System.out.print(answer);
    }
}
