package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.acmicpc.net/problem/5575
public class Prob5575 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        int tests = Integer.parseInt(reader.readLine());
        StringBuilder answer = new StringBuilder();
        reader.lines().limit(3).forEach(line ->
                answer.append(toString(workTime(Arrays.stream(line.split(" "))
                                .mapToInt(Integer::parseInt)
                                .toArray())))
                        .append('\n'));
        System.out.print(answer);
    }
    private static String toString(int[] workTime) {
        return String.format("%d %d %d", workTime[0], workTime[1], workTime[2]);
    }

    private static int[] workTime(int[] timeRec) {
        int secs;
        int mins = 0;
        int hours = 0;
        secs = timeRec[5] - timeRec[2];
        if (secs < 0) {
            secs += 60;
            mins--;
        }
        mins += timeRec[4] - timeRec[1];
        if (mins < 0) {
            mins += 60;
            hours--;
        }
        hours += timeRec[3] - timeRec[0];
        if (hours < 0) throw new IllegalArgumentException();
        return new int[]{hours, mins, secs};
    }
}
