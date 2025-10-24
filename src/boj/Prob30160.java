package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Collectors;

// https://www.acmicpc.net/problem/30160
public class Prob30160 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        long[] nums = Arrays.stream(reader.readLine().split(" "))
                .mapToLong(Long::parseLong).toArray();
        long[] sums = new long[n];
        sums[0] = nums[0];
        for (int i = 1; i < n; i++) {
            sums[i] = sums[i - 1] + nums[i];
        }
        long[] results = new long[n];
        results[0] = nums[0];
        if (n == 1) {
            System.out.println(results[0]);
            return;
        }
        results[1] = 4 * nums[0] + nums[1];
        if (n == 2) {
            System.out.printf("%d %d%n", results[0], results[1]);
            return;
        }

        for (int i = 2; i < n; i++) {
            results[i] = 2 * sums[i] - nums[i] + 2 * results[i - 1] - results[i - 2];
        }
        System.out.println(Arrays.stream(results).mapToObj(String::valueOf).collect(Collectors.joining(" ")));
    }
}

/*
A1 1
A2 4 1
A3 9 4 1

A2-A1 = 3 1
A3-A2 = 5 3 1
A4-A3 = 7 5 3 1

A3-A2-A2+A1 = 2 2 1
A4-A3-A3+A2 = 2 2 2 1

An-A(n-1)-A(n-1)+A(n-2) = 2Sn-an
An = 2Sn-an+2A(n-1)-A(n-2)
(Sn = a1 + ... + an)
 */
