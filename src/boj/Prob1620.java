package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

// https://www.acmicpc.net/problem/1620
public class Prob1620 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] nm = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        List<String> names = reader.lines().limit(nm[0])
                .collect(Collectors.toList());
        Map<String, Integer> dict = new HashMap<>();
        for (int i = 0; i < names.size(); i++) {
            dict.put(names.get(i), i + 1);
        }
        StringBuilder answer = new StringBuilder();
        reader.lines().limit(nm[1])
                .forEach(line -> {
                    if (line.chars().allMatch(Character::isDigit))
                        answer.append(names.get(Integer.parseInt(line) - 1)).append('\n');
                    else
                        answer.append(dict.get(line)).append('\n');
                });
        System.out.print(answer);
    }
}
