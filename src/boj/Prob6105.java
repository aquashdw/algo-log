package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.stream.Collectors;

// https://www.acmicpc.net/problem/6105
public class Prob6105 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int[] cows = reader.lines().limit(n).mapToInt(Integer::parseInt).toArray();
        int[] lookUp = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(0);
        for (int i = 1; i < n; i++) {
            while (!stack.isEmpty() && cows[stack.peek()] < cows[i]) {
                lookUp[stack.pop()] = i + 1;
            }
            stack.push(i);
        }
        System.out.println(Arrays.stream(lookUp).mapToObj(String::valueOf).collect(Collectors.joining("\n")));
    }
}
