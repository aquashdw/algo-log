package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// https://www.acmicpc.net/problem/24526
public class Prob24526 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        int n = info[0];
        List<List<Integer>> adjList = new ArrayList<>(info[0] + 1);
        adjList.add(null);
        for (int i = 0; i < info[0]; i++) {
            adjList.add(new LinkedList<>());
        }
        int[] inDegree = new int[n + 1];
        for (int i = 0; i < info[1]; i++) {
            int[] edge = Arrays.stream(reader.readLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();
            adjList.get(edge[1]).add(edge[0]);
            inDegree[edge[0]]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i < n + 1; i++) {
            if (inDegree[i] == 0) queue.offer(i);
        }

        while (!queue.isEmpty()) {
            int now = queue.poll();
            for (int next : adjList.get(now)) {
                inDegree[next]--;
                if (inDegree[next] == 0) queue.offer(next);
            }
        }

        System.out.println(Arrays.stream(inDegree).skip(1).filter(i -> i == 0).count());
    }
}
