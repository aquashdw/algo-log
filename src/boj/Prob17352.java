package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

// https://www.acmicpc.net/problem/17352
public class Prob17352 {
    private static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        parent = IntStream.range(0, n + 1).toArray();
        reader.lines().limit(n - 2).forEach(line -> {
            int[] edge = Arrays.stream(line.split(" "))
                    .mapToInt(Integer::parseInt).toArray();
            union(edge[0], edge[1]);
        });

        System.out.println(Arrays.stream(parent).skip(1)
                .map(Prob17352::findSet)
                .distinct()
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(" ")));
    }

    public static int findSet(int node) {
        if (parent[node] != node)
            parent[node] = findSet(parent[node]);
        return parent[node];
    }

    public static void union(int x, int y) {
        parent[findSet(y)] = findSet(x);
    }
}
