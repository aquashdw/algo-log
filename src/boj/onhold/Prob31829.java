package boj.onhold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// https://www.acmicpc.net/problem/31829
public class Prob31829 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        int nodes = info[0];
        int busMinutes = info[1];
        int walks = info[2];
        int roads = info[3];

        Map<Integer, Map<Integer, int[]>> connectMins = new HashMap<>();
        for (int i = 0; i < walks; i++) {
            int[] edge = Arrays.stream(reader.readLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();
            if (!connectMins.containsKey(edge[0])) connectMins.put(edge[0], new HashMap<>());
            if (!connectMins.containsKey(edge[1])) connectMins.put(edge[1], new HashMap<>());
            connectMins.get(edge[0]).put(edge[1], new int[]{edge[2], -1});
            connectMins.get(edge[1]).put(edge[0], new int[]{edge[2], -1});
        }

        for (int i = 0; i < roads; i++) {
            int[] edge = Arrays.stream(reader.readLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();
            if (!connectMins.containsKey(edge[0])) connectMins.put(edge[0], new HashMap<>());
            if (!connectMins.containsKey(edge[1])) connectMins.put(edge[1], new HashMap<>());
            int[] prevEdge = connectMins.get(edge[0]).putIfAbsent(edge[1], new int[]{-1, edge[2]});
            if (prevEdge != null) prevEdge[1] = edge[2];
            prevEdge = connectMins.get(edge[1]).putIfAbsent(edge[0], new int[]{-1, edge[2]});
            if (prevEdge != null) prevEdge[1] = edge[2];
        }
        boolean[] visited = new boolean[nodes + 1];
        int[] minutes = new int[nodes + 1];
        Arrays.fill(minutes, Integer.MAX_VALUE);
        minutes[1] = 0;
        Queue<int[]> next = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
        next.offer(new int[]{1, 0});
        while (!next.isEmpty()) {
            int[] now = next.poll();
            int minMinutesNode = now[0];
            if (visited[minMinutesNode]) continue;
            visited[minMinutesNode] = true;
            int minMinutes = now[1];

            Map<Integer, int[]> minNodeMap = connectMins.get(minMinutesNode);
            for (int node : minNodeMap.keySet()) {
                int[] connection = minNodeMap.get(node);
                int cost;
                if ((cost = connection[0]) != -1) {
                    if (minutes[node] > minMinutes + cost) {
                        minutes[node] = minMinutes + cost;
                        next.offer(new int[]{node, minutes[node]});
                    }
                }
                if ((cost = connection[1]) != -1) {
                    int waitTilBus = Math.max(0, busMinutes - minMinutes);
                    cost += waitTilBus;
                    if (minutes[node] > minMinutes + cost) {
                        minutes[node] = minMinutes + cost;
                        next.offer(new int[]{node, minutes[node]});
                    }
                }
            }
        }

//        System.out.println(Arrays.toString(minutes));
        System.out.println(minutes[nodes]);
    }
}
