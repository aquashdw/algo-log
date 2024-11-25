package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.TreeMap;

// https://www.acmicpc.net/problem/21195
public class Prob21195 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] ns = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        int n = ns[0];
        int s = ns[1];
        int[] credits = reader.lines().limit(n)
                .mapToInt(Integer::parseInt).toArray();

        TreeMap<Integer, Integer> countMap = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            countMap.merge(credits[i], 1, Integer::sum);
        }

        int maxMinValue = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            countMap.compute(credits[i], (credit, count) -> count > 1 ? count - 1 : null);
            countMap.merge(credits[i] + n * s, 1, Integer::sum);
            int now = countMap.navigableKeySet().first() - (i + 1) * s;
            maxMinValue = Math.max(maxMinValue, now);
        }

        System.out.println(maxMinValue);
    }
}
