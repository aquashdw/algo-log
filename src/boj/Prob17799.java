package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.acmicpc.net/problem/17799
public class Prob17799 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int capacity = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray()[1];

        int[] buckets = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .sorted()
                .toArray();

        int front = 0;
        int back = buckets.length - 1;
        int count = 0;
        while (front <= back) {
            if (front == back) {
                back--;
                count++;
            }
            else if (buckets[back] + buckets[front] <= capacity) {
                front++;
                back--;
                count++;
            }
            else {
                back--;
                count++;
            }
        }
        System.out.println(count);
    }
}
