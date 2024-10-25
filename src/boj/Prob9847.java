package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

// https://www.acmicpc.net/problem/9847
public class Prob9847 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] abcd = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        int[] as = reader.lines().limit(abcd[0]).mapToInt(Integer::parseInt).toArray();
        int[] bs = reader.lines().limit(abcd[1]).mapToInt(Integer::parseInt).toArray();
        int[] cs = reader.lines().limit(abcd[2]).mapToInt(Integer::parseInt).toArray();
        int[] ds = reader.lines().limit(abcd[3]).mapToInt(Integer::parseInt).toArray();

        int i = 0;
        int[][] abSums = new int[as.length * bs.length][3];
        for (int a : as) {
            for (int b : bs) {
                abSums[i][0] = a + b;
                abSums[i][1] = a;
                abSums[i][2] = b;
                i++;
            }
        }
        Arrays.sort(abSums, Comparator.comparingInt(o -> o[0]));

        i = 0;
        int[][] cdSums = new int[cs.length * ds.length][3];
        for (int c : cs) {
            for (int d : ds) {
                cdSums[i][0] = -(c + d);
                cdSums[i][1] = c;
                cdSums[i][2] = d;
                i++;
            }
        }
        Arrays.sort(cdSums, Comparator.comparingInt(o -> o[0]));

        int abIdx = 0;
        int cdIdx = 0;
        while (abIdx < abSums.length && cdIdx < cdSums.length) {
            int abSum = abSums[abIdx][0];
            int cdSum = cdSums[cdIdx][0];
            if (abSum == cdSum) {
                System.out.printf("%d %d %d %d%n", abSums[abIdx][1], abSums[abIdx][2], cdSums[cdIdx][1], cdSums[cdIdx][2]);
                return;
            }
            if (abSum < cdSum) abIdx++;
            else cdIdx++;
        }
    }
}
