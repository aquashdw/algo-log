package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.IntStream;

// https://www.acmicpc.net/problem/6526
public class Prob6526 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();
        while (true) {
            String line = reader.readLine();
            if (line.equals("0")) break;
            int n = Integer.parseInt(line);
            int[] permutation = Arrays.stream(reader.readLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();
            int[] inverse = new int[n];
            for (int i = 0; i < n; i++) {
                inverse[permutation[i] - 1] = i + 1;
            }
            answer.append(IntStream.range(0, n).allMatch(i -> inverse[i] == permutation[i]) ? "ambiguous" : "not ambiguous").append('\n');
        }
        System.out.print(answer);
    }
}
