package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;


// https://www.acmicpc.net/problem/1967
public class Prob1967 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int nodes = Integer.parseInt(reader.readLine());
        List<List<int[]>> adjList = new ArrayList<>();
        adjList.add(null);
        for (int i = 0; i < nodes; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int i = 0; i < nodes - 1; i++) {
            int[] edgeInfo = Arrays.stream(reader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            adjList.get(edgeInfo[0]).add(new int[]{edgeInfo[1], edgeInfo[2]});
            adjList.get(edgeInfo[1]).add(new int[]{edgeInfo[0], edgeInfo[2]});
        }

        int[] farthest = findFarthest(1, nodes, adjList);
        farthest = findFarthest(farthest[0], nodes, adjList);
        System.out.println(farthest[1]);
    }

    public static int[] findFarthest(int start, int nodes, List<List<int[]>> adjList) {
        int[] max = {-1 ,Integer.MIN_VALUE};
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
        return max;
    }
}
