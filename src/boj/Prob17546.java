package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://www.acmicpc.net/problem/17546
public class Prob17546 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int m = Arrays.stream(reader.readLine().split(" "))
                .skip(1)
                .mapToInt(Integer::parseInt)
                .findFirst().orElseThrow();

        List<Integer> incremental = new ArrayList<>();
        List<Integer> decremental = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            int[] nodes = Arrays.stream(reader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            if (nodes[0] < nodes[1]) incremental.add(i + 1);
            else decremental.add(i + 1);
        }

        StringBuilder answer = new StringBuilder();
        if (incremental.size() < decremental.size()) {
            answer.append(incremental.size()).append('\n');
            for (int corridor : incremental) {
                answer.append(corridor).append('\n');
            }
        }
        else {
            answer.append(decremental.size()).append('\n');
            for (int corridor : decremental) {
                answer.append(corridor).append('\n');
            }
        }
        System.out.print(answer);
    }
}
