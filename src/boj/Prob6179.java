package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

// https://www.acmicpc.net/problem/6179
public class Prob6179 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int[][] rollers = new int[n][];
        int[] count = new int[n];
        Queue<Integer> left = new LinkedList<>();
        Queue<Integer> next = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            rollers[i] = Arrays.stream(reader.readLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();
            int[] me = rollers[i];
            if (me[0] == 0 && me[1] == 0) count[i]++;
            while (!left.isEmpty()) {
                int idx = left.poll();
                int[] other = rollers[idx];
                if (check(me, other)) {
                    count[i]++;
                    count[idx]++;
                }
                if (count[idx] < 2) next.offer(idx);
            }
            if (count[i] < 2) next.offer(i);
            Queue<Integer> temp = left;
            left = next;
            next = temp;
        }

        System.out.printf("%d %d%n", rollers[left.peek()][0], rollers[left.peek()][1]);
    }

    private static boolean check(int[] o1, int[] o2) {
        int xDiff = Math.abs(o1[0] - o2[0]);
        int yDiff = Math.abs(o1[1] - o2[1]);
        int dist = o1[2] + o2[2];
        return xDiff * xDiff + yDiff * yDiff == dist * dist;
    }
}
