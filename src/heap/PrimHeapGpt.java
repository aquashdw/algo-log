package heap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class PrimHeapGpt {
    static class Edge{
        int destination;
        int weight;

        public Edge(int destination, int weight) {
            this.destination = destination;
            this.weight = weight;
        }
    }

    public void solution() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer neTokenizer = new StringTokenizer(reader.readLine());  // 노드의 갯수, 간선의 갯수
        int nodeCount = Integer.parseInt(neTokenizer.nextToken());
        int edgeCount = Integer.parseInt(neTokenizer.nextToken());

        // 가중치가 저장된 인접 리스트를 사용한다.
        List<List<Edge>> adjList = new ArrayList<>();
        for (int i = 0; i < nodeCount; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int i = 0; i < edgeCount; i++) {
            StringTokenizer edgeTokenizer = new StringTokenizer(reader.readLine());
            int start = Integer.parseInt(edgeTokenizer.nextToken());
            int end = Integer.parseInt(edgeTokenizer.nextToken());
            int weight = Integer.parseInt(edgeTokenizer.nextToken());
            adjList.get(start).add(new Edge(end, weight));
            adjList.get(end).add(new Edge(start, weight));
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

        // 최단거리 선택을 위한 우선순위 큐
        PriorityQueue<Edge> minHeap = new PriorityQueue<>(
                Comparator.comparingInt(edge -> edge.weight)
        );
        minHeap.offer(new Edge(0, 0));

        // 모든 정점이 선택될 때 까지 순회
        while (!minHeap.isEmpty()) {
            Edge minEdge = minHeap.poll();
            int current = minEdge.destination;

            if (visited[current]) {
                continue;
            }

            visited[current] = true;

            for (Edge neighbor: adjList.get(current)) {
                int next = neighbor.destination;
                int weight = neighbor.weight;

                // 방문한적 없으며 도달 가능 거리가 현재보다 낮은 경우
                if (!visited[next] && weight < dist[next]) {
                    dist[next] = weight;
                    parent[next] = current;
                    minHeap.offer(new Edge(next, weight));
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
        new PrimHeapGpt().solution();
    }
}