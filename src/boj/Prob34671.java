package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

// https://www.acmicpc.net/problem/34671
public class Prob34671 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] nmq = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        int m = nmq[1];
        int tests = nmq[2];

        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
        for (int i = 0; i < m; i++) {
            int[] edge = Arrays.stream(reader.readLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();

            map.putIfAbsent(edge[0], new HashMap<>());
            map.putIfAbsent(edge[1], new HashMap<>());
            int dist = map.get(edge[0]).getOrDefault(edge[1], Integer.MAX_VALUE);
            map.get(edge[0]).put(edge[1], Math.min(edge[2], dist));
            map.get(edge[1]).put(edge[0], Math.min(edge[2], dist));
        }

        System.out.println(reader.lines().limit(tests).map(line -> {
            int[] path = Arrays.stream(line.split(" "))
                    .mapToInt(Integer::parseInt).toArray();
            return String.valueOf(map.getOrDefault(path[0], Collections.emptyMap()).getOrDefault(path[1], -1));
        }).collect(Collectors.joining("\n")));
    }
}
