package boj.onhold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// https://www.acmicpc.net/problem/32631
public class Prob32631 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        int items = info[0];
        int moves = info[1];


        Deque<Long> bagA = new ArrayDeque<>(items);
        long weightA = 0;
        for (long weight : Arrays.stream(reader.readLine().split(" "))
                .mapToLong(Long::parseLong).toArray()) {
            weightA += weight;
            bagA.offer(weight);
        }
        Deque<Long> bagB = new ArrayDeque<>(items);
        long weightB = 0;
        for (long weight : Arrays.stream(reader.readLine().split(" "))
                .mapToLong(Long::parseLong).toArray()) {
            weightB += weight;
            bagB.offer(weight);
        }

        List<Deque<Long>> bags = new ArrayList<>(2);
        bags.add(bagA);
        bags.add(bagB);
        long[] weights = {weightA, weightB};

        Queue<Integer> nextBags = new PriorityQueue<>(Comparator.comparingLong(i -> -weights[i]));
        nextBags.addAll(List.of(0, 1));
        while (moves-- > 0 && !nextBags.isEmpty()) {
            int nextIdx = nextBags.poll();
            Deque<Long> bag = bags.get(nextIdx);
            if (bag.isEmpty()) continue;
            if (bag.peekFirst() > bag.peekLast()) weights[nextIdx] -= bag.pollFirst();
            else weights[nextIdx] -= bag.pollLast();

            if (weights[nextIdx] > 0) nextBags.offer(nextIdx);
        }
        System.out.println(nextBags.isEmpty() ? 0 : weights[nextBags.poll()]);
    }
}
