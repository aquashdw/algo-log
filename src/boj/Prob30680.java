package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// https://www.acmicpc.net/problem/30680
public class Prob30680 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int decoCount = Integer.parseInt(reader.readLine());
        List<int[]> bigTree = new ArrayList<>();
        bigTree.add(new int[]{-1, -1, 0});
        Queue<int[]> leaves = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
        leaves.add(new int[]{0, 0});
        int maxLen = 0;
        for (int i = 0; i < decoCount; i++) {
            int offset = bigTree.size() - 1;
            int nodes = Integer.parseInt(reader.readLine());
            int[] rootInfo = leaves.poll();
            int rootNode = rootInfo[0];

            bigTree.get(rootNode)[1] = bigTree.size();
            // 부모, 자식, 거리
            bigTree.add(new int[]{rootInfo[0], -1, rootInfo[1] + 1});
            for (int j = 1; j < nodes; j++) {
                bigTree.add(new int[]{-1, -1, Integer.MAX_VALUE});
            }
            List<List<Integer>> adjList = new ArrayList<>(nodes + 1);
            adjList.add(null);
            for (int j = 0; j < nodes; j++) {
                adjList.add(new ArrayList<>());
            }
            for (int j = 0; j < nodes - 1; j++) {
                int[] edge = Arrays.stream(reader.readLine().split(" "))
                        .mapToInt(Integer::parseInt).toArray();
                adjList.get(edge[0]).add(edge[1]);
                adjList.get(edge[1]).add(edge[0]);
            }

            boolean[] visited = new boolean[nodes + 1];
            visited[1] = true;
            Queue<int[]> toVisit = new LinkedList<>();
            adjList.get(1).forEach(node -> {
                visited[node] = true;
                toVisit.add(new int[]{node, 1});
            });
            while (!toVisit.isEmpty()) {
                int[] now = toVisit.poll();
                int child = now[0];
                int parent = now[1];
                int[] actualParent = bigTree.get(parent + offset);
                int[] actualChild = bigTree.get(child + offset);
                actualParent[1] = child + offset;
                actualChild[0] = parent + offset;
                actualChild[2] = actualParent[2] + 1;
                maxLen = Math.max(maxLen, actualChild[2]);
                adjList.get(child).stream().filter(node -> !visited[node]).forEach(node -> {
                    visited[node] = true;
                    toVisit.add(new int[]{node, child});
                });
            }

//            for (int j = 0; j < nodes - 1; j++) {
//                int[] edge = Arrays.stream(reader.readLine().split(" "))
//                        .mapToInt(Integer::parseInt).toArray();
//                int[] parent = bigTree.get(edge[0] + offset);
//                int[] child = bigTree.get(edge[1] + offset);
//                parent[1] = edge[1] + offset;
//                child[0] = edge[0] + offset;
//                child[2] = parent[2] + 1;
//                maxLen = Math.max(maxLen, child[2]);
//            }

            for (int j = offset + 1; j < bigTree.size(); j++) {
                int[] node = bigTree.get(j);
                if (node[1] == -1) {
                    leaves.add(new int[]{j, node[2]});
                }
            }
        }
        for (int[] node : bigTree) {
            System.out.println(Arrays.toString(node));
        }
        System.out.println(maxLen);
    }
}
/*
3
4
1 2
1 3
4 3
6
1 2
3 1
2 4
3 5
3 6
6
1 2
1 3
1 4
2 5
4 6


[-1, 1, 0]
[0, 3, 1]
[1, 5, 2]
[1, 4, 2]
[3, 11, 3]
[2, 7, 3]
[5, 8, 4]
[5, 10, 4]
[6, -1, 5]
[7, -1, 5]
[7, -1, 5]
[4, 14, 4]
[11, 15, 5]
[11, -1, 5]
[11, 16, 5]
[12, -1, 6]
[14, -1, 6]
 */