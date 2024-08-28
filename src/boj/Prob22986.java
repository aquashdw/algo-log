package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.acmicpc.net/problem/22986
public class Prob22986 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(reader.readLine());
        StringBuilder answer = new StringBuilder();
        reader.lines().limit(tests).forEach(line -> {
            long[] info = Arrays.stream(line.split(" "))
                    .mapToLong(Long::parseLong)
                    .toArray();
            if (info[0] < info[1]) info[1] = info[0];
            long cells = (info[1] + 1) * (info[0] + info[0] - info[1]) * 2;
            answer.append(cells).append('\n');
        });
        System.out.print(answer);
    }
}
