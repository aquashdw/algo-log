package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// https://www.acmicpc.net/problem/5786
public class Prob5786 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();
        String input;
        while (true) {
            input = reader.readLine();
            if (input.equals("0") || input.equals("0 0")) break;
            int n = Integer.parseInt(input);
            List<Set<Integer>> adjList = new ArrayList<>(n + 1);
            adjList.add(null);
            for (int i = 0; i < n; i++) {
                adjList.add(new HashSet<>());
            }

            for (int i = 1; i < n + 1; i++) {
                Arrays.stream(reader.readLine().split(" "))
                        .mapToInt(Integer::parseInt)
                        .filter(num -> num != 0)
                        .distinct()
                        .forEach(adjList.get(i)::add);
            }

            List<List<String>> attributeObtained = new ArrayList<>(n + 1);
            attributeObtained.add(null);
            for (int i = 0; i < n; i++) {
                attributeObtained.add(new ArrayList<>());
            }
            int[] thresh = new int[2];
            String[] attributes = new String[3];
            boolean[] visited = new boolean[n + 1];
            int[] forwards = new int[n + 1];
            reader.lines().takeWhile(line -> !line.equals("0")).forEach(line -> {
                String[] lineSplit = line.split(" ");
                int start = Integer.parseInt(lineSplit[0]);
                thresh[0] = Integer.parseInt(lineSplit[1]);
                thresh[1] = Integer.parseInt(lineSplit[2]);
                attributes[0] = lineSplit[3];
                attributes[1] = lineSplit[4];
                attributes[2] = lineSplit[5];
                Arrays.fill(visited, false);
                Arrays.fill(forwards, 0);

                Queue<Integer> toVisit = new LinkedList<>();
                toVisit.add(start);
                visited[start] = true;
                while (!toVisit.isEmpty()) {
                    int now = toVisit.poll();
                    forwards[now] = adjList.get(now).size();
                    adjList.get(now).forEach(next -> {
                        if (visited[next]) return;
                        visited[next] = true;
                        toVisit.add(next);
                    });
                }

                for (int i = 1; i < n + 1; i++) {
                    List<String> iAttributes = attributeObtained.get(i);
                    if (forwards[i] < thresh[0]) {
                        iAttributes.add(attributes[0]);
                    }
                    else if (forwards[i] < thresh[1]) {
                        iAttributes.add(attributes[1]);
                    }
                    else {
                        iAttributes.add(attributes[2]);
                    }
                }
            });

            for (int i = 1; i < n + 1; i++) {
                String name = reader.readLine();
                answer.append(name).append(": ").append(String.join(" ", attributeObtained.get(i))).append('\n');
            }
        }
        System.out.print(answer);
    }
}
