package queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BreadthFirstSearch {
    public void solution() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int maxNodes = Integer.parseInt(reader.readLine());
        int[][] adjMap = new int[maxNodes + 1][maxNodes + 1];

        String[] edges = reader.readLine().split(" ");

        // BFS를 할때 연결 정보를 표현하는 방식은 크게 두가지가 있는데, 아래는
        // 2차원 배열을 좌표로 구분하는 방법이다.
        for (int i = 0; i < edges.length / 2; i++) {
            int leftNode = Integer.parseInt(edges[i * 2]);
            int rightNode = Integer.parseInt(edges[i * 2 + 1]);
            adjMap[leftNode][rightNode] = 1;
            adjMap[rightNode][leftNode] = 1;
        }

        Queue<Integer> toVisit = new LinkedList<>();
        List<Integer> visitedOrder = new ArrayList<>();
        boolean[] visited = new boolean[maxNodes + 1];
        // 첫 방문 대상
        int next = 1;
        // 큐에 넣어둔다.
        toVisit.offer(next);
        // 큐가 차있는 동안 반복한다.
        while (!toVisit.isEmpty()) {
            // 다음 방문할 곳을 가져온다.
            next = toVisit.poll();
            // 이미 방문했다면 다음 반복으로
            if (visited[next]) continue;

            // 방문했다 표시
            visited[next] = true;
            // 방문한 순서 기록
            visitedOrder.add(next);

            // 다음 방문 대상을 검색한다.
            for (int i = 0; i < maxNodes + 1; i++){
                if (adjMap[next][i] == 1 && !visited[i]) {
                    toVisit.offer(i);
                }
            }
        }

        // 출력
        System.out.println(visitedOrder);
    }


    public static void main(String[] args) throws IOException {
        new BreadthFirstSearch().solution();
    }

}
/*
입력 예제:
7
1 2 1 3 2 4 2 5 4 6 5 6 6 7 3 7
 */