package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/5430
public class Prob5430 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(reader.readLine());
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < tests; i++) {
            String command = reader.readLine();
            int length = Integer.parseInt(reader.readLine());
            String array = reader.readLine();
            answer.append(solve(command, length, array)).append('\n');
        }
        System.out.print(answer);
    }

    private static String solve(String commands, int length, String array) {
        String[] nums = length == 0 ? new String[]{} : array.substring(1, array.length() - 1)
                .split(",");

        boolean reversed = false;
        int start = 0;
        int end = length;
        for (char command: commands.toCharArray()) {
            switch (command) {
                case 'D' -> {
                    if (start == end) return "error";
                    if (reversed) {
                        end--;
                    } else {
                        start++;
                    }
                }
                case 'R' -> reversed = !reversed;
                default -> throw new IllegalArgumentException();
            }
        }

        StringBuilder result = new StringBuilder();
        result.append('[');
        if (reversed) for (int i = end - 1; i >= start; i--) {
            result.append(nums[i]);
            if (i != start) result.append(',');
        }
        else for (int i = start; i < end; i++) {
            result.append(nums[i]);
            if (i != end - 1) result.append(',');
        }
        result.append(']');
        return result.toString();
    }
}

