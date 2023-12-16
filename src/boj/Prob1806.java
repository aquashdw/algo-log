package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


// https://www.acmicpc.net/problem/1806
public class Prob1806 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] info = reader.readLine().split(" ");
        int N = Integer.parseInt(info[0]);
        int S = Integer.parseInt(info[1]);
        int[] numbers = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int currentSum = 0;
        int start = 0;
        int end = 0;

        int minDiff = Integer.MAX_VALUE;
        while (true) {
            if (currentSum < S) {
                if (end == N) break;
                currentSum += numbers[end];
                end++;
            }
            else {
                minDiff = Math.min(minDiff, end - start);
                currentSum -= numbers[start];
                start++;
            }
        }

        System.out.println(minDiff == Integer.MAX_VALUE ? 0 : minDiff);
    }
}
