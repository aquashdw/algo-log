package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

// https://www.acmicpc.net/problem/17433
public class Prob17433 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(reader.readLine());
        StringBuilder answer = new StringBuilder();
        for (int test = 0; test < tests; test++) {
            int n = Integer.parseInt(reader.readLine());
            int[] nums = Arrays.stream(reader.readLine().split(" "))
                    .mapToInt(Integer::parseInt).sorted().toArray();

            List<Integer> diffs = new LinkedList<>();
            for (int i = 0; i < n - 1; i++) {
                if (nums[i + 1] - nums[i] != 0) diffs.add(nums[i + 1] - nums[i]);
            }
            if (diffs.isEmpty()) {
                answer.append("INFINITY\n");
                continue;
            }

            int gcd = diffs.get(0);
            for (int diff : diffs) {
                gcd = gcd(gcd, diff);
            }
            answer.append(gcd).append('\n');
        }
        System.out.print(answer);

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
