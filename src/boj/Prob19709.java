package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.acmicpc.net/problem/19709
public class Prob19709 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] nm = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int lunches = nm[0];
        int schoolCount = nm[1];
        int[] reqLunches = reader.lines().limit(schoolCount)
                .mapToInt(Integer::parseInt)
                .sorted()
                .toArray();

        int count = 0;
        for (int reqLunch : reqLunches) {
            if (!(lunches - reqLunch >= 0)) break;
            lunches -= reqLunch;
            count++;
        }
        System.out.println(count);
    }
}
