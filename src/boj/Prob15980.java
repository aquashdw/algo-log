package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

// https://www.acmicpc.net/problem/15980
public class Prob15980 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] nm = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        int n = nm[0];
        int m = nm[1];
        int[] center = new int[m];
        List<String[]> birds = new ArrayList<>(m + 1);
        birds.add(null);
        reader.lines().limit(n).forEach(line -> {
            String[] bird = line.split(" ");
            int direction = bird[0].equals("L") ? -1 : 1;
            IntStream.range(0, m).forEach(sec -> {
                char chirp = bird[1].charAt(sec);
                if (chirp == '0') return;
                center[sec] += direction;
            });
            birds.add(bird);
        });

        int birdIdx = 0;
        int minMaxCenter = Integer.MAX_VALUE;
        for (int i = 1; i < n + 1; i++) {
            int birdMaxCenter = 0;
            int currentCenter = 0;
            String[] bird = birds.get(i);
            int direction = bird[0].equals("L") ? -1 : 1;
            String chirps = bird[1];
            for (int j = 0; j < m; j++) {
                currentCenter += center[j] - (chirps.charAt(j) == '1' ? direction : 0);
                birdMaxCenter = Math.max(birdMaxCenter, Math.abs(currentCenter));
            }
            if (birdMaxCenter < minMaxCenter) {
                minMaxCenter = birdMaxCenter;
                birdIdx = i;
            }
        }
        System.out.printf("%d%n%d%n", birdIdx, minMaxCenter);
    }
}
