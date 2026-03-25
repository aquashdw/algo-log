package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Collectors;

// https://www.acmicpc.net/problem/5101
public class Prob5101 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(reader.lines().takeWhile(line -> !line.equals("0 0 0"))
                .map(line -> {
                    int[] nums = Arrays.stream(line.split(" ")).mapToInt(Integer::parseInt).toArray();
                    int diff = nums[2] - nums[0];
                    if (diff < 0 || diff % nums[1] != 0) {
                        return "X";
                    }

                    return String.valueOf(diff / nums[1] + 1);
                }).collect(Collectors.joining("\n")));

    }
}
