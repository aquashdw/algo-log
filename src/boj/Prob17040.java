package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

// https://www.acmicpc.net/problem/17040
public class Prob17040 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        List<Set<Integer>> adjList = new ArrayList<>(info[0]);
        adjList.add(null);
        IntStream.range(0, info[0]).forEach(i -> adjList.add(new HashSet<>()));
        int[] planted = new int[info[0] + 1];

        reader.lines().limit(info[1]).forEach(line -> {
            int[] edge = Arrays.stream(line.split(" "))
                    .mapToInt(Integer::parseInt).toArray();

            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        });

        for (int i = 1; i < info[0] + 1; i++) {
            if (planted[i] != 0) continue;
            Set<Integer> adjacent = adjList.get(i).stream()
                    .mapToInt(node -> planted[node])
                    .filter(grass -> grass > 0)
                    .distinct()
                    .boxed()
                    .collect(Collectors.toSet());

            int nextGrass = 0;
            for (int j = 1; j < 5; j++) {
                if (adjacent.contains(j)) continue;
                nextGrass = j;
                break;
            }

            planted[i] = nextGrass;
        }

        System.out.println(Arrays.stream(planted)
                .skip(1)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining("")));
    }
}
