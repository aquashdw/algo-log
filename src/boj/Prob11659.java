package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.acmicpc.net/problem/11659
public class Prob11659 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] nm = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[] nums = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[] sums = new int[nm[0] + 1];
        for (int i = 0; i < nm[0]; i++) {
            sums[i + 1] = nums[i] + sums[i];
        }

        StringBuilder answer = new StringBuilder();
        reader.lines().limit(nm[1])
                .map(line -> Arrays.stream(line.split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray())
                .forEach(range -> answer.append(sums[range[1]] - sums[range[0] - 1]).append('\n'));
        System.out.print(answer);
    }
}
