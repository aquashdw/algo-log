package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

// https://www.acmicpc.net/problem/2469
public class Prob2469 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int people = Integer.parseInt(reader.readLine());
        int lines = Integer.parseInt(reader.readLine());
        int[] top = IntStream.range(0, people).toArray();
        int[] bot = reader.readLine().chars().map(ch -> ch - 'A').toArray();
        List<String> ladder = new ArrayList<>(lines);
        reader.lines().limit(lines).forEach(ladder::add);
        int idx = 0;
        while (true) {
            String line = ladder.get(idx);
            if (line.contains("?")) break;
            for (int i = 0; i < people - 1; i++) {
                if (line.charAt(i) == '-') {
                    int temp = top[i];
                    top[i] = top[i + 1];
                    top[i + 1] = temp;
                }
            }
            idx++;
        }


        idx = lines;
        while (true) {
            idx--;
            String line = ladder.get(idx);
            if (line.contains("?")) break;
            for (int i = 0; i < people - 1; i++) {
                if (line.charAt(i) == '-') {
                    int temp = bot[i];
                    bot[i] = bot[i + 1];
                    bot[i + 1] = temp;
                }
            }
        }

        int[] diffs = IntStream.range(0, people).filter(i -> top[i] != bot[i]).toArray();
        if (diffs.length % 2 != 0) {
            System.out.println("x".repeat(people - 1));
            return;
        }

        char[] hr = new char[people - 1];
        Arrays.fill(hr, '*');
        boolean success = true;
        for (int i = 0; i < diffs.length / 2; i++) {
            int left = diffs[2 * i];
            int right = diffs[2 * i + 1];
            if (left != right - 1) {
                success = false;
                break;
            }

            hr[left] = '-';
        }

        if (!success) {
            System.out.println("x".repeat(people - 1));
            return;
        }
        System.out.println(new String(hr));
    }
}
