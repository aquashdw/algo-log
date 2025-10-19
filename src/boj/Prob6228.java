package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://www.acmicpc.net/problem/6228
public class Prob6228 {
    private static long total;
    private static int dice;
    private static int[] count;
    private static List<List<int[]>> expressions;

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        dice = info[0];
        count = new int[info[1] + 1];
        int cases = info[2];
        expressions = new ArrayList<>(cases);
        total = 0;
        for (int test = 0; test < cases; test++) {
            String[] basics = reader.readLine().split("\\+");
            List<int[]> expression = new ArrayList<>(basics.length);
            for (String basic : basics) {
                int[] wr = Arrays.stream(basic.split("x")).mapToInt(Integer::parseInt).toArray();
                expression.add(wr);
            }
            expressions.add(expression);
        }
        dfs(dice, 1);
        System.out.println(total);
    }

    private static void dfs(int left, int now) {
        if (now == count.length && left != 0) {
            return;
        }
        if (left == 0) {
            for (List<int[]> expression : expressions) {
                if (check(count, expression)) {
                    total += count(count);
                    return;
                }
            }
            return;
        }
        for (int i = 0; i < left + 1; i++) {
            count[now] += i;
            dfs(left - i, now + 1);
            count[now] -= i;
        }

    }

    private static boolean check(int[] count, List<int[]> expression) {
        for (int[] form : expression) {
            if (count[form[1]] < form[0]) return false;
        }
        return true;
    }

    private static long count(int[] count) {
        long total = 1;
        for (int i = 1; i < dice + 1; i++) {
            total *= i;
        }
        for (int die : count) {
            if (die == 0) continue;
            for (int i = 1; i < die + 1; i++) {
                total /= i;
            }
        }
        return total;
    }
}
/*
20 8 1
1x2+2x2+3x2+4x2+5x2+6x2+7x2+8x2
 */