package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.acmicpc.net/problem/10797
public class Prob10797 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int banned = Integer.parseInt(reader.readLine());
        System.out.println(Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .filter(num -> num == banned)
                .count());
    }
}
