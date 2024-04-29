package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.acmicpc.net/problem/2530
public class Prob2530 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] time = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int seconds = Integer.parseInt(reader.readLine());
        int newSec = time[2] + seconds;
        int newMin = time[1] + newSec / 60;
        newSec %= 60;
        int newHour = time[0] + newMin / 60;
        newMin %= 60;
        newHour %= 24;
        System.out.printf("%d %d %d%n", newHour, newMin, newSec);
    }
}
