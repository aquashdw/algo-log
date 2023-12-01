package heap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Dijkstra {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer info = new StringTokenizer(reader.readLine());
        // 노드와 간선의 개수
        int nodes = Integer.parseInt(info.nextToken());
        int edges = Integer.parseInt(info.nextToken());
        // 출발지점
        int start = Integer.parseInt(reader.readLine());

        // 1. 인접행렬을 이용한 그래프 초기화
        int[][] adjMat = new int[nodes][nodes];
        for (int[] row: adjMat) {
            Arrays.fill(row, -1);
        }

        // 그래프에 값을 넣는다.
        for (int i = 0; i < edges; i++) {
            StringTokenizer edgeToken = new StringTokenizer(reader.readLine());
            int from = Integer.parseInt(edgeToken.nextToken());
            int to = Integer.parseInt(edgeToken.nextToken());
            int cost = Integer.parseInt(edgeToken.nextToken());

            adjMat[from][to] = cost;
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
        for (int i = 0; i < nodes; i++) {
            // 4 - 1. 현재 거리 비용 중 최소인 지점을 선택한다.
            // 해당 노드가 가지고 있는 현재 비용.
            int minDist = Integer.MAX_VALUE;
            // 해당 노드의 인덱스(번호).
            int minDistNode = 0;
            // 인덱스 0은 생각하지 않기 때문에 1부터 반복을 진행한다.
            for (int j = 0; j < nodes; j++) {
                // 해당 노드를 방문하지 않았고, 현재 모든 거리비용 중 최솟값을 찾는다.
                if (!visited[j] && dist[j] < minDist) {
                    minDist = dist[j];
                    minDistNode = j;
                }
            }
            // 최종 선택된 노드를 방문처리 한다.
            visited[minDistNode] = true;

            // 4 - 2. 해당 지점을 기준으로 인접 노드의 최소 거리 값을 갱신한다.
            for (int j = 0; j < nodes; j++) {
                if (adjMat[minDistNode][j] == -1) continue;
                // 인접 노드를 선택한다.
                int cost = adjMat[minDistNode][j];

                // 인접 노드가 현재 가지는 최소 비용과
                // 현재 선택된 노드의 값 + 현재 노드에서 인접 노드로 가는 값을 비교하여 더 작은 값으로 갱신한다.
                if (dist[j] > dist[minDistNode] + cost)
                    dist[j] = dist[minDistNode] + cost;
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
/*
5 6
0
4 0 1
0 1 2
0 2 3
1 2 4
1 3 5
2 3 6
 */

/*
6 8
0
0 1 10
0 2 15
1 3 12
1 5 15
2 4 10지
3 4 2
3 5 1
5 4 5

0
10
15
22
24
23
 */