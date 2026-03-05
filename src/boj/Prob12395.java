package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.acmicpc.net/problem/12395
public class Prob12395 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(reader.readLine());

        StringBuilder answer = new StringBuilder();
        for (int test = 1; test < tests + 1; test++) {
            int[] nm = Arrays.stream(reader.readLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();

            double[] rightProb = Arrays.stream(reader.readLine().split(" "))
                    .mapToDouble(Double::parseDouble).toArray();

            double current = 1;
            double[] avgStrokes = new double[nm[0]];
            double[] wrongProb = new double[nm[0]];

            // i is the first key that was wrong
            for (int i = 0; i < nm[0]; i++) {
                wrongProb[i] = current * (1 - rightProb[i]);
                current *= rightProb[i];
            }
            double allRight = current;
            // percentage of okay cases
            double okayProb = 0;
            // i is how many time i will hit backspace - 1
            for (int i = 0; i < nm[0]; i++) {
                // wrongProb[last - i - 1] contains the probability that
                // ith from back was the first char that was wrong,
                // which means i backspaces was enough
                // add that to okayProb
                okayProb += wrongProb[nm[0] - i - 1];
                // and calculate
                avgStrokes[i] += (okayProb + allRight) * ((i + 1) + (nm[1] - nm[0] + i + 1) + 1);
                // 1 - okayProb contains the probability for
                // the cases that is not enough with i backspaces
                // which means we need to add the entire password again
                avgStrokes[i] += (1 - okayProb - allRight) * ((i + 1) + (nm[1] - nm[0] + i + 1) + 1 + (nm[1] + 1));
            }
            // to finish and be correct, all the password i typed must be correct up til now or else reset
            double finishStrokes = allRight * (nm[1] - nm[0] + 1) + (1 - allRight) * (nm[1] - nm[0] + 1 + nm[1] + 1);
            // just start over without second guessing
            double resetStrokes = nm[1] + 2;
            answer.append(String.format("Case #%d: ", test))
                    .append(Math.min(Arrays.stream(avgStrokes).min().orElse(0.0), Math.min(finishStrokes, resetStrokes)))
                    .append('\n');

        }
        System.out.print(answer);
    }
}
