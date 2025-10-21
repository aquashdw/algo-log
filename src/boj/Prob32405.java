package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

// https://www.acmicpc.net/problem/32405
public class Prob32405 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        Queue<Integer> next = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            next.add(i);
        }
        int[] power = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        int[] health = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        int[] deals = new int[n];

        int total = 0;

        while (next.size() > 1) {
            int now = next.poll();
            if (health[now] - total + deals[now] < 0) continue;
            total += power[now];
            deals[now] += power[now];
            next.offer(now);
        }
        System.out.println(next.poll() + 1);
    }

}
