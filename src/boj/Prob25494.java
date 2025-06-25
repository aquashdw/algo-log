package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.acmicpc.net/problem/25494
public class Prob25494 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(reader.readLine());
        StringBuilder answer = new StringBuilder();
        reader.lines().limit(tests).forEach(line -> {
            int[] abc = Arrays.stream(line.split(" ")).mapToInt(Integer::parseInt).toArray();
            int count = 0;
            for (int i = 1; i < abc[0] + 1; i++) {
                for (int j = 1; j < abc[1] + 1; j++) {
                    for (int k = 1; k < abc[2] + 1; k++) {
                        int abMod = i % j;
                        int bcMod = j % k;
                        int caMod = k % i;
                        if (abMod == bcMod && bcMod == caMod) count++;
                    }
                }
            }
            answer.append(count).append('\n');
        });
        System.out.print(answer);
    }
}
