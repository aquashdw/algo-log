package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

// https://www.acmicpc.net/problem/18870
public class Prob18870 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        reader.readLine();
        int[] origin = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[] distinct = Arrays.stream(origin)
                .sorted()
                .distinct()
                .toArray();

        Map<Integer, Integer> dict = new HashMap<>();
        IntStream.range(0, distinct.length)
                .forEach(i -> dict.put(distinct[i], i));

        StringBuilder answer = new StringBuilder();
        Arrays.stream(origin)
                .forEach(i -> answer.append(dict.get(i)).append(" "));
        System.out.println(answer);
    }
}
