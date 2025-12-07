package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

// https://www.acmicpc.net/problem/18149
public class Prob18149 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(reader.readLine());
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < tests; i++) {
            int n = Integer.parseInt(reader.readLine());
            Queue<Integer> queue = new PriorityQueue<>();
            Arrays.stream(reader.readLine().split(" "))
                    .mapToInt(Integer::parseInt).forEach(queue::offer);

            int cords = 0;
            while (queue.size() > 1) {
                int a = queue.poll();
                int b = queue.poll();
                queue.offer(a + b);
                cords += a + b;
            }
            answer.append(cords).append('\n');
        }
        System.out.print(answer);
    }
}
