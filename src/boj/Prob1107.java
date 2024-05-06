package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.acmicpc.net/problem/1107
public class Prob1107 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String targetStr = reader.readLine();
        int target = Integer.parseInt(targetStr);
        if (target == 100) {
            System.out.println(0);
            return;
        }
        int brokeCount = Integer.parseInt(reader.readLine());
        int[] broken = brokeCount == 0 ? new int[]{} : Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int upOrDown = 0;
        int higher = target;
        boolean moveFromHigh = canMove(higher, broken);
        int lower = target;
        boolean moveFromLow = canMove(lower, broken);
        while (!moveFromHigh && !moveFromLow && lower != 100 && higher != 100) {
            higher += 1;
            lower = Math.max(lower - 1, 0);
            upOrDown++;
            moveFromHigh = canMove(higher, broken);
            moveFromLow = canMove(lower, broken);
        }

        int buttonMin;
        if (moveFromLow) {
            buttonMin = String.valueOf(lower).length();
        }
        else {
            buttonMin = String.valueOf(higher).length();
        }

        System.out.println(Math.min(buttonMin + upOrDown, Math.abs(target - 100)));
    }

    private static boolean canMove(int num, int[] broken) {
        if (num == 0) {
            int required = 0;
            return Arrays.stream(broken).noneMatch(i -> i == required);
        }
        while (num > 0) {
            int required = num % 10;
            if (Arrays.stream(broken).anyMatch(i -> i == required)) {
                return false;
            }
            num /= 10;
        }
        return true;
    }
}
