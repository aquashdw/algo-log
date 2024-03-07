package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class DepthFirstSearch {
    public void dfsAdjMatrix() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] info = reader.readLine().split(" ");
        int maxNodes = Integer.parseInt(info[0]);

        int[][] adjMap = new int[maxNodes + 1][maxNodes + 1];
        int edges = Integer.parseInt(info[1]);
        for (int i = 0; i < edges; i++) {
            String[] edgeInfo = reader.readLine().split(" ");
            int leftNode = Integer.parseInt(edgeInfo[0]);
            int rightNode = Integer.parseInt(edgeInfo[1]);
            adjMap[leftNode][rightNode] = 1;
            adjMap[rightNode][leftNode] = 1;
        }

        Stack<Integer> toVisit = new Stack<>();
        List<Integer> visitedOrder = new ArrayList<>();
        boolean[] visited = new boolean[maxNodes + 1];

        int next = 0;
        toVisit.push(next);
        while (!toVisit.empty()) {
            next = toVisit.pop();
            if (visited[next]) continue;

            visited[next] = true;
            visitedOrder.add(next);

            for (int i = maxNodes; i > 0; i--){
                if (adjMap[next][i] == 1 && !visited[i]) {
                    toVisit.push(i);
                }
            }
        }

        System.out.println(visitedOrder);
    }

    public void dfsAdjList() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] info = reader.readLine().split(" ");
        int maxNodes = Integer.parseInt(info[0]);

        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < maxNodes; i++) {
            adjList.add(new ArrayList<>());
        }

        int edges = Integer.parseInt(info[1]);
        for (int i = 0; i < edges; i++) {
            String[] edgeInfo = reader.readLine().split(" ");
            int leftNode = Integer.parseInt(edgeInfo[0]);
            int rightNode = Integer.parseInt(edgeInfo[1]);
            adjList.get(leftNode).add(rightNode);
            adjList.get(rightNode).add(leftNode);
        }

        for (List<Integer> adjRow: adjList) {
            Collections.sort(adjRow);
        }

        Stack<Integer> toVisit = new Stack<>();
        List<Integer> visitedOrder = new ArrayList<>();
        boolean[] visited = new boolean[maxNodes + 1];
        int next = 0;
        toVisit.push(next);
        while (!toVisit.empty()) {
            next = toVisit.pop();
            if (visited[next]) continue;

            visited[next] = true;
            visitedOrder.add(next);

            List<Integer> adjRow = adjList.get(next);
            for (Integer canVisit: adjRow) {
                if (!visited[canVisit])
                    toVisit.push(canVisit);
            }
        }

        // 출력
        System.out.println(visitedOrder);
    }

    public void dfsRecursive() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] info = reader.readLine().split(" ");
        int maxNodes = Integer.parseInt(info[0]);

        int[][] adjMap = new int[maxNodes + 1][maxNodes + 1];
        int edges = Integer.parseInt(info[1]);
        for (int i = 0; i < edges; i++) {
            String[] edgeInfo = reader.readLine().split(" ");
            int leftNode = Integer.parseInt(edgeInfo[0]);
            int rightNode = Integer.parseInt(edgeInfo[1]);
            adjMap[leftNode][rightNode] = 1;
            adjMap[rightNode][leftNode] = 1;
        }

        List<Integer> visitedOrder = new ArrayList<>();
        boolean[] visited = new boolean[maxNodes + 1];

        recursive(0, maxNodes, adjMap, visited, visitedOrder);

        System.out.println(visitedOrder);
    }

    public void recursive(
            int next,
            int maxNodes,
            int[][] adjMap,
            boolean[] visited,
            List<Integer> visitOrder
    ) {
        visited[next] = true;
        visitOrder.add(next);
        for (int i = 0; i < maxNodes; i++){
            if (adjMap[next][i] == 1 && !visited[i]) {
                recursive(i, maxNodes, adjMap, visited, visitOrder);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        new DepthFirstSearch().dfsAdjMatrix();
        new DepthFirstSearch().dfsAdjList();
        new DepthFirstSearch().dfsRecursive();
    }

}
/*
입력 예제
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

