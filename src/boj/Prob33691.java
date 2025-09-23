package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

// https://www.acmicpc.net/problem/33691
public class Prob33691 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int useLog = Integer.parseInt(reader.readLine());
        Map<String, Integer> lastUsed = new HashMap<>();
        for (int i = 0; i < useLog; i++) {
            lastUsed.put(reader.readLine(), i);
        }
        int fixedCount = Integer.parseInt(reader.readLine());
        Set<String> fixed = reader.lines().limit(fixedCount).collect(Collectors.toSet());
        String[] dashboard = new String[lastUsed.size()];
        int i = 0;
        for (String container : fixed.stream()
                .sorted(Comparator.comparingInt(container -> -lastUsed.get(container)))
                .collect(Collectors.toList())) {
            dashboard[i] = container;
            i++;
        }
        for (String container : lastUsed.keySet().stream()
                .filter(container -> !fixed.contains(container))
                .sorted(Comparator.comparingInt(container -> -lastUsed.get(container)))
                .collect(Collectors.toList())) {
            dashboard[i] = container;
            i++;
        }
        System.out.println(String.join("\n", dashboard));
    }
}
