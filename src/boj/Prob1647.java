package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


// https://www.acmicpc.net/problem/1647
public class Prob1647 {
    private static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] info = reader.readLine().split(" ");
        int nodeCount = Integer.parseInt(info[0]);
        if (nodeCount == 2) {
            System.out.println(0);
            return;
        }
        int edgeCount = Integer.parseInt(info[1]);
        int[][] edges = new int[edgeCount][];
        for (int i = 0; i < edgeCount; i++) {
            edges[i] = Arrays.stream(reader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }
        parent = new int[nodeCount + 1];
        Arrays.sort(edges, Comparator.comparingInt(o -> o[2]));
        int totalWeight = 0;
        for (int i = 0; i < nodeCount; i++) {
            makeSet(i);
        }

        int picked = 0;

        for (int i = 0; i < edgeCount; i++) {
            int start = edges[i][0];
            int end = edges[i][1];

            if (findSet(start) != findSet(end)) {
                union(start, end);
                picked++;
                totalWeight += edges[i][2];
            }
            if (picked == nodeCount - 2) break;
        }

        System.out.println(totalWeight);
    }

    public static void makeSet(int node) {
        parent[node] = node;
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
