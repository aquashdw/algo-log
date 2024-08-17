package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.IntStream;

// https://www.acmicpc.net/problem/6039
public class Prob6039 {
    private static int force;
    private static int mass;
    private static int partCount;
    private static int[][] parts;

    private static double maxAcc;
    private static int[] maxComb;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        force = info[0];
        mass = info[1];
        partCount = info[2];
        parts = new int[partCount][];
        for (int i = 0; i < partCount; i++) {
            parts[i] = Arrays.stream(reader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        maxAcc = (double) force / mass;
        maxComb = new int[]{};

        comb();

        if (maxComb.length == 0 ) {
            System.out.println("NONE");
            return;
        }
        StringBuilder answer = new StringBuilder();
        Arrays.stream(maxComb).forEach(comb -> answer.append(comb + 1).append('\n'));
        System.out.print(answer);
    }

    private static void comb() {
        boolean[] used = new boolean[partCount];
        combRecursive(0, used);
    }

    private static void combRecursive(int now, boolean[] used) {
        if (now == partCount) {
            int newForce = force;
            int newMass = mass;
            for (int i = 0; i < partCount; i++) {
                if (used[i]) {
                    newForce += parts[i][0];
                    newMass += parts[i][1];
                }
            }
            double newAcc = (double) newForce / newMass;
//            System.out.println(Arrays.toString(used));
//            System.out.println(newAcc);
            if (newAcc > maxAcc) {
                maxAcc = newAcc;
                maxComb = IntStream.range(0, partCount).filter(i -> used[i]).toArray();
            }

            return;
        }
        used[now] = true;
        combRecursive(now + 1, used);
        used[now] = false;
        combRecursive(now + 1, used);
    }
}
