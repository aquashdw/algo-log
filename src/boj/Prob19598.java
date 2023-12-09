package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;


// https://www.acmicpc.net/problem/19598
public class Prob19598 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());

        int[][] meetings = new int[n][];
        for (int i = 0; i < n; i++) {
            meetings[i] = Arrays.stream(reader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        // 시작시간 기준 정렬
        Arrays.sort(meetings, Comparator.comparingInt(o -> o[0]));
        PriorityQueue<Integer> endTimes = new PriorityQueue<>();
        endTimes.add(0);
        for (int i = 0; i < meetings.length; i++) {
            if (endTimes.peek() <= meetings[i][0]) {
                endTimes.poll();
            }
            endTimes.offer(meetings[i][1]);
        }

        System.out.println(endTimes.size());
    }
}
