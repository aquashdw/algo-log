package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Kruskal {
    private int[] parent;
    public void solution() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer neTokenizer = new StringTokenizer(reader.readLine());  // 노드의 갯수, 간선의 갯수
        int nodeCount = Integer.parseInt(neTokenizer.nextToken());
        int edgeCount = Integer.parseInt(neTokenizer.nextToken());

        // 대표 원소 판단 배열 (findSet)
        parent = new int[nodeCount];

        // 각 간선은 시작, 끝, 가중치 정보가 주어진다.
        int[][] edges = new int[edgeCount][3];
        for (int i = 0; i < edgeCount; i++) {
            StringTokenizer edgeTokenizer = new StringTokenizer(reader.readLine());
            edges[i][0] = Integer.parseInt(edgeTokenizer.nextToken());
            edges[i][1] = Integer.parseInt(edgeTokenizer.nextToken());
            edges[i][2] = Integer.parseInt(edgeTokenizer.nextToken());
        }

        // 간선 정렬
        Arrays.sort(edges, Comparator.comparingInt(o -> o[2]));

        // 총 가중치 합
        int totalWeight = 0;

        // 간선 선정, edgeCount - 1개 까지 사이클을 만들지 않는 경우만
        // 1. 각 노드를 makeSet 한다.
        for (int i = 0; i < nodeCount; i++) {
            makeSet(i);
        }
        // 2. 간선을 순회하면서 선정한다.
        // 몇개의 간선을 골랐는지 새는 용도
        int picked = 0;
        List<String> pickedEdges = new ArrayList<>();
        for (int i = 0; i < edgeCount; i++) {
            // 이번 간선이 연결하는 정점들
            int start = edges[i][0];
            int end = edges[i][1];

            // 2-1. 이때 start 와 end 의 대표자 원소가 다르다면
            // 이번 간선을 선택해도 사이클이 생기지 않는다.
            if (findSet(start) != findSet(end)) {
                // 선택했다면 두 정점을 같은 집합으로 만든다.
                union(start, end);
                picked++;
                totalWeight += edges[i][2];
                pickedEdges.add(Arrays.toString(edges[i]));
            }
            // 3. 선택한 간선이 N-1 개가 된다면 다 선정한 것이다.
            if (picked == nodeCount - 1) break;
        }

        System.out.println(totalWeight);
        System.out.println(Arrays.toString(parent));
    }

    public void makeSet(int node) {
        parent[node] = node;
    }

    public int findSet(int node) {
        if (parent[node] != node)
            return findSet(parent[node]);
        return parent[node];
    }

    public void union(int x, int y) {
        parent[findSet(y)] = findSet(x);
    }

    public static void main(String[] args) throws IOException {
        new Kruskal().solution();
    }
}
/*
8 11
0 1 41
0 2 14
0 3 13
1 4 27
2 5 21
3 5 33
3 7 22
4 6 11
4 7 17
5 6 35
6 7 19

 */