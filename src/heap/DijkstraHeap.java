package heap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class DijkstraHeap {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer info = new StringTokenizer(reader.readLine());
        // 노드와 간선의 개수
        int nodes = Integer.parseInt(info.nextToken());
        int edges = Integer.parseInt(info.nextToken());
        // 출발지점
        int start = Integer.parseInt(reader.readLine());

        // 1. 인접리스트를 이용한 그래프 초기화
        List<List<int[]>> adjList = new ArrayList<>();
        for (int i = 0; i < nodes; i++) {
            adjList.add(new ArrayList<>());
        }

        // 그래프에 값을 넣는다.
        for (int i = 0; i < edges; i++) {
            StringTokenizer edgeToken = new StringTokenizer(reader.readLine());
            int from = Integer.parseInt(edgeToken.nextToken());
            int to = Integer.parseInt(edgeToken.nextToken());
            int cost = Integer.parseInt(edgeToken.nextToken());

            adjList.get(from).add(new int[]{to, cost});
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
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(e -> e[1]));
        minHeap.offer(new int[]{start, 0});

        // 우선순위 큐에 더이상 방문할 정점이 기록되지 않을때 까지
        while (!minHeap.isEmpty()) {
            // minHeap.poll의 시간복잡도는 logN
            int[] current = minHeap.poll();

            if (visited[current[0]]) {
                continue;
            }

            visited[current[0]] = true;

            // 4 - 2. 해당 지점을 기준으로 인접 노드의 최소 거리 값을 갱신한다.
            for (int[] neighbor : adjList.get(current[0])) {
                int neighborVertex = neighbor[0];
                int neighborCost = neighbor[1];

                if (!visited[neighborVertex] && dist[neighborVertex] > current[1] + neighborCost) {
                    dist[neighborVertex] = current[1] + neighborCost;
                    minHeap.offer(new int[]{ neighborVertex, dist[neighborVertex]});
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
