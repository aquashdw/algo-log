package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.acmicpc.net/problem/1703
public class Prob1703 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();
        reader.lines().forEach(line -> {
            if (line.equals("0")) return;
            int[] info = Arrays.stream(line.split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            answer.append(branches(info)).append('\n');
        });
        System.out.print(answer);
    }

    private static int branches(int[] info) {
        int branches = 1;
        for (int i = 0; i < info[0]; i++) {
            branches *= info[2 * i + 1];
            branches -= info[2 * i + 2];
        }
        return branches;
    }
}
