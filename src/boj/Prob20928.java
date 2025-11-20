package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.acmicpc.net/problem/20928
public class Prob20928 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] nm = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        int n = nm[0];
        int[] positions = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        int[] power = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        int canReach = positions[0] + power[0];
        int idx = 1;
        int count = 0;
        while (idx < n && canReach < nm[1]) {
            int maxReach = canReach;
            while (idx < n && canReach >= positions[idx]) {
                maxReach = Math.max(maxReach, positions[idx] + power[idx]);
                idx++;
            }
            if (canReach == maxReach) break;

            canReach = maxReach;
            count++;
        }
        System.out.println(canReach >= nm[1] ? count : -1);
    }
}
