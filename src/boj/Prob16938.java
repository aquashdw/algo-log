package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.acmicpc.net/problem/16938
public class Prob16938 {
    private static int n;
    private static int[] questions;
    private static int lowBound;
    private static int highBound;
    private static int diffRange;
    private static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] nlrx = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        n = nlrx[0];
        lowBound = nlrx[1];
        highBound = nlrx[2];
        diffRange = nlrx[3];
        questions = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        dfs(0, 0, Integer.MAX_VALUE, Integer.MIN_VALUE);
        System.out.println(count);
    }

    private static void dfs(int now, int sum, int min, int max) {
        if (sum > highBound) return;
        if (now == n) {
            if (sum >= lowBound && max - min >= diffRange) {
                count++;
            }
            return;
        }
        dfs(now + 1, sum + questions[now], Math.min(questions[now], min), Math.max(questions[now], max));
        dfs(now + 1, sum, min, max);
    }
}
