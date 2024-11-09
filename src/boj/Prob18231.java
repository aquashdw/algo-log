package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

// https://www.acmicpc.net/problem/18231
public class Prob18231 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] nm = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = nm[0];
        int m = nm[1];
        List<List<Integer>> adjList = new ArrayList<>(n + 1);
        adjList.add(null);
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }
        reader.lines().limit(m).forEach(line -> {
            int[] edge = Arrays.stream(line.split(" ")).mapToInt(Integer::parseInt).toArray();
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        });
        int k = Integer.parseInt(reader.readLine());
        Map<Integer, Boolean> check = new HashMap<>();
        int[] destroyedCities = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(token -> {
                    int city = Integer.parseInt(token);
                    check.putIfAbsent(city, false);
                    return city;
                }).toArray();
        List<Integer> bombed = new ArrayList<>(k);
        for (int i = 0; i < k; i++) {
            if (adjList.get(destroyedCities[i]).stream().anyMatch(city -> !check.containsKey(city))) {
                continue;
            }
            adjList.get(destroyedCities[i]).forEach(city -> check.put(city, true));
            check.put(destroyedCities[i], true);
            bombed.add(destroyedCities[i]);
        }
        if (check.values().stream().allMatch(city -> city)) {
            System.out.printf("%d%n%s%n", bombed.size(), bombed.stream().map(String::valueOf).collect(Collectors.joining(" ")));
        }
        else System.out.println(-1);
    }
}
