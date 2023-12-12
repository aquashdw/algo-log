package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


// https://www.acmicpc.net/problem/1005
public class Prob1005 {
    private static int nodes;
    private static int edges;
    private static int[] times;
    private static List<List<Integer>> adjList;
    private static int goal;


    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(reader.readLine());
        for (int i = 0; i < tests; i++) {
            int[] mapInfo = Arrays.stream(reader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            nodes = mapInfo[0];
            edges = mapInfo[1];
            times = new int[nodes + 1];
            int[] temp = Arrays.stream(reader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            for (int j = 0; j < nodes; j++){
                times[j + 1] = temp[j];
            }
            adjList = new ArrayList<>();
            adjList.add(null);
            for (int j = 0; j < nodes; j++) {
                adjList.add(new ArrayList<>());
            }
            for (int j = 0; j < edges; j++) {
                int[] edgeInfo = Arrays.stream(reader.readLine().split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray();
                adjList.get(edgeInfo[0]).add(edgeInfo[1]);
            }
            goal = Integer.parseInt(reader.readLine());
            topoSort();
        }
    }

    private static void topoSort() {
        int[] inDegrees = new int[nodes + 1];
        for (int i = 1; i < nodes + 1; i++) {
            List<Integer> neighbors = adjList.get(i);
            for (int neighbor : neighbors) {
                inDegrees[neighbor]++;
            }
        }

        Queue<Integer> nextQueue = new LinkedList<>();

        // 진입 차수가 0인 정점들 부터 시작
        for (int i = 1; i < nodes + 1; i++) {
            if (inDegrees[i] == 0) {
                nextQueue.offer(i);
            }
        }

        int[] results = new int[nodes + 1];
        while (!nextQueue.isEmpty()) {
            Queue<Integer> thisQueue = nextQueue;
            nextQueue = new LinkedList<>();

            while (!thisQueue.isEmpty()) {
                int node = thisQueue.poll();
                results[node] += times[node];

                for (int neighbor: adjList.get(node)) {
                    inDegrees[neighbor]--;
                    results[neighbor] = Math.max(results[neighbor], results[node]);
                    if (inDegrees[neighbor] == 0) {
                        nextQueue.offer(neighbor);
                    }
                }
            }
        }
//        System.out.println(Arrays.toString(results));
        System.out.println(results[goal]);
    }
}

/*
1
5 5
10 20 30 40 50
1 2
1 3
2 4
3 4
5 4
4

 */

