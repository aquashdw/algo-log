package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

// https://www.acmicpc.net/problem/12481
public class Prob12481 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        long[] binToLongs = new long[60];
        long value = 1;
        for (int i = 0; i < 60; i++) {
            binToLongs[i] = value;
            value *= 2;
        }
        int tests = Integer.parseInt(reader.readLine());

        AtomicInteger caseNum = new AtomicInteger(1);
        StringBuilder answer = new StringBuilder();
        reader.lines().limit(tests).forEach(masked -> {
            List<Integer> questionMarks = new ArrayList<>(20);
            long base = IntStream.range(0, masked.length())
                    .filter(i -> {
                        if (masked.charAt(i) == '1') {
                            return true;
                        }
                        if (masked.charAt(i) == '?') {
                            questionMarks.add(i);
                        }
                        return false;
                    })
                    .mapToLong(i -> {
                        int exp = masked.length() - i - 1;
                        return binToLongs[exp];
                    })
                    .sum();

            int markCount = questionMarks.size();
            boolean[] qToOne = new boolean[markCount];
            for (int i = 0; i < 1 << markCount; i++) {
                long sum = base;
                for (int j = 0; j < markCount; j++) {
                    if ((i & (1 << j)) != 0) {
                        qToOne[j] = true;
                        int exp = masked.length() - questionMarks.get(j) - 1;
                        sum += binToLongs[exp];
                    }
                    else qToOne[j] = false;
                }
                long root = (long) Math.sqrt(sum);
                if (root * root == sum) {
                    answer.append("Case #").append(caseNum.getAndIncrement()).append(": ");
                    int listIdx = 0;
                    for (int j = 0; j < masked.length(); j++) {
                        if (masked.charAt(j) != '?') {
                            answer.append(masked.charAt(j));
                            continue;
                        }
                        answer.append(qToOne[listIdx] ? 1 : 0);
                        listIdx++;
                    }
                    answer.append('\n');
                    break;
                }
            }
        });

        System.out.print(answer);
    }
}
/*
Case #1: 1001
Case #2: 1
Case #3: 1011110110000100001

Case #1: 1001
Case #2: 1
Case #3: 1011110110000100001
 */