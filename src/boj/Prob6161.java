package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.acmicpc.net/problem/6161
public class Prob6161 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] nt = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int n = nt[0];
        int t = nt[1];

        int[] ratings = reader.lines().limit(n)
                .mapToInt(Integer::parseInt)
                .toArray();

        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < t; i++) {
            int maxRate = 0;
            int maxIdx = 0;
            for (int j = 0; j < n; j++) {
                if (ratings[j] <= maxRate) continue;
                maxRate = ratings[j];
                maxIdx = j;
            }

            answer.append(maxIdx + 1).append('\n');
            ratings[maxIdx] = 0;
            int fairShare = maxRate / (n - 1);
            int leftovers = maxRate % (n - 1);
            for (int j = 0; j < n; j++) {
                if (j == maxIdx) continue;
                if (leftovers > 0) {
                    ratings[j]++;
                    leftovers--;
                }
                ratings[j] += fairShare;
            }

        }

        System.out.print(answer);
    }
}
