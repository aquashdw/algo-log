package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

// https://www.acmicpc.net/problem/11286
public class Prob11286 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> {
            int abs1 = Math.abs(o1);
            int abs2 = Math.abs(o2);
            if (abs1 == abs2)
                return o1 - o2;
            else return abs1 - abs2;
        });

        StringBuilder answer = new StringBuilder();
        reader.lines().limit(n).mapToInt(Integer::parseInt).forEach(i -> {
            if (i == 0) {
                if (queue.isEmpty()) answer.append(0).append('\n');
                else answer.append(queue.poll()).append('\n');
            } else {
                queue.offer(i);
            }
        });
        System.out.print(answer);
    }
}
