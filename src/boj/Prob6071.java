package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.acmicpc.net/problem/6071
public class Prob6071 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();
        String line;
        int testCase = 1;
        while (!(line = reader.readLine().strip()).equals("0 0")) {
            int[] nm = Arrays.stream(line.split(" "))
                    .mapToInt(Integer::parseInt).toArray();

            boolean[] deck = new boolean[nm[0] * nm[1] + 1];
            int count = 0;
            while (count < nm[1]) {
                int[] cards = Arrays.stream(reader.readLine().strip().split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray();
                count += cards.length;
                Arrays.stream(cards).forEach(i -> deck[i] = true);
            }

            int loss = 0;
            int wins = 0;
            for (int i = nm[0] * nm[1]; i > 0; i--) {
                if (deck[i]) {
                    if (loss == 0) wins++;
                    else loss--;
                } else loss++;
            }
            answer.append(String.format("Case %d: %d%n", testCase, wins));
            reader.readLine();
            testCase++;
        }
        System.out.print(answer);
    }
}
