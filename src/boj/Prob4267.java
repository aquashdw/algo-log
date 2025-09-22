package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.acmicpc.net/problem/4267
public class Prob4267 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n;
        StringBuilder answer = new StringBuilder();
        while ((n = Integer.parseInt(reader.readLine())) != 0) {
            int[] bags = new int[n];
            int[] counts = new int[1000000];
            int max = 0;
            int next = 0;
            while (next < n) {
                int[] line = Arrays.stream(reader.readLine().split(" "))
                        .mapToInt(Integer::parseInt).toArray();
                for (int j : line) {
                    bags[next] = j;
                    counts[j]++;
                    if (counts[j] > max) {
                        max = counts[j];
                    }
                    next++;
                }
            }
            Arrays.sort(bags);

            answer.append(max).append('\n');
            for (int i = 0; i < max; i++) {
                for (int j = i; j < n; j += max) {
                    if (j > i) answer.append(' ');
                    answer.append(bags[j]);
                }
                answer.append('\n');
            }

            answer.append('\n');
        }
        System.out.print(answer);
    }
}
