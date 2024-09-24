package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.acmicpc.net/problem/3151
public class Prob3151 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int[] numbers = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .sorted()
                .toArray();
        long answers = 0;
        for (int i = 0; i < n; i++) {
            if (numbers[i] > 0) break;
            int left = i + 1;
            int right = n - 1;
            while (left < right) {
                int sum = numbers[left] + numbers[right] + numbers[i];
                if (sum > 0) {
                    right--;
                    continue;
                }
                else if (sum < 0) {
                    left++;
                    continue;
                }

                if (numbers[left] == numbers[right]) {
                    int count = right - left + 1;
                    answers += (long) count * (count - 1) / 2;
                    break;
                }

                int lStart = left;
                while (left + 1 < right && numbers[left] == numbers[left + 1]) {
                    left++;
                }
                int lCount = left - lStart + 1;

                int rStart = right;
                while (left < right - 1 && numbers[right] == numbers[right - 1]) {
                    right--;
                }
                int rCount = rStart - right + 1;
                answers += (long) lCount * rCount;
                left++;
            }
        }
        System.out.println(answers);
    }
}
