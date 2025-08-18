package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.acmicpc.net/problem/27182
public class Prob27182 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] nm = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        int today = nm[0];
        int twoWeeksAgo = nm[1];
        if (today > 7) System.out.println(today - 7);
        else System.out.println(twoWeeksAgo + 7);
    }
}
