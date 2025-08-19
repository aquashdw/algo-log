package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.IntStream;

// https://www.acmicpc.net/problem/20651
public class Prob20651 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int[] petals = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (i == j) {
                    count++;
                    continue;
                }

                int flowers = j - i + 1;
                int sum = IntStream.rangeClosed(i, j)
                        .map(idx -> petals[idx])
                        .sum();
                if (sum % flowers != 0) continue;
                int average = sum / flowers;
                count += IntStream.rangeClosed(i, j).anyMatch(idx -> petals[idx] == average)
                        ? 1 : 0;
            }
        }
        System.out.println(count);
    }
}
