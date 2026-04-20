package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Collectors;

// https://www.acmicpc.net/problem/3047
public class Prob3047 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] nums = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt).sorted().toArray();
        System.out.println(reader.readLine().chars()
                .mapToObj(ch -> String.valueOf(nums[ch - 'A'])).collect(Collectors.joining(" ")));
    }
}
