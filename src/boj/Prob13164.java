package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


// https://www.acmicpc.net/problem/13164
public class Prob13164 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] info = reader.readLine().split(" ");
        int kids = Integer.parseInt(info[0]);
        int groups = Integer.parseInt(info[1]);
        int[] heights = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[] heightDiff = new int[kids - 1];
        for (int i = 0; i < heightDiff.length; i++) {
            heightDiff[i] = heights[i + 1] - heights[i];
        }

        Arrays.sort(heightDiff);
        int sum = 0;
        for (int i = 0; i < kids - groups; i++) {
            sum += heightDiff[i];
        }
        System.out.println(sum);
    }
}
