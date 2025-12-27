package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.acmicpc.net/problem/2997
public class Prob2997 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] nums = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt).sorted().toArray();
        // 1 2 3 / 2 3 4
        if (nums[1] - nums[0] == nums[2] - nums[1]) {
            int a = nums[2] + (nums[1] - nums[0]);
            int b = nums[0] - (nums[1] - nums[0]);
            if (a > 100 || a < -100) System.out.println(a);
            else System.out.println(b);
        }
        // 1 3 4
        else if (nums[1] - nums[0] > nums[2] - nums[1]) {
            System.out.println(nums[0] + (nums[2] - nums[1]));
        }
        // 1 2 4
        else {
            System.out.println(nums[1] + (nums[1] - nums[0]));
        }
    }
}
