package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.acmicpc.net/problem/2090
public class Prob2090 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        reader.readLine();
        long[] nums = Arrays.stream(reader.readLine().split(" "))
                .mapToLong(Long::parseLong).toArray();

        long dividend = 1;
        long divisor = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dividend *= nums[i];
            dividend += divisor;
            divisor *= nums[i];
            long gcd = gcd(dividend, divisor);
            dividend /= gcd;
            divisor /= gcd;
        }
        System.out.printf("%d/%d\n", divisor, dividend);
    }

    private static long gcd(long x, long y) {
        while (y > 0) {
            long temp = y;
            y = x % y;
            x = temp;
        }
        return x;
    }
}
