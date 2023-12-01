package heap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class DijkstraGptHeap {

    static class Edge {
        int destination;
        int cost;

        public Edge(int destination, int cost) {
            this.destination = destination;
            this.cost = cost;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer info = new StringTokenizer(reader.readLine());
        // 노드와 간선의 개수
        int nodes = Integer.parseInt(info.nextToken());
        int edges = Integer.parseInt(info.nextToken());
        // 출발지점
        int start = Integer.parseInt(reader.readLine());

        // 1. 인접리스트를 이용한 그래프 초기화
        List<List<Edge>> adjList = new ArrayList<>();
        for (int i = 0; i < nodes; i++) {
            adjList.add(new ArrayList<>());
        }

        // 그래프에 값을 넣는다.
        for (int i = 0; i < edges; i++) {
            StringTokenizer edgeToken = new StringTokenizer(reader.readLine());
            int from = Integer.parseInt(edgeToken.nextToken());
            int to = Integer.parseInt(edgeToken.nextToken());
            int cost = Integer.parseInt(edgeToken.nextToken());

            adjList.get(from).add(new Edge(to, cost));
        }

        // 2. 방문 여부를 확인할 boolean 배열, start 노드부터 end 노드 까지의 최소 거리를 저장할 배열을 만든다.
        boolean[] visited = new boolean[nodes];
        int[] dist = new int[nodes];
        // 3. 최소 거리 정보를 담을 배열을 초기화 한다.
        // 출발 지점 외 나머지 지점까지의 최소 비용은 최대로 지정해둔다.
        Arrays.fill(dist, Integer.MAX_VALUE);

        // 출발 지점의 비용은 0으로 시작한다.
        dist[start] = 0;

        // 4. 다익스트라 알고리즘을 진행한다.
        // 모든 노드을 방문하면 종료하기 때문에, 노드의 개수 만큼만 반복을 한다.
        PriorityQueue<Edge> minHeap = new PriorityQueue<>(Comparator.comparingInt(e -> e.cost));
        minHeap.offer(new Edge(start, 0));

        while (!minHeap.isEmpty()) {
            Edge current = minHeap.poll();
            int currentVertex = current.destination;
            int currentCost = current.cost;

            if (visited[currentVertex]) {
                continue;
            }

            visited[currentVertex] = true;

            for (Edge neighbor : adjList.get(currentVertex)) {
                int neighborVertex = neighbor.destination;
                int neighborCost = neighbor.cost;

                if (!visited[neighborVertex] && dist[neighborVertex] > currentCost + neighborCost) {
                    dist[neighborVertex] = currentCost + neighborCost;
                    minHeap.offer(new Edge(neighborVertex, dist[neighborVertex]));
                }
            }
        }

        // 5. 최종 비용을 출력한다.
        for (int i = 0; i < nodes; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                System.out.println("INF");
            } else {
                System.out.println(dist[i]);
            }
        }
    }
}
