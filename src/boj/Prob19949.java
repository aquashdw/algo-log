package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.acmicpc.net/problem/19949
public class Prob19949 {
    private static int[] answers;
    private static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        answers = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        pick(0, 0, new int[10]);
        System.out.println(count);
    }

    private static void pick(int num, int correct, int[] picked) {
        if (num == 10) {
            count++;
            return;
        }

        int left = 9 - num;
        for (int i = 1; i < 6; i++) {
            if (left + correct < 5 && i != answers[num]) continue;
            if (num > 1 && i == picked[num - 1] && picked[num - 1] == picked[num - 2]) continue;
            picked[num] = i;
            pick(num + 1, correct + (answers[num] == i ? 1 : 0), picked);
        }
    }
}
