package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.acmicpc.net/problem/2420
public class Prob2420 {

    public static void main(String[] args) throws IOException {
        long[] nums = Arrays.stream(new BufferedReader(new InputStreamReader(System.in)).readLine().split(" "))
                        .mapToLong(Long::parseLong)
                        .toArray();
        System.out.println(Math.abs(nums[0] - nums[1]));
    }
}
