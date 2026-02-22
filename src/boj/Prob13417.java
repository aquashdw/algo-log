package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.acmicpc.net/problem/13417
public class Prob13417 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(reader.readLine());
        StringBuilder answer = new StringBuilder();
        while (tests-- > 0) {
            int n = Integer.parseInt(reader.readLine());
            answer.append(Arrays.stream(reader.readLine().split(" "))
                    .reduce("", (prev, now) -> {
                        if (prev.isEmpty()) return now;
                        if (prev.charAt(0) >= now.charAt(0)) return String.format("%s%s", now, prev);
                        else return String.format("%s%s", prev, now);
                    }));
            answer.append('\n');
        }
        System.out.print(answer);
    }
}
