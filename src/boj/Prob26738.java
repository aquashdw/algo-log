package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// https://www.acmicpc.net/problem/26738
public class Prob26738 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int[] candy = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        Map<Integer, Integer> count = new HashMap<>();
        Set<Integer> overThree = new HashSet<>();
        int front = 0;
        int back = 0;
        int minLen = n + 1;
        while (front < n) {
            while (!overThree.isEmpty()) {
                minLen = Math.min(minLen, back - front);
                int newCount = count.get(candy[front]) - 1;
                count.put(candy[front], newCount);
                if (newCount < 3) overThree.remove(candy[front]);
                front++;
            }
            while (back < n && overThree.isEmpty()) {
                int newCount = count.getOrDefault(candy[back], 0) + 1;
                count.put(candy[back], newCount);
                if (newCount >= 3) overThree.add(candy[back]);
                back++;
            }
            if (back == n && overThree.isEmpty()) {
                break;
            }
        }
        System.out.println(minLen == n + 1 ? "NIE" : minLen);
    }
}
