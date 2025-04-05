package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.acmicpc.net/problem/17388
public class Prob17388 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] problems = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        int sum = Arrays.stream(problems).sum();
        if (sum >= 100) {
            System.out.println("OK");
            return;
        }
        if (problems[0] < problems[1]) {
            if (problems[0] < problems[2]) {
                System.out.println("Soongsil");
            } else {
                System.out.println("Hanyang");
            }
        } else if (problems[1] < problems[2]) {
            System.out.println("Korea");
        } else System.out.println("Hanyang");
    }
}
