package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.IntStream;

// https://www.acmicpc.net/problem/2607
public class Prob2607 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(reader.readLine());
        int[] originCount = new int[26];
        reader.readLine().chars().forEach(c -> originCount[c - 'A']++);
        int originLength = Arrays.stream(originCount).sum();
        int[] targetCount = new int[26];
        System.out.println(reader.lines().limit(tests - 1)
                .filter(line -> {
                    if (Math.abs(line.length() - originLength) > 1) return false;
                    Arrays.fill(targetCount, 0);
                    line.chars().forEach(c -> targetCount[c - 'A']++);
                    IntStream.range(0, 26).forEach(i -> targetCount[i] = Math.abs(originCount[i] - targetCount[i]));
                    // 한 글자가 두개 이상 차이나면 빼도 차이가 1 남는다.
                    int max = Arrays.stream(targetCount).max().orElseThrow();
                    if (max > 1) return false;
                    // 총 차이가 2보다 클 경우 한 글자를 다른 글자로 바꾸어도
                    int sum = Arrays.stream(targetCount).sum();
                    return sum <= 2;
                }).count());
    }
}
