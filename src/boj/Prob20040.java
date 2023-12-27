package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


// https://www.acmicpc.net/problem/20040
public class Prob20040 {
    private static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] info = reader.readLine().split(" ");
        int nodeCount = Integer.parseInt(info[0]);
        int edgeCount = Integer.parseInt(info[1]);

//        int[][] edges = new int[edgeCount][];
        parent = new int[nodeCount];
        for (int i = 0; i < nodeCount; i++) {
            makeSet(i);
        }

        boolean gameEnd = false;
        int turns = 0;
        for (int i = 0; i < edgeCount; i++) {
//            int start = edges[i][0];
//            int end = edges[i][1];
            int[] edge = Arrays.stream(reader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            int start = edge[0];
            int end = edge[1];

            // 2-1. 이때 start 와 end 의 대표자 원소가 다르다면
            // 이번 간선을 선택해도 사이클이 생기지 않는다.
            if (findSet(start) != findSet(end)) {
                // 선택했다면 두 정점을 같은 집합으로 만든다.
                union(start, end);
            }
            else {
                turns = i + 1;
                break;
            }
        }

        System.out.println(turns);
    }

    public static void makeSet(int node) {
        parent[node] = node;
    }

    public static int findSet(int node) {
        if (parent[node] != node)
            return findSet(parent[node]);
        return parent[node];
    }

    public static void union(int x, int y) {
        parent[findSet(y)] = findSet(x);
    }

}
