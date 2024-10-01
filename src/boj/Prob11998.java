package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

// https://www.acmicpc.net/problem/11998
public class Prob11998 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int aMax = info[0];
        int bMax = info[1];
        int maxRounds = info[2];
        int target = info[3];

        int minDiff = target;
        boolean[][] visited = new boolean[aMax + 1][bMax + 1];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0, 0});
        visited[0][0] = true;
        while (!queue.isEmpty()) {
            int[] rep = queue.poll();
            int sum = rep[0] + rep[1];
            minDiff = Math.min(minDiff, Math.abs(sum - target));
            if (minDiff == 0) break;
            if (rep[2] == maxRounds) continue;

            // A 가득 채우기
            if (!visited[aMax][rep[1]]) {
                queue.add(new int[]{aMax, rep[1], rep[2] + 1});
                visited[aMax][rep[1]] = true;
            }
            // A 버리기
            if (!visited[0][rep[1]]) {
                queue.add(new int[]{0, rep[1], rep[2] + 1});
                visited[0][rep[1]] = true;
            }
            // B 가득 채우기
            if (!visited[rep[0]][bMax]) {
                queue.add(new int[]{rep[0], bMax, rep[2] + 1});
                visited[rep[0]][bMax] = true;
            }
            // B 버리기
            if (!visited[rep[0]][0]) {
                queue.add(new int[]{rep[0], 0, rep[2] + 1});
                visited[rep[0]][0] = true;
            }
            // A에 B 떠넘기기
            int fillA = Math.min(sum, aMax);
            if (!visited[fillA][sum - fillA]) {
                queue.add(new int[]{Math.min(sum, aMax), sum - Math.min(sum, aMax), rep[2] + 1});
                visited[fillA][sum - fillA] = true;
            }
            // B에 A 떠넘기기
            int fillB = Math.min(sum, bMax);
            if (!visited[sum - fillB][fillB]) {
                queue.add(new int[]{sum - Math.min(sum, bMax), Math.min(sum, bMax), rep[2] + 1});
                visited[sum - fillB][fillB] = true;
            }
        }

        System.out.println(minDiff);
    }
}
// 14 50 3 32