package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.IntStream;


// https://acmicpc.net/problem/1446
public class Prob1446 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        int n = info[0];
        int distance = info[1];

        Set<Integer> nodeFilter = new HashSet<>();
        nodeFilter.add(0);
        nodeFilter.add(distance);
        int[][] edges = new int[n][];
        for (int i = 0; i < n; i++) {
            edges[i] = Arrays.stream(reader.readLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();
            nodeFilter.add(edges[i][0]);
            nodeFilter.add(edges[i][1]);
        }

        int[] nodes = nodeFilter.stream().filter(i -> i <= distance).mapToInt(i -> i).sorted().toArray();
        int count = nodes.length;
        Map<Integer, Integer> pointToNode = new HashMap<>();
        IntStream.range(0, nodes.length).forEach(i -> pointToNode.put(nodes[i], i));

        int[][] nodeDists = new int[count][count];
        for (int[] nodeDist : nodeDists) {
            Arrays.fill(nodeDist, 10000);
        }
        for (int i = 0; i < count - 1; i++) {
            nodeDists[i][i + 1] = nodes[i + 1] - nodes[i];
        }

        for (int[] edge : edges) {
            if (edge[0] <= distance && edge[1] <= distance) {
                int startIdx = pointToNode.get(edge[0]);
                int endIdx = pointToNode.get(edge[1]);

                nodeDists[startIdx][endIdx] = Math.min(edge[2], nodeDists[startIdx][endIdx]);
            }
        }

        int[] distRecord = new int[count];
        boolean[] visited = new boolean[count];

        Arrays.fill(distRecord, 10000);
        distRecord[0] = 0;

        for (int i = 0; i < count; i++) {
            int now = -1;
            int minDist = 10000;
            for (int j = 0; j < count; j++) {
                if (visited[j]) continue;
                if (distRecord[j] < minDist) {
                    minDist = distRecord[j];
                    now = j;
                }
            }
            if (now == -1) throw new RuntimeException();
            visited[now] = true;
            distRecord[now] = minDist;
            for (int j = 0; j < count; j++) {
                if (visited[j]) continue;
                distRecord[j] = Math.min(distRecord[j], minDist + nodeDists[now][j]);
            }
        }

        System.out.println(distRecord[distRecord.length - 1]);
    }

}
