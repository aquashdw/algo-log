package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.IntStream;

// https://www.acmicpc.net/problem/5912
public class Prob5912 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] nk = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int[] diff = new int[nk[0] + 1];
        reader.lines().limit(nk[1]).forEach(line -> {
            int[] range = Arrays.stream(line.split(" "))
                    .mapToInt(Integer::parseInt)
                    .map(i -> i - 1)
                    .toArray();
            diff[range[0]]++;
            diff[range[1] + 1]--;
        });

        int[] stacks = new int[nk[0]];
        IntStream.range(0, nk[0]).reduce(0, (last, idx) -> {
            int now = last + diff[idx];
            stacks[idx] = now;
            return now;
        });
        Arrays.sort(stacks);
        System.out.println(stacks[nk[0] / 2]);
    }
}
