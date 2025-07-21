package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.acmicpc.net/problem/3029
public class Prob3029 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] now = Arrays.stream(reader.readLine().split(":"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int[] target = Arrays.stream(reader.readLine().split(":"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int secDiff = target[2] - now[2];
        if (secDiff < 0) {
            target[1]--;
            secDiff += 60;
        }
        int minDiff = target[1] - now[1];
        if (minDiff < 0) {
            target[0]--;
            minDiff += 60;
        }
        int hourDiff = target[0] - now[0];
        if (hourDiff < 0) {
            hourDiff += 24;
        }
        if (hourDiff == 0 && minDiff == 0 && secDiff == 0) {
            hourDiff = 24;
        }
        System.out.printf("%02d:%02d:%02d%n", hourDiff, minDiff, secDiff);
    }
}
