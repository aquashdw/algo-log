package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.IntStream;

// https://www.acmicpc.net/problem/10856
public class Prob10856 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        Map<String, Integer> methodToId = new HashMap<>();
        Queue<Integer> executables = new LinkedList<>();
        List<String> referenceRecords = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            String method = reader.readLine().split(" ")[0];
            methodToId.put(method, i);
            referenceRecords.add(reader.readLine());
            if (method.endsWith("::PROGRAM")) {
                executables.add(i);
            }
        }

        Map<Integer, Set<Integer>> adjList = new HashMap<>();
        for (int i = 0; i < n; i++) {
            adjList.put(i, new HashSet<>());
        }
        for (int i = 0; i < n; i++) {
            String record = referenceRecords.get(i);
            if (record.isBlank()) continue;
            for (String referenced : record.split(" ")) {
                int id = methodToId.get(referenced);
                if (id == i) continue;
                adjList.get(id).add(i);
            }
        }

        boolean[] visited = new boolean[n];
        executables.forEach(i -> visited[i] = true);
        Queue<Integer> toVisit = executables;
        while (!toVisit.isEmpty()) {
            int now = toVisit.poll();
            for (int next : adjList.get(now)) {
                if (visited[next]) continue;
                visited[next] = true;
                toVisit.add(next);
            }
        }
        System.out.println(IntStream.range(0, n).filter(i -> !visited[i]).count());
    }
}
