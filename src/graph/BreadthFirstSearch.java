package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BreadthFirstSearch {
    public void adjMat() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int maxNodes = Integer.parseInt(tokenizer.nextToken());

        int[][] adjMap = new int[maxNodes + 1][maxNodes + 1];
        int edges = Integer.parseInt(tokenizer.nextToken());
        for (int i = 0; i < edges; i++) {
            StringTokenizer edgeTokenizer = new StringTokenizer(reader.readLine());
            int leftNode = Integer.parseInt(edgeTokenizer.nextToken());
            int rightNode = Integer.parseInt(edgeTokenizer.nextToken());
            adjMap[leftNode][rightNode] = 1;
            adjMap[rightNode][leftNode] = 1;
        }

        Queue<Integer> toVisit = new LinkedList<>();
        List<Integer> visitedOrder = new ArrayList<>();
        boolean[] visited = new boolean[maxNodes + 1];
        // 첫 방문 대상
        int next = 0;
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
            for (int i = 0; i < maxNodes; i++){
                if (adjMap[next][i] == 1 && !visited[i]) {
                    toVisit.offer(i);
                }
            }
        }

        // 출력
        System.out.println(visitedOrder);
    }



    public void adjList() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int maxNodes = Integer.parseInt(tokenizer.nextToken());

        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < maxNodes; i++) {
            adjList.add(new ArrayList<>());
        }

        int edges = Integer.parseInt(tokenizer.nextToken());
        for (int i = 0; i < edges; i++) {
            StringTokenizer edgeTokenizer = new StringTokenizer(reader.readLine());
            int leftNode = Integer.parseInt(edgeTokenizer.nextToken());
            int rightNode = Integer.parseInt(edgeTokenizer.nextToken());
            adjList.get(leftNode).add(rightNode);
            adjList.get(rightNode).add(leftNode);
        }

        for (List<Integer> adjRow: adjList) {
            Collections.sort(adjRow);
        }

        Queue<Integer> toVisit = new LinkedList<>();
        List<Integer> visitedOrder = new ArrayList<>();
        boolean[] visited = new boolean[maxNodes + 1];
        // 첫 방문 대상
        int next = 0;
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
            List<Integer> adjRow = adjList.get(next);
            for (Integer canVisit: adjRow) {
                if (!visited[canVisit])
                    toVisit.offer(canVisit);
            }
        }

        // 출력
        System.out.println(visitedOrder);
    }


    public static void main(String[] args) throws IOException {
        new BreadthFirstSearch().adjMat();
//        new BreadthFirstSearch().adjList();
    }

}
/*
입력 예제:
7
1 2 1 3 2 4 2 5 4 6 5 6 6 7 3 7
 */
/*
8 10
0 1
0 2
0 3
1 3
1 4
2 5
3 4
4 7
5 6
6 7
 */