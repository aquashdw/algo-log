package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/30089
public class Prob30089 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(reader.readLine());
        StringBuilder answer = new StringBuilder();
        reader.lines().limit(tests).forEach(line -> answer.append(toPalindrome(line)).append('\n'));
        System.out.print(answer);
    }

    private static String toPalindrome(String input) {
        char[] origin = input.toCharArray();
        int offset = 0;
        while (offset < origin.length - 1) {
            boolean success = true;
            for (int i = 0; i < origin.length; i++) {
                // i < offset일 경우 그대로 i (덧붙인 문자열)
                // i >= offset일 경우 뒤에서부터,
                // 단 i 만큼 뺄 경우 제일 뒤가 아니라 앞으로 이동한 문자가 됨으로
                // 다시 offset을 더해준다
                int lastIndex = i < offset ? i : (origin.length - 1 - i + offset);
                if (origin[i] != origin[lastIndex]) {
                    success = false;
                    break;
                }
            }
            if (success) break;
            offset++;
        }
        StringBuilder result = new StringBuilder();
        int offsetIdx = offset;
        for (int i = 0; i < origin.length + offset; i++) {
            int idx = i;
            if (idx > origin.length - 1) {
                idx = --offsetIdx;
            }
            result.append(origin[idx]);
        }
        return result.toString();
    }
}
