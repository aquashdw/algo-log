package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

// https://www.acmicpc.net/problem/12404
public class Prob12404 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(reader.readLine());
        StringBuilder answer = new StringBuilder();
        Set<Integer> used = new HashSet<>();
        for (int i = 0; i < tests; i++) {
            int testCase = i + 1;
            int[] range = Arrays.stream(reader.readLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();
            int count = 0;
            for (int num = range[0]; num < range[1]; num++) {
                String numStr = String.valueOf(num);
                int ceil = numStr.length();
                while (numStr.charAt(ceil - 1) == '0') ceil--;
                for (int k = 1; k < ceil; k++) {
                    int cycled = Integer.parseInt(numStr.substring(k) + numStr.substring(0, k));
                    if (num < cycled && cycled <= range[1]) {
                        used.add(cycled);
                    }
                }
                count += used.size();
                used.clear();
            }
            answer.append("Case #").append(testCase).append(": ").append(count).append('\n');
        }
        System.out.print(answer);
    }
}
