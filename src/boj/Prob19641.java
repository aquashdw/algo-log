package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

// https://www.acmicpc.net/problem/19641
public class Prob19641 {
    private static List<List<Integer>> adjList;
    private static int[][] lrRecord;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int total = Integer.parseInt(reader.readLine());
        adjList = new ArrayList<>(total + 1);
        lrRecord = new int[total + 1][2];
        adjList.add(null);
        for (int i = 0; i < total; i++) {
            adjList.add(new ArrayList<>());
        }
        reader.lines().limit(total).forEach(line -> {
            String[] edgeInfo = line.split(" ");
            int node = Integer.parseInt(edgeInfo[0]);
            Arrays.stream(edgeInfo).skip(1)
                    .forEach(token -> {
                        int i = Integer.parseInt(token);
                        if (i == -1) return;
                        adjList.get(node).add(i);
                    });
            Collections.sort(adjList.get(node));
        });

        int root = Integer.parseInt(reader.readLine());
        dfs(root, 1);
        StringBuilder answer = new StringBuilder();
        IntStream.range(1, total + 1)
                .forEach(i -> answer
                        .append(String.format("%d %d %d\n", i, lrRecord[i][0], lrRecord[i][1])));
        System.out.println(answer);
    }


    private static int dfs(int now, int left) {
        lrRecord[now][0] = left;

        for (int next : adjList.get(now)) {
            if (lrRecord[next][0] != 0) continue;
            left = dfs(next, left + 1);
        }
        lrRecord[now][1] = left + 1;
        return left + 1;
    }
}
/*
17
1 2 8 -1
2 3 6 -1
3 4 5 -1
4 3 -1
5 3 -1
6 7 -1
7 6 -1
8 9 12 16 -1
9 10 11 -1
10 9 -1
11 9 -1
12 13 14 15 -1
13 12 -1
14 12 -1
15 12 -1
16 17 -1
17 16 -1
1
 */