package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.acmicpc.net/problem/4344
public class Prob4344 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();

        int tests = Integer.parseInt(reader.readLine());
        while (tests-- > 0) {
            int[] scores = Arrays.stream(reader.readLine().split(" ")).skip(1)
                    .mapToInt(Integer::parseInt).toArray();
            double avg = (double) Arrays.stream(scores).sum() / scores.length;
            long over = Arrays.stream(scores).filter(score -> score > avg).count();
            answer.append(String.format("%.3f", over / (double) scores.length * 100)).append("%\n");
        }
        System.out.print(answer);
    }
}
