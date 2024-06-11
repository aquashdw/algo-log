package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Collectors;

// https://www.acmicpc.net/problem/15650
public class Prob15650 {
    private static final StringBuilder answer = new StringBuilder();
    private static int n;
    private static int m;
    private static int[] selected;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] nm = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        n = nm[0];
        m = nm[1];
        selected = new int[m];
        dfs(0, 0);
        System.out.print(answer);
    }

    private static void dfs(int last, int level) {
        if (level == m) {
            answer.append(Arrays.stream(selected)
                    .mapToObj(String::valueOf)
                    .collect(Collectors.joining(" ")));
            answer.append('\n');
            return;
        }
        for (int i = last + 1; i <= n; i++) {
            selected[level] = i;
            dfs(i, level + 1);
        }
    }
}
