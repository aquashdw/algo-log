package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

// https://www.acmicpc.net/problem/3460
public class Prob3460 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(reader.readLine());
        StringBuilder answer = new StringBuilder();
        reader.lines().limit(tests).mapToInt(Integer::parseInt)
                .forEach(n -> {
                    List<Integer> indices = new ArrayList<>(7);
                    for (int i = 0; i < 20; i++) {
                        if ((n & (1 << i)) != 0) indices.add(i);
                    }
                    answer.append(indices.stream().map(String::valueOf).collect(Collectors.joining(" "))).append('\n');
                });
        System.out.print(answer);
    }
}
