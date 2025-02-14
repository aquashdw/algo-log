package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.acmicpc.net/problem/6308
public class Prob6308 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line;
        int testCase = 1;
        StringBuilder answer = new StringBuilder();
        while (!(line = reader.readLine()).equals("0 0 0")) {
            int[] nmc = Arrays.stream(line.split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            int capacity = nmc[2];
            int[] machines = reader.lines().limit(nmc[0])
                    .mapToInt(Integer::parseInt)
                    .toArray();
            boolean[] used = new boolean[nmc[0]];

            int[] operations = reader.lines().limit(nmc[1])
                    .mapToInt(Integer::parseInt)
                    .map(i -> i - 1)
                    .toArray();

            int currentAmp = 0;
            int maxAmp = 0;
            for (int operation : operations) {
                used[operation] = !used[operation];
                currentAmp += used[operation] ? machines[operation] : -machines[operation];
                if (currentAmp > capacity) break;
                maxAmp = Math.max(currentAmp, maxAmp);
            }

            answer.append(String.format("Sequence %d\n", testCase));
            if (currentAmp > capacity) {
                answer.append("Fuse was blown.\n\n");
            } else {
                answer.append("Fuse was not blown.\n")
                        .append(String.format("Maximal power consumption was %d amperes.\n\n", maxAmp));
            }
            testCase++;
        }
        System.out.print(answer);
    }
}
