package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.acmicpc.net/problem/9324
public class Prob9324 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(reader.readLine());
        StringBuilder answer = new StringBuilder();
        reader.lines().limit(tests).forEach(line -> answer.append(check(line)).append('\n'));
        System.out.print(answer);

    }

    public static String check(String message) {
        int[] letterCount = new int[26];
        int result = message.chars().map(c -> c - 'A')
                .reduce(-1, (nextConst, letter) -> {
                    if (nextConst == Integer.MIN_VALUE) return Integer.MIN_VALUE;
                    if (nextConst != -1) {
                        if (letter != nextConst) return Integer.MIN_VALUE;
                        letterCount[nextConst] = 0;
                    }
                    else {
                        letterCount[letter]++;
                        if (letterCount[letter] == 3) return letter;
                    }
                    return -1;
                });
        return result == Integer.MIN_VALUE || Arrays.stream(letterCount).anyMatch(i -> i > 2) ?
                "FAKE" : "OK";
    }
}
