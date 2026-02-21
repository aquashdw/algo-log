package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

// https://www.acmicpc.net/problem/17608
public class Prob17608 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        Deque<Integer> stack = new LinkedList<>();
        reader.lines().limit(n).forEach(s -> stack.push(Integer.parseInt(s)));
        int lastMax = stack.pop();
        int count = 1;
        while (!stack.isEmpty()) {
            int next = stack.pop();
            if (next > lastMax) {
                lastMax = next;
                count++;
            }
        }
        System.out.println(count);
    }
}
