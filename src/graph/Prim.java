package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Prim {
    public void solution() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer neTokenizer = new StringTokenizer(reader.readLine());  // 노드의 갯수, 간선의 갯수
        int nodeCount = Integer.parseInt(neTokenizer.nextToken());
        int edgeCount = Integer.parseInt(neTokenizer.nextToken());

        // 가중치가 저장된 인접 행렬을 사용한다.
        int[][] adjMatrix = new int[nodeCount][nodeCount];
        for (int i = 0; i < edgeCount; i++) {
            StringTokenizer edgeTokenizer = new StringTokenizer(reader.readLine());
            int start = Integer.parseInt(edgeTokenizer.nextToken());
            int end = Integer.parseInt(edgeTokenizer.nextToken());
            int weight = Integer.parseInt(edgeTokenizer.nextToken());
            adjMatrix[start][end] = weight;
            adjMatrix[end][start] = weight;
        }

        // 방문 정보
        boolean[] visited = new boolean[nodeCount];
        // 현재 도달 가능한 가장 짧은 거리
        int[] dist = new int[nodeCount];
        // 어느 노드에서 도달했는지 저장
        int[] parent = new int[nodeCount];

        Arrays.fill(dist, Integer.MAX_VALUE);

        // 1. 임의의 정점 선택
        dist[0] = 0;  // 시작점에 도달가능한 가장 짧은 거리는 0
        parent[0] = -1;  // 여기에 도달한 정점은 없다.

        // 모든 정점이 선택될 때 까지 임으로 정점 갯수만큼 순회
        for (int i = 0; i < nodeCount; i++) {
            int minDist = Integer.MAX_VALUE;
            int idx = -1;
            // 2-1. 인접한 정점 중 최소 비용 간선으로 연결되는 정점을 찾는다.
            for (int j = 0; j < nodeCount; j++) {
                // 방문하지 않았으며, 현재 도달 가능한 최소 거리 정점인지
                if (!visited[j] && dist[j] < minDist) {
                    // 선택 후보
                    minDist = dist[j];
                    idx = j;
                }
            }
            // 방문 처리
            visited[idx] = true;

            // 2-2. 정점들 정보를 바탕으로 도달 가능 정보를 갱신한다.
            for (int j = 0; j < nodeCount; j++) {
                // 1. 방문하지 않았고,
                // 2. 연결되어 있으며,
                // 3. 본래 거리보다 더 짧게 도달할 수 있다.
                if (!visited[j] && adjMatrix[idx][j] != 0 && dist[j] > minDist) {
                    dist[j] = adjMatrix[idx][j];
                    parent[j] = idx;
                }
            }
        }

        // MST 총 가중치 합
        int totalWeight = 0;
        for (int i = 0; i < nodeCount; i++) {
            totalWeight += dist[i];
        }
        System.out.println(totalWeight);
        System.out.println(Arrays.toString(parent));
    }

    public static void main(String[] args) throws IOException {
        new Prim().solution();
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


125
[-1, 4, 0, 0, 7, 2, 4, 3]
 */