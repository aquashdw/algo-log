package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.acmicpc.net/problem/5208
public class Prob5208 {
    private static int n;
    private static int maxUtil;
    private static int ceil;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();
        int tests = Integer.parseInt(reader.readLine());
        for (int test = 1; test < tests + 1; test++) {
            answer.append(String.format("Data Set %d:%n", test));
            int[] info = Arrays.stream(reader.readLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();
            n = info[0];
            maxUtil = Integer.MIN_VALUE;
            ceil = info[2];

            boolean[] used = new boolean[info[1] + 1];
            int[][] classes = new int[n][];
            for (int i = 0; i < n; i++) {
                classes[i] = Arrays.stream(reader.readLine().split(" "))
                        .mapToInt(Integer::parseInt).toArray();
            }
            dfs(0, 0, 0, classes, used);
            answer.append(maxUtil).append('\n');
        }
        System.out.print(answer);
    }


    private static void dfs(int k, int util, int workload, int[][] classes, boolean[] used) {
        if (k == n) {
            maxUtil = Math.max(maxUtil, util);
            return;
        }

        if (workload + classes[k][1] <= ceil && Arrays.stream(classes[k]).skip(3).noneMatch(time -> used[time])) {
            Arrays.stream(classes[k]).skip(3).forEach(time -> used[time] = true);
            dfs(k + 1, util + classes[k][0], workload + classes[k][1], classes, used);
            Arrays.stream(classes[k]).skip(3).forEach(time -> used[time] = false);
        }
        dfs(k + 1, util, workload, classes, used);
    }
}
