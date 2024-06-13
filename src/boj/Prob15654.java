package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Collectors;

// https://www.acmicpc.net/problem/15654
public class Prob15654 {
    private static final StringBuilder answer = new StringBuilder();
    private static int[] selected;
    private static boolean[] visited;
    private static int[] nums;
    private static int n;
    private static int m;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] nm = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        n = nm[0];
        m = nm[1];
        selected = new int[m];
        visited = new boolean[n];

        nums = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .sorted()
                .toArray();

        perm(0);
        System.out.print(answer);
    }

    private static void perm(int next) {
        if (next == m) {
            answer.append(Arrays.stream(selected).mapToObj(String::valueOf)
                    .collect(Collectors.joining(" ")))
                    .append('\n');
            return;
        }
        for (int i = 0; i < n; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            selected[next] = nums[i];
            perm(next + 1);
            visited[i] = false;
        }
    }
}

