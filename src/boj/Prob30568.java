package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

// https://www.acmicpc.net/problem/30568
public class Prob30568 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] nm = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        int m = nm[1];
        List<Integer> depDirection = new ArrayList<>(m);
        int pos = 0;
        int neg = 0;
        for (int i = 0; i < m; i++) {
            String line = reader.readLine();
            int[] dep = Arrays.stream(line.split(" ")).mapToInt(Integer::parseInt).toArray();
            if (dep[0] < dep[1]) {
                depDirection.add(1);
                pos++;
            } else {
                depDirection.add(-1);
                neg++;
            }
        }

        int sign = pos - neg;
        String result = IntStream.range(0, m)
                .filter(i -> sign > 0 ? depDirection.get(i) > 0 : depDirection.get(i) < 0)
                .mapToObj(i -> String.valueOf(i + 1))
                .collect(Collectors.joining(" "));
        System.out.printf("YES%n%d%n%s%n", Math.max(pos, neg), result);
    }
}
