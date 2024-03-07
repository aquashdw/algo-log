package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Prob2075 {
    public int solution() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            String[] lineNums = reader.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                priorityQueue.offer(Integer.parseInt(lineNums[j]));
                if (priorityQueue.size() > n) {
                    priorityQueue.poll();
                }
            }
        }

        return priorityQueue.peek();
    }

    public static void main(String[] args) throws IOException {
        System.out.println(new Prob2075().solution());
    }
}
