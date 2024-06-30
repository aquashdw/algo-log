package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.acmicpc.net/problem/9631
public class Prob9631 {
    private static final int CEIL_MOD = (int) (Math.pow(10, 9)) + 7;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(reader.readLine());
        StringBuilder answer = new StringBuilder();
        reader.lines().limit(tests)
                .forEach(sticker -> answer.append(candidates(sticker))
                        .append('\n'));
        System.out.print(answer);
    }

    private static long candidates(String sticker) {
        Boolean[] used = new Boolean[26];
        Arrays.fill(used, false);
        for (int i = 0; i < sticker.length(); i++) {
            char now = sticker.charAt(i);
            if (now != '?') used[now - 'a'] = true;
        }
        if (Arrays.stream(used).filter(b -> b).count() == 1) return 1;
        long count = 1;
        for (int i = 0; i < sticker.length(); i++) {
            char now = sticker.charAt(i);
            if (now == '?'){
                int end = i;
                for (int j = i; j < sticker.length(); j++) {
                    if (sticker.charAt(j) != '?') {
                        end = j;
                        break;
                    }
                }
                if (end == i) {
                    end = sticker.length();
                }
                else if (i != 0) {
                    if (sticker.charAt(i - 1) != sticker.charAt(end)) {
                        count *= end - i + 1;
                        count %= CEIL_MOD;
                    }
                }
                i = end;
            }
        }
        return count;
    }
}
