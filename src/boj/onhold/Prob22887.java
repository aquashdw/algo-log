package boj.onhold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

// https://www.acmicpc.net/problem/22887
public class Prob22887 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(reader.readLine());
        StringBuilder answer = new StringBuilder();
        for (int test = 0; test < tests; test++) {
            int[] nc = Arrays.stream(reader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            int n = nc[0];
            int totalCost = nc[1];

            if (totalCost < n - 1) {
                answer.append(String.format("Case #%d: IMPOSSIBLE%n", test + 1));
                continue;
            }

            if (totalCost > (n * (n + 1)) / 2 - 1) {
                answer.append(String.format("Case #%d: IMPOSSIBLE%n", test + 1));
                continue;
            }

            totalCost -= n - 1;
            int[] revIdx = IntStream.range(0, n).toArray();
            for (int i = 0; i < n - 1; i++) {
                int useCost = Math.min(n - 1 - i, totalCost);
                revIdx[i] = useCost + i;
                totalCost -= useCost;
            }

            int[] array = IntStream.range(1, n + 1).toArray();
            for (int i = n - 2; i > -1; i--) {
                int endIdx = revIdx[i];
                reverseRange(array, i, endIdx);
            }

            String numbers = Arrays.stream(array).mapToObj(String::valueOf).collect(Collectors.joining(" "));
            answer.append(String.format("Case #%d: %s%n", test + 1, numbers));
        }

        System.out.println(answer);
    }

    private static void reverseRange(int[] array, int startInc, int endInc) {
        while (startInc < endInc) {
            int temp = array[startInc];
            array[startInc] = array[endInc];
            array[endInc] = temp;
            startInc++;
            endInc--;
        }
    }
}
/*
10
4 1
4 2
4 3
4 4
4 5
4 6
4 7
4 8
4 9
4 10
 */
/*
15
5 1
5 2
5 3
5 4
5 5
5 6
5 7
5 8
5 9
5 10
5 11
5 12
5 13
5 14
5 15
 */