package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.acmicpc.net/problem/18688
public class Prob18688 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(reader.readLine());
        StringBuilder answer = new StringBuilder();
        reader.lines().limit(tests).forEach(line -> {
            long[] nk = Arrays.stream(line.split(" "))
                    .mapToLong(Long::parseLong)
                    .toArray();

            answer.append((nk[0] * nk[1]) / (nk[1] + 1)).append('\n');
        });
        System.out.print(answer);
    }
}
