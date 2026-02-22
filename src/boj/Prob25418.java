package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// https://www.acmicpc.net/problem/25418
public class Prob25418 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] nums = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        int start = nums[0];
        int end = nums[1];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{start, 0});
        Set<Integer> visited = new HashSet<>();
        int answer = -1;
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            if (now[0] == end) {
                answer = now[1];
                break;
            }

            if (now[0] * 2 <= end && !visited.contains(now[0] * 2)) {
                queue.offer(new int[]{now[0] * 2, now[1] + 1});
                visited.add(now[0] * 2);
            }
            if (!visited.contains(now[0] + 1)) {
                queue.offer(new int[]{now[0] + 1, now[1] + 1});
                visited.add(now[0] + 1);
            }
        }
        System.out.println(answer);
    }
}
