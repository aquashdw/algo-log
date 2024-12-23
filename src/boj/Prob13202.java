package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

// https://www.acmicpc.net/problem/13202
public class Prob13202 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(reader.readLine());
        StringBuilder answer = new StringBuilder();
        reader.lines().limit(tests).forEach(line -> {
            int[] info = Arrays.stream(line.split(" "))
                    .mapToInt(Integer::parseInt).toArray();
            double a = info[0];
            double b = info[1];
            double c = Math.sqrt(a * a + b * b);
            int k = info[2];

            Double[] radius = new Double[3 * k + 1];
            radius[0] = (a + b - c) / 2;
            double r1 = radius[0];
            double r2 = r1;
            double r3 = r2;

            double halfAlpha = Math.sqrt((1 - b / c) / 2);
            double halfBeta = Math.sqrt((1 - a / c) / 2);
            double root2 = Math.sqrt(2);

            double rate1 = (1 - halfAlpha) / (1 + halfAlpha);
            double rate2 = (1 - halfBeta) / (1 + halfBeta);
            double rate3 = (root2 - 1) / (root2 + 1);

            for (int i = 0; i < k; i++) {
                r1 *= rate1;
                r2 *= rate2;
                r3 *= rate3;
                radius[3 * i + 1] = r1;
                radius[3 * i + 2] = r2;
                radius[3 * i + 3] = r3;
            }

            Arrays.sort(radius, Comparator.reverseOrder());
            answer.append(radius[k - 1] * radius[k - 1] * Math.PI).append('\n');
        });
        System.out.print(answer);
    }
}
