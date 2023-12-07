package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.acmicpc.net/problem/14501
public class Prob14501 {
    private static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int[][] councils = new int[n + 1][];
        for (int i = 0; i < n; i++) {
            councils[i] = Arrays.stream(reader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        schedule(n, councils, 0, 0);

        System.out.println(max);
    }

    public static void schedule(int maxDays, int[][] councils, int currentDay, int currentPay) {
        // 퇴사일이다.
        if (currentDay == maxDays) {
            // 퇴직금 받자.
            max = Math.max(max, currentPay);
        }
        // 오늘 일하면 퇴사일을 넘어간다.
        else if (currentDay + councils[currentDay][0] > maxDays){
            // 내일을 기약하자.
            schedule(maxDays, councils, currentDay + 1, currentPay);
        }
        // 오늘 일을 할지는 선택할 수 있다.
        else {
            // 일을 해보자.
            // 일단 하루 걸리고, 하루 이상 걸리는 일은 - 1 하고 더한다.
            schedule(
                    maxDays,
                    councils,
                    currentDay + councils[currentDay][0],
                    currentPay + councils[currentDay][1]
            );
            // 하지말자.
            schedule(
                    maxDays,
                    councils,
                    currentDay + 1,
                    currentPay
            );
        }
    }
}
