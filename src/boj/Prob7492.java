package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

// https://www.acmicpc.net/problem/7429
public class Prob7492 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] il = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        int target = il[0];
        int comparisons = il[1];
        boolean[] valid = new boolean[10001];
        for (int i = 1; i < 10001; i++) {
            if (i <= target) continue;
            valid[i] = binSearch(i, target, comparisons);
        }

        List<int[]> intervals = new LinkedList<>();

        int idx = 1;
        while (idx < 10001) {
            int start = idx;
            while (idx < 10001 && valid[idx]) {
                idx++;
            }
            int end = idx;
            if (start != end) intervals.add(new int[]{start, end - 1});
            idx++;
        }

        System.out.println(intervals.size());
        if (!intervals.isEmpty()) System.out.println(intervals.stream()
                .map(interval -> String.format("%d %d", interval[0], interval[1]))
                .collect(Collectors.joining("\n")));
    }

    private static boolean binSearch(int n, int target, int limit) {
        int start = 0;
        int end = n - 1;
        int compares = 0;
        boolean found = false;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            compares++;
            if (compares > limit) return false;
            if (mid == target) {
                found = true;
                break;
            } else if (mid > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return found && compares == limit;
    }
}
/*
0 11 -> 5
6 11 -> 8
9 11 -> 10

0 16 -> 8
9 16 -> 12
9 11 -> 10

0 17 -> 8
9 17 -> 13
9 12 -> 10

0 28 -> 14
0 13 -> 6
7 13 -> 10

0 29 -> 14
0 13 -> 6
7 13 -> 10

0 86 -> 43
0 42 -> 21
0 20 -> 10

0 93 -> 46
0 45 -> 22
0 21 -> 10

 */


