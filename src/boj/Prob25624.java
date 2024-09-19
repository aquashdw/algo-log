package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

// https://www.acmicpc.net/problem/25624
public class Prob25624 {
    private static List<List<String>> characteristics;
    private static Set<String> snuptis;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int kinds = info[0];
        int combs = info[1];

        int[] letterKind = new int[27];
        Arrays.fill(letterKind, -1);
        letterKind[26] = 0;
        snuptis = new HashSet<>();
        reader.lines().limit(combs)
                .forEach(line -> {
                    if (letterKind[26] == -1) return;
                    for (int i = 0; i < kinds; i++) {
                        if (letterKind[line.charAt(i) - 'A'] != -1 && letterKind[line.charAt(i) - 'A'] != i) {
                            letterKind[26] = -1;
                            break;
                        }
                        letterKind[line.charAt(i) - 'A'] = i;
                    }
                    if (snuptis.contains(line)) {
                        letterKind[26] = -1;
                        return;
                    }
                    snuptis.add(line);
                });
        if (letterKind[26] == -1) {
            System.out.println("NO");
            return;
        }
        characteristics = new ArrayList<>(kinds);
        for (int i = 0; i < kinds; i++) {
            characteristics.add(new ArrayList<>());
        }
        for (int i = 0; i < 26; i++) {
            if (letterKind[i] == -1) continue;
            characteristics.get(letterKind[i]).add(String.valueOf((char)('A' + i)));
        }
        if (!test(kinds, 0, new int[kinds])) {
            System.out.println("NO");
            return;
        }

        StringBuilder answer = new StringBuilder();
        answer.append("YES\n");
        for (int i = 0; i < kinds; i++) {
            answer.append(characteristics.get(i).stream().sorted().collect(Collectors.joining())).append('\n');
        }

        System.out.print(answer);
    }

    private static boolean test(int kinds, int now, int[] selected) {
        if (now == kinds) {
            String snupti = IntStream.range(0, kinds)
                    .mapToObj(i -> characteristics.get(i).get(selected[i]))
                    .collect(Collectors.joining());
            return snuptis.contains(snupti);
        }
        for (int i = 0; i < characteristics.get(now).size(); i++) {
            selected[now] = i;
            if (!test(kinds, now + 1, selected)) return false;
        }
        return true;
    }
}
