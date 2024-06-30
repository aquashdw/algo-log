package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// https://www.acmicpc.net/problem/4881
public class Prob4881 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();
        reader.lines().map(line -> Arrays.stream(line.split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray())
                .forEach(test -> {
                    if (test[0] == 0 && test[1] == 0) return;
                    int caseA = compare(test[0], test[1]);
                    int caseB = compare(test[1], test[0]);
                    answer.append("%d %d %d%n".formatted(
                            test[0],
                            test[1],
                            Math.min(caseA, caseB)
                    ));
                });
        System.out.println(answer);
    }

    private static int compare(int a, int b) {
        if (a == b) return 2;
        Set<Integer> visitedA = new HashSet<>();
        List<Integer> recordA = new ArrayList<>();
        int num = a;
        while (!visitedA.contains(num)) {
            recordA.add(num);
            visitedA.add(num);
            int next = 0;
            while (num > 0) {
                next += (num % 10) * (num % 10);
                num /= 10;
            }
            num = next;
        }
        num = b;
        Set<Integer> visitedB = new HashSet<>();
        List<Integer> recordB = new ArrayList<>();
        while (!visitedB.contains(num)) {
            recordB.add(num);
            visitedB.add(num);
            if (visitedA.contains(num)) break;
            int next = 0;
            while (num > 0) {
                next += (num % 10) * (num % 10);
                num /= 10;
            }
            num = next;
        }
        if (!visitedA.contains(num)) return 0;
        return recordA.indexOf(num) + 1 + recordB.size();
    }
}
