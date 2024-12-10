package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

// https://www.acmicpc.net/problem/29814
public class Prob29814 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] nc = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        int n = nc[0];
        int passPoint = nc[1];

        Queue<int[]> assignments = new PriorityQueue<>((o1, o2) -> {
            if (o1[0] == o2[0]) {
                return -(o1[1] - o2[1]);
            }
            return -(o1[0] - o2[0]);
        });
        reader.lines().limit(n).map(line -> {
                    int[] origin = Arrays.stream(line.split(" "))
                            .mapToInt(Integer::parseInt).toArray();
                    return new int[]{origin[0] - origin[1], origin[2]};
                })
                .forEach(assignments::offer);

        Queue<Integer> canSolve = new PriorityQueue<>(Comparator.comparingInt(o -> -o));
        Queue<Integer> solved = new PriorityQueue<>();
        int totalPoints = 0;
        for (int i = 0; i < n; i++) {
            if (assignments.isEmpty() && canSolve.isEmpty()) break;
            int day = n - i - 1;
            while (!assignments.isEmpty() && assignments.peek()[0] >= day) {
                canSolve.offer(assignments.poll()[1]);
            }
            if (!canSolve.isEmpty()) {
                int point = canSolve.poll();
                totalPoints += point;
                solved.offer(point);
            }
        }
        if (totalPoints < passPoint) {
            System.out.println("I'm sorry professor Won!");
            return;
        }

        while (!solved.isEmpty() && totalPoints - solved.peek() >= passPoint) {
            totalPoints -= solved.poll();
        }
        System.out.println(solved.size());
    }
}


/*
7 50
7 1 10
7 1 10
7 1 10
7 1 10
7 1 10
7 1 10
7 1 10
 */