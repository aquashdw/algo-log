package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.acmicpc.net/problem/24884
public class Prob24884 {
    private static int time;
    private static int floor;
    private static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        time = info[2];
        floor = info[3];

        int[] fires = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        dfs(0, info[1], -1, fires);
        System.out.println(count);
    }

    private static void dfs(int current, int now, int safe, int[] fires) {
        // 0, 1
        int[] nextFires = Arrays.copyOf(fires, fires.length);

        for (int i = 0; i < fires.length; i++) {
            if (i == safe) continue;
            if (fires[i] == 0) continue;
            int onCount = 0;
            if (i > 0 && fires[i - 1] > 0) onCount++;
            if (i < fires.length - 1 && fires[i + 1] > 0) onCount++;
            if (onCount == 2) nextFires[i] = Math.max(nextFires[i] - 1, 0);
            else if (onCount == 1) nextFires[i] = Math.max(nextFires[i] - 2, 0);
            else nextFires[i] = Math.max(nextFires[i] - 3, 0);
        }
        if (Arrays.stream(nextFires).filter(fire -> fire > 0).count() < floor)
            return;
        current++;
        if (current == time) {
            count++;
            return;
        }

        if (now > 0) {
            dfs(current, now - 1, now - 1, nextFires);
        }
        dfs(current, now, now, nextFires);
        if (now < fires.length - 1) {
            dfs(current, now + 1, now + 1, nextFires);
        }
    }

}
