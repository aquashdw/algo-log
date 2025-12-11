package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

// https://www.acmicpc.net/problem/2461
public class Prob2461 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] nm = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        int n = nm[0];
        int m = nm[1];

        int[][] classes = new int[n][];
        for (int i = 0; i < n; i++) {
            classes[i] = Arrays.stream(reader.readLine().split(" "))
                    .mapToInt(Integer::parseInt).sorted().toArray();
        }

        Queue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
        int[] indices = new int[n];
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            min = Math.min(min, classes[i][0]);
            max = Math.max(max, classes[i][0]);
            queue.offer(new int[]{i, classes[i][0]});
        }
        int diff = max - min;

        while (!queue.isEmpty()) {
            // 현재 가장 최약체 대표 반
            int[] minCase = queue.poll();
            int clsIdx = minCase[0];

            // 다음 놈 나와라
            indices[clsIdx]++;
            int stdIdx = indices[clsIdx];

            // 더 없으면 바뀔게 없군
            if (stdIdx == m) break;

            // 다음 놈의 힘을 보자
            int power = classes[clsIdx][stdIdx];
            // 그놈이 새 강자인가?
            max = Math.max(max, power);
            // 이제 대기열에 들어가라
            queue.offer(new int[]{clsIdx, power});
            // 다음 최약체는 누구일까
            min = queue.element()[1];

            // 균형이 이뤄졌는가
            diff = Math.min(diff, max - min);
        }
        System.out.println(diff);
    }
}
