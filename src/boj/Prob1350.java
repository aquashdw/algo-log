package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.acmicpc.net/problem/1350
public class Prob1350 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int[] files = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        long cluster = Long.parseLong(reader.readLine());
        long total = Arrays.stream(files)
                .filter(file -> file > 0)
                .mapToLong(file -> (file / cluster + (file % cluster == 0 ? 0 : 1)) * cluster)
                .sum();
        System.out.println(total);
    }
}
