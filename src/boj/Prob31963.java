package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.acmicpc.net/problem/31963
public class Prob31963 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int[] nums = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        int[] count = new int[n];
        int total = 0;
        for (int i = 1; i < n; i++) {
            double log = log2((double) nums[i - 1] / nums[i]);
            double temp = Math.ceil(log) + count[i - 1];
            if (temp > 0) {
                count[i] = (int) temp;
                total += count[i];
            }
        }
        System.out.println(total);
    }

    private static double log2(double n) {
        return Math.log(n) / Math.log(2);
    }

}
/*
from math import ceil, log2

n = int(input())
nums = list(map(int, input().split()))

result = 0
count = [0 for _ in range(n)]

for i in range(1, n):
    log = log2(nums[i - 1] / nums[i])
    temp = ceil(log) + count[i - 1]
    if temp > 0:
        count[i] = temp
        result += count[i]

print(result)

 */