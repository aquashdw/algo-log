package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// https://www.acmicpc.net/problem/10332
public class Prob10332 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] nm = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        int n = nm[0];
        int m = nm[1];
        if (m == 0) {
            System.out.println(n + 1);
            return;
        }

        Queue<int[]> restrictQueue = new PriorityQueue<>((o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o2[1] - o1[1];
            }
            return o1[0] - o2[0];
        });

        reader.lines().limit(m).forEach(line -> restrictQueue.offer(Arrays.stream(line.split(" ")).mapToInt(Integer::parseInt).toArray()));
        List<int[]> intervals = new ArrayList<>();
        int[] now = restrictQueue.poll();
        while (!restrictQueue.isEmpty()) {
            int[] next = restrictQueue.poll();
            if (next[0] > now[1]) {
                intervals.add(now);
                now = next;
            }
            else {
                now[1] = Math.max(now[1], next[1]);
            }
        }
        intervals.add(now);

        int current = 0;
        int dist = 0;
        for (int[] interval : intervals) {
            dist += interval[1] - current;
            dist += interval[1] - interval[0];
            current = interval[0];
        }
        dist += n + 1 - current;
        System.out.println(dist);
    }
}


/*
0 -> 2 = 2
2 -> 1 = 1
1 -> 1000 = 999
1000 -> 3 = 997
3 -> 1001 = 998
 */