package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.stream.Collectors;

// https://www.acmicpc.net/problem/24929
public class Prob24929 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        Deque<Integer> pos = new ArrayDeque<>();
        Deque<Integer> neg = new ArrayDeque<>();
        Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .forEach(i -> {
                    if (i > 0) {
                        pos.offerLast(i);
                    } else {
                        neg.offerLast(i);
                    }
                    while (!pos.isEmpty() && !neg.isEmpty()) {
                        int nextPos = pos.removeLast();
                        int nextNeg = neg.removeLast();
                        int sum = nextPos + nextNeg;
                        if (sum > 0) pos.offerLast(sum);
                        else if (sum < 0) neg.offerLast(sum);
                    }
                });
        if (pos.size() == neg.size()) {
            System.out.println("Tie!");
        } else if (!pos.isEmpty()) {
            System.out.printf("Positives win!%n%s%n", pos.stream().map(String::valueOf).collect(Collectors.joining(" ")));
        } else {
            System.out.printf("Negatives win!%n%s%n", neg.stream().map(String::valueOf).collect(Collectors.joining(" ")));
        }
    }
}
