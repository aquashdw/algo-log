package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/6763
public class Prob6763 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int diff = reader.lines().limit(2).mapToInt(Integer::parseInt).reduce(0, (prev, next) -> {
            if (prev == 0) return next;
            return next - prev;
        });
        if (diff < 1) {
            System.out.println("Congratulations, you are within the speed limit!");
        }
        else if (diff <= 20) {
            System.out.println("You are speeding and your fine is $100.");
        }
        else if (diff <= 30) {
            System.out.println("You are speeding and your fine is $270.");
        }
        else {
            System.out.println("You are speeding and your fine is $500.");
        }
    }
}
