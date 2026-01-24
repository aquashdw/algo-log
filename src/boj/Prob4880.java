package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Collectors;

// https://www.acmicpc.net/problem/4880
public class Prob4880 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println(reader.lines().takeWhile(line -> !line.equals("0 0 0")).map(line -> {
                    int[] arr = Arrays.stream(line.split(" ")).mapToInt(Integer::parseInt).toArray();
                    if (arr[1] - arr[0] == arr[2] - arr[1])
                        return String.format("AP %d%n", arr[2] + (arr[1] - arr[0]));
                    else
                        return String.format("GP %d%n", arr[2] * (arr[1] / arr[0]));
                })
                .collect(Collectors.joining()));
    }
}
