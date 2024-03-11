package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


// https://www.acmicpc.net/problem/2609
public class Prob2609 {
    public static void main(String[] args) throws IOException {
        int[] nums = Arrays.stream(new BufferedReader(new InputStreamReader(System.in)).readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int x = Math.max(nums[0], nums[1]);
        int y = Math.min(nums[0], nums[1]);
        int gcd = gcd(x, y);
        int lcm = lcm(x, y, gcd);
        StringBuilder answer = new StringBuilder();
        answer.append(gcd).append('\n').append(lcm);
        System.out.println(answer);
    }

    private static int lcm(int x, int y) {
        return lcm(x, y, gcd(x, y));
    }

    private static int lcm(int x, int y, int gcd) {
        return x * y / gcd;
    }

    private static int gcd(int x, int y) {
        while (y > 0) {
            int temp = y;
            y = x % y;
            x = temp;
        }
        return x;
    }
}
