package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Set;
import java.util.stream.Collectors;

// https://www.acmicpc.net/problem/25391
public class Prob25391 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        int n = info[0];
        int special = info[1];
        int byRanks = info[2];

        long[][] points = new long[n][3];
        for (int i = 0; i < n; i++) {
            long[] point = Arrays.stream(reader.readLine().split(" ")).mapToLong(Long::parseLong)
                    .toArray();
            points[i][0] = i;
            points[i][1] = point[0];
            points[i][2] = point[1];
        }
        Set<Integer> ranks = Arrays.stream(points)
                .sorted(Comparator.comparingLong(o -> -o[2]))
                .limit(byRanks)
                .mapToInt(o -> Math.toIntExact(o[0]))
                .boxed()
                .collect(Collectors.toSet());

        Set<Integer> specials = Arrays.stream(points)
                .sorted(Comparator.comparingLong(o -> -o[1]))
                .filter(o -> !ranks.contains(Math.toIntExact(o[0])))
                .limit(special)
                .mapToInt(o -> Math.toIntExact(o[0]))
                .boxed()
                .collect(Collectors.toSet());

        ranks.addAll(specials);
        System.out.println(ranks.stream().mapToLong(i -> points[i][1]).sum());

    }
}
