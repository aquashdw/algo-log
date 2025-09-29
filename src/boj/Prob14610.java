package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.IntStream;

// https://www.acmicpc.net/problem/14610
public class Prob14610 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] nm = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        int people = nm[0];
        int problems = nm[1];
        boolean[] solved = new boolean[problems];
        int[][] addToSolve = new int[people][2];
        for (int i = 0; i < people; i++) {
            int[] stats = Arrays.stream(reader.readLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();

            if (stats[0] == 0 || stats[0] == problems) {
                System.out.println("NO");
                return;
            }

            int count = 0;
            for (int j = 1; j < problems + 1; j++) {
                if (stats[j] == -1) {
                    addToSolve[i][0] = j - 1;
                    break;
                }
                if (stats[j] == 1) {
                    solved[j - 1] = true;
                    count++;
                }
            }
            addToSolve[i][1] = stats[0] - count;
        }

        int solver = 0;
        while (solver < people && addToSolve[solver][1] == 0) solver++;
        for (int i = 0; i < problems; i++) {
            if (solver == people) break;
            if (solved[i]) continue;
            if (addToSolve[solver][0] > i) break;
            solved[i] = true;
            addToSolve[solver][1]--;
            while (solver < people && addToSolve[solver][1] == 0) solver++;
        }

        System.out.println(IntStream.range(0, problems).allMatch(i -> solved[i]) ? "YES" : "NO");
    }
}
