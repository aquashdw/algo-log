package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/10101
public class Prob10101 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] degrees = reader.lines().limit(3)
                .mapToInt(Integer::parseInt)
                .toArray();
        if (degrees[0] + degrees[1] + degrees[2] != 180) {
            System.out.println("Error");
        } else {
            if (degrees[0] == degrees[1] && degrees[1] == degrees[2]) {
                System.out.println("Equilateral");
            } else if (degrees[0] == degrees[1] || degrees[1] == degrees[2] || degrees[2] == degrees[0]) {
                System.out.println("Isosceles");
            } else System.out.println("Scalene");
        }
    }
}
