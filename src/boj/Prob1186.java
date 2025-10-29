package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

// https://www.acmicpc.net/problem/1186
public class Prob1186 {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] nm = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        Set<Integer> xCords = new HashSet<>();
        Set<Integer> yCords = new HashSet<>();

        int[][] rectangles = reader.lines().limit(nm[0])
                .map(line -> {
                    int[] rectangle = Arrays.stream(line.split(" "))
                            .mapToInt(Integer::parseInt).toArray();
                    xCords.add(rectangle[0]);
                    yCords.add(rectangle[1]);
                    xCords.add(rectangle[2]);
                    yCords.add(rectangle[3]);
                    return rectangle;
                })
                .toArray(int[][]::new);

        Map<Integer, Integer> xConvert = new HashMap<>();
        Map<Integer, Integer> yConvert = new HashMap<>();
        int[] xSeqs = xCords.stream().sorted().mapToInt(Integer::valueOf).toArray();
        int[] ySeqs = yCords.stream().sorted().mapToInt(Integer::valueOf).toArray();
        int xUniques = xSeqs.length;
        int yUniques = ySeqs.length;

        IntStream.range(0, xUniques).forEach(i -> xConvert.put(xSeqs[i], i));
        IntStream.range(0, yUniques).forEach(i -> yConvert.put(ySeqs[i], i));

        int[][] rectConverts = Arrays.stream(rectangles)
                .map(rectangle -> {
                    int[] converted = new int[4];
                    converted[0] = xConvert.get(rectangle[0]);
                    converted[1] = yConvert.get(rectangle[1]);
                    converted[2] = xConvert.get(rectangle[2]);
                    converted[3] = yConvert.get(rectangle[3]);
                    return converted;
                }).toArray(int[][]::new);


        boolean[][] used = new boolean[xUniques][yUniques];

        int[] colored = new int[nm[0]];
        for (int rect = nm[0] - 1; rect > -1; rect--) {
            int[] converted = rectConverts[rect];
            int area = 0;
            for (int i = converted[0]; i < converted[2]; i++) {
                for (int j = converted[1]; j < converted[3]; j++) {
                    if (used[i][j]) continue;
                    used[i][j] = true;
                    int xDiff = xSeqs[i + 1] - xSeqs[i];
                    int yDiff = ySeqs[j + 1] - ySeqs[j];
                    area += xDiff * yDiff;
                }
            }
            colored[rect] = area;
        }
        System.out.println(IntStream.range(0, colored.length).boxed()
                .sorted(Comparator.comparingInt(i -> -colored[i]))
                .limit(nm[1])
                .sorted()
                .map(i -> String.valueOf(i + 1))
                .collect(Collectors.joining(" ")));
    }
}
