package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.acmicpc.net/problem/7130
public class Prob7130 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] happy = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        int fields = Integer.parseInt(reader.readLine());
        System.out.println(reader.lines().limit(fields)
                .map(line -> Arrays.stream(line.split(" "))
                        .mapToInt(Integer::parseInt).toArray())
                .mapToInt(field -> {
                    field[0] *= happy[0];
                    field[1] *= happy[1];
                    return Math.max(field[0], field[1]);
                })
                .sum());
    }
}
