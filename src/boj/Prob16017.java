package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;

// https://www.acmicpc.net/problem/16017
public class Prob16017 {
    private static final Set<Integer> flNums = Set.of(8, 9);

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] numbers = reader.lines().limit(4).mapToInt(Integer::parseInt).toArray();
        boolean ignore = flNums.contains(numbers[0]) && flNums.contains(numbers[3]) && numbers[1] == numbers[2];
        System.out.println(ignore ? "ignore" : "answer");
    }
}
