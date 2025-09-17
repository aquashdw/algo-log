package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

// https://www.acmicpc.net/problem/3340
public class Prob3340 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int columns = Integer.parseInt(reader.readLine().split(" ")[0]);
        int[] sequence = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        int distinct = (int) Arrays.stream(sequence).distinct().count();
        int[] shortSeq = new int[distinct];
        Set<Integer> found = new HashSet<>();
        int idx = distinct;
        for (int i = sequence.length - 1; i >= 0; i--) {
            if (!(idx > 0)) break;
            if (found.contains(sequence[i])) continue;
            found.add(sequence[i]);
            idx--;
            shortSeq[idx] = sequence[i];
        }
        System.out.println(distinct);
        System.out.println(Arrays.stream(shortSeq).mapToObj(String::valueOf)
                .collect(Collectors.joining(" ")));
    }
}
