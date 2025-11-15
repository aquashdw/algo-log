package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.acmicpc.net/problem/24589
public class Prob24589 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int[] arrives = new int[n + 1];
        reader.lines().limit(n).forEach(line -> {
            int[] packet = Arrays.stream(line.split(" ")).mapToInt(Integer::parseInt).toArray();
            arrives[packet[1]] = packet[0];
        });
        int time = 0;
        int delay = 0;
        for (int i = 1; i < n + 1; i++) {
            time++;
            if (arrives[i] <= time) continue;
            delay += arrives[i] - time;
            time = arrives[i];
        }
        System.out.println(delay);
    }
}
