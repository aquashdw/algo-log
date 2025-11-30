package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.IntStream;

// https://www.acmicpc.net/problem/27042
public class Prob27042 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        Queue<Integer> queue = new LinkedList<>();
        IntStream.range(1, n + 1).forEach(queue::offer);
        while (queue.size() > 1) {
            int pass = queue.poll();
            queue.poll();
            queue.offer(pass);
        }
        System.out.println(queue.poll());
    }
}
