package boj.onhold;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

// https://www.acmicpc.net/problem/7882
public class Prob7882 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(reader.readLine());
        StringBuilder answer = new StringBuilder();
        while (tests-- > 0) {
            int[] nd = Arrays.stream(reader.readLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();
            int n = nd[0];
            int d = nd[1];

            int[] heights = Arrays.stream(reader.readLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();
            int[] days = Arrays.stream(reader.readLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();

            boolean[] survived = new boolean[n];
            Arrays.fill(survived, true);
            Queue<int[]> sinking = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
            int regions = 1;
            for (int i = 0; i < n; i++) {
                sinking.offer(new int[]{i, heights[i]});
            }

            List<Integer> regionsByDate = new ArrayList<>(d);
            for (int date : days) {
                if (sinking.isEmpty()) {
                    regionsByDate.add(0);
                    continue;
                }

                while (!sinking.isEmpty() && sinking.peek()[1] <= date) {
                    int drowned = sinking.poll()[0];
                    survived[drowned] = false;
                    if (drowned == 0 || drowned == n - 1) {
                        if (n == 1) regions--;
                        else if (drowned == 0 && !survived[drowned + 1]) regions--;
                        else if (drowned == n - 1 && !survived[drowned - 1]) regions--;
                        continue;
                    }
                    if (survived[drowned - 1] && survived[drowned + 1]) regions++;
                    else if (!survived[drowned - 1] && !survived[drowned + 1]) regions--;
                }
                regionsByDate.add(regions);
            }

            answer.append(regionsByDate.stream().map(String::valueOf).collect(Collectors.joining(" "))).append('\n');
        }
        System.out.print(answer);
    }
}
