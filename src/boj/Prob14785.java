package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

// https://www.acmicpc.net/problem/14785
public class Prob14785 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        Queue<int[]> leashes = new PriorityQueue<>((o1, o2) -> {
            if (o1[1] == o2[1]) return Integer.compare(o1[0], o2[0]);
            return Integer.compare(o1[1], o2[1]);
        });
        reader.lines().limit(n).forEach(line -> {
            int[] leash = Arrays.stream(line.split(" "))
                    .mapToInt(Integer::parseInt).toArray();
            leash[1] += leash[0];
            leashes.offer(leash);
        });
        int cuts = 0;
        while (!leashes.isEmpty()) {
            cuts++;
            int[] leash = leashes.poll();
            while (!leashes.isEmpty() && leashes.peek()[0] < leash[1]) {
                leashes.remove();
            }
        }
        System.out.println(cuts);
    }
}
/*
666 . . . . . . . . . . .
. . 1111111 . . . . . . .
. . . 3333333 . . . . . . .
. . . . 222222222222222 . .
. . . . . 4444444 . . . . .
. . . . . . . 7777777 . . .
. . . . . . . . . 555555555
 */