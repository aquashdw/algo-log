package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

// https://www.acmicpc.net/problem/1167
public class Prob1167 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int nodes = Integer.parseInt(reader.readLine());
        List<List<int[]>> adjList = new ArrayList<>();
        for (int i = 0; i < nodes + 1; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int i = 0; i < nodes; i++) {
            int[] nodeEdges = Arrays.stream(reader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            int node = nodeEdges[0];
            for (int j = 1; j < nodeEdges.length / 2; j++) {
                int adjNode = nodeEdges[j * 2 - 1];
                int cost = nodeEdges[j * 2];
                adjList.get(node).add(new int[]{adjNode, cost});
                adjList.get(adjNode).add(new int[]{node, cost});
            }
        }

        int start = 1;
        int[] max = {-1, Integer.MIN_VALUE};
        boolean[] visited = new boolean[nodes + 1];
        Stack<int[]> toVisit = new Stack<>();
        toVisit.push(new int[]{start, 0});
        while (!toVisit.empty()) {
            int[] now = toVisit.pop();
            if (visited[now[0]]) continue;
            visited[now[0]] = true;

            int stackSize = toVisit.size();
            List<int[]> adjacent = adjList.get(now[0]);
            for (int[] adjInfo : adjacent) {
                if (visited[adjInfo[0]]) continue;
                toVisit.push(new int[]{adjInfo[0], now[1] + adjInfo[1]});
            }
            if (stackSize == toVisit.size()) {
                if (now[1] > max[1]) {
                    max = now;
                }
            }
        }

        start = max[0];
        max = new int[]{-1, Integer.MIN_VALUE};
        Arrays.fill(visited, false);
        toVisit.push(new int[]{start, 0});
        while (!toVisit.empty()) {
            int[] now = toVisit.pop();
            if (visited[now[0]]) continue;
            visited[now[0]] = true;

            int stackSize = toVisit.size();
            List<int[]> adjacent = adjList.get(now[0]);
            for (int[] adjInfo : adjacent) {
                if (visited[adjInfo[0]]) continue;
                toVisit.push(new int[]{adjInfo[0], now[1] + adjInfo[1]});
            }
            if (stackSize == toVisit.size()) {
                if (now[1] > max[1]) {
                    max = now;
                }
            }
        }

        System.out.println(max[1]);
    }
}
