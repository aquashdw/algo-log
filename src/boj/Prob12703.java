package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

// https://www.acmicpc.net/problem/12703
public class Prob12703 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(reader.readLine());
        StringBuilder answer = new StringBuilder();
        for (int test = 0; test < tests; test++) {
            answer.append("Case #").append(test + 1).append(": ");
            int[] info = Arrays.stream(reader.readLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();

            int goal = info[1];
            int[][] dp = new int[info[0] + 1][2];
            for (int[] row : dp) Arrays.fill(row, -1);
            int[] gates = new int[(info[0] - 1) / 2 + 1];
            Set<Integer> canSwap = new HashSet<>();
            for (int i = 1; i <= (info[0] - 1) / 2; i++) {
                int[] node = Arrays.stream(reader.readLine().split(" "))
                        .mapToInt(Integer::parseInt).toArray();
                gates[i] = node[0];
                if (node[1] == 1) canSwap.add(i);
            }
            for (int i = (info[0] - 1) / 2 + 1; i <= info[0]; i++) {
                int node = Integer.parseInt(reader.readLine());
                dp[i][node] = 0;
            }

            for (int right = info[0]; right > 1; right -= 2) {
                int left = right - 1;
                int parent = left / 2;
                int gate = gates[parent];
                // gate is AND
                if (gate == 1) {
                    // min to make this node 0 (smaller of dp[l | r][0])
                    // who are not -1
                    if (dp[left][0] != -1 && dp[right][0] != -1) dp[parent][0] = Math.min(dp[left][0], dp[right][0]);
                    else if (dp[left][0] != -1) dp[parent][0] = dp[left][0];
                    else if (dp[right][0] != -1)
                        dp[parent][0] = dp[right][0];
                    // min to make this node 1
                    // both must become 1, which is the sum of dp[l | r][1]
                    // if they are not -1
                    if (dp[left][1] != -1 && dp[right][1] != -1)
                        dp[parent][1] = dp[left][1] + dp[right][1];
                }
                // gate is OR
                else if (gate == 0) {
                    // min to make this node 0
                    // both must become 0, which is the sum of dp[l | r][0]
                    // if they are not -1
                    if (dp[left][0] != -1 && dp[right][0] != -1)
                        dp[parent][0] = dp[left][0] + dp[right][0];
                    // min to make this node 1
                    // smaller of dp[l | r][1] when they are not -1
                    if (dp[left][1] != -1 && dp[right][1] != -1) dp[parent][1] = Math.min(dp[left][1], dp[right][1]);
                    else if (dp[left][1] != -1) dp[parent][1] = dp[left][1];
                    else if (dp[right][1] != -1) dp[parent][1] = dp[right][1];
                }

                // if this gate cannot be swapped, skip this
                if (!canSwap.contains(parent)) continue;
                // if was AND, swap to OR and compare costs
                if (gate == 1) {
                    // to make this node 0 with OR
                    if (dp[left][0] != -1 && dp[right][0] != -1)
                        dp[parent][0] = Math.min(
                                // add 1 for swapping
                                dp[left][0] + dp[right][0] + 1,
                                // compare if possible without swapping
                                dp[parent][0] != -1 ? dp[parent][0] : Integer.MAX_VALUE
                        );

                    // to make this node 1 with OR
                    if (dp[left][1] != -1 && dp[right][1] != -1) {
                        // at least one is 1, add 1 for swapping
                        int subMin = Math.min(dp[left][1], dp[right][1]) + 1;
                        // compare if possible without swapping
                        if (dp[parent][1] != -1) dp[parent][1] = Math.min(dp[parent][1], subMin);
                        else dp[parent][1] = subMin;
                    } else if (dp[left][1] != -1) {
                        if (dp[parent][1] != -1) dp[parent][1] = Math.min(dp[left][1] + 1, dp[parent][1]);
                        else dp[parent][1] = dp[left][1] + 1;
                    } else if (dp[right][1] != -1) {
                        if (dp[parent][1] != -1) dp[parent][1] = Math.min(dp[right][1] + 1, dp[parent][1]);
                        else dp[parent][1] = dp[right][1] + 1;
                    }
                }
                // if was OR, swap to AND and compare costs
                else if (gate == 0) {
                    // to make this node 0 with AND
                    if (dp[left][0] != -1 && dp[right][0] != -1) {
                        int subMin = Math.min(dp[left][0], dp[right][0]) + 1;
                        if (dp[parent][0] != -1) dp[parent][0] = Math.min(dp[parent][0], subMin);
                        else dp[parent][0] = subMin;
                    } else if (dp[left][0] != -1) {
                        if (dp[parent][0] != -1) dp[parent][0] = Math.min(dp[parent][0], dp[left][0] + 1);
                        else dp[parent][0] = dp[left][0] + 1;
                    } else if (dp[right][0] != -1) {
                        if (dp[parent][0] != -1) dp[parent][0] = Math.min(dp[parent][0], dp[right][0] + 1);
                        else dp[parent][0] = dp[right][0] + 1;
                    }
                    // to make this node 1 with AND
                    if (dp[left][1] != -1 && dp[right][1] != -1)
                        dp[parent][1] = Math.min(
                                // add 1 for swapping
                                dp[left][1] + dp[right][1] + 1,
                                // compare if possible without swapping
                                dp[parent][1] != -1 ? dp[parent][1] : Integer.MAX_VALUE
                        );

                }
            }
            answer.append(dp[1][goal] != -1 ? dp[1][goal] : "IMPOSSIBLE").append('\n');
        }
        System.out.print(answer);
    }

}
