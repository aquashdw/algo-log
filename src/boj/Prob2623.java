package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


// https://www.acmicpc.net/problem/2623
public class Prob2623 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] info = reader.readLine().split(" ");
        int singers = Integer.parseInt(info[0]);
        int directors = Integer.parseInt(info[1]);
        List<Set<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < singers + 1; i++) {
            adjList.add(new HashSet<>());
        }
        for (int i = 0; i < directors; i++) {
            int[] sequence = Arrays.stream(reader.readLine().split(" "))
                    .skip(1)
                    .mapToInt(Integer::parseInt)
                    .toArray();
            for (int j = 0; j < sequence.length - 1; j++) {
                adjList.get(sequence[j + 1]).add(sequence[j]);
            }
        }

        int[] inDegrees = new int[singers + 1];
        inDegrees[0] = Integer.MAX_VALUE;
        for (int i = 1; i < singers + 1; i++) {
            inDegrees[i] = adjList.get(i).size();
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i < singers + 1; i++) {
            if (inDegrees[i] == 0) queue.offer(i);
        }

        List<Integer> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            int node = queue.poll();
            result.add(node);

            for (int i = 1; i < singers + 1; i++) {
                Set<Integer> fromSet = adjList.get(i);
                if (fromSet.remove(node)) {
                    inDegrees[i]--;
                    if (fromSet.isEmpty()) {
                        queue.offer(i);
                    }
                }
            }
        }
        if (result.size() < singers) System.out.println(0);
        else for (int node: result) {
            System.out.println(node);
        }
    }
}

/*
7 4
0
3 1 4 3
4 6 2 5 4
2 2 3

6 3
4 1 4 3 2
4 6 2 5 4
2 2 3
 */
