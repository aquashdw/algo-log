package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

// https://www.acmicpc.net/problem/26215
public class Prob26215 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        reader.readLine();
        Queue<Integer> maxSnow = new PriorityQueue<>(Comparator.reverseOrder());
        Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .forEach(maxSnow::offer);
        if (maxSnow.peek() > 1440) {
            System.out.println(-1);
            return;
        }

        int days = 0;
        while (maxSnow.size() > 1) {
            int max = maxSnow.poll() - 1;
            int sub = maxSnow.poll() - 1;
            if (max > 0)
                maxSnow.offer(max);
            if (sub > 0)
                maxSnow.offer(sub);
            days++;
        }
        if (!maxSnow.isEmpty()) days += maxSnow.poll();
        System.out.println(days > 1440 ? -1 : days);
    }
}
/*
3
2 1439 1440
 */