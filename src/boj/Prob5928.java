package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.acmicpc.net/problem/5928
public class Prob5928 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] endTime = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int dayDiff = endTime[0] - 11;
        int hourDiff = endTime[1] - 11;
        int minuteDiff = endTime[2] - 11;

        if (minuteDiff < 0) {
            minuteDiff += 60;
            hourDiff -= 1;
        }
        if (hourDiff < 0) {
            hourDiff += 24;
            dayDiff -= 1;
        }

        if (dayDiff < 0) {
            System.out.println(-1);
            return;
        }

        hourDiff += dayDiff * 24;
        minuteDiff += hourDiff * 60;
        System.out.println(minuteDiff);
    }
}
