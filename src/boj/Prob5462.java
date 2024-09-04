package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.IntStream;

// https://www.acmicpc.net/problem/5462
public class Prob5462 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] ntp = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        int people = ntp[0];
        int tests = ntp[1];
        int philip = ntp[2];

        int[] points = new int[tests];
        int[] correct = new int[people];
        int[] scores = new int[people];

        int[][] resultMap = new int[people][];
        for (int i = 0; i < people; i++) {
            resultMap[i] = Arrays.stream(reader.readLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();

            for (int j = 0; j < tests; j++) {
                if (resultMap[i][j] == 0) points[j]++;
                else correct[i]++;
            }
        }

        for (int i = 0; i < people; i++) {
            for (int j = 0; j < tests; j++) {
                if (resultMap[i][j] == 1) scores[i] += points[j];
            }
        }

        int philPoint = scores[philip - 1];
        int philCorrect = correct[philip - 1];
        int pointOverPhil = (int) Arrays.stream(scores)
                .filter(score -> score > philPoint)
                .count();
        int pointSameCountOverPhil = (int) IntStream.range(0, people)
                .filter(i -> {
                    if (i == philip - 1) return false;
                    return scores[i] == philPoint && correct[i] > philCorrect;
                })
                .count();
        int pointSameCountSameFaster = (int) IntStream.range(0, philip - 1)
                .filter(i -> scores[i] == philPoint && correct[i] == philCorrect)
                .count();

        System.out.printf("%d %d%n", philPoint, pointOverPhil + pointSameCountOverPhil + pointSameCountSameFaster + 1);
    }
}
