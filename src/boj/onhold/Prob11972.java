package boj.onhold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.IntStream;

// https://www.acmicpc.net/problem/11972
public class Prob11972 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int n = info[0];
        int m = info[1];
        int d = info[2];
        int s = info[3];
        Map<Integer, List<int[]>> drinkInfos = new HashMap<>();
        Map<Integer, Integer> sickAt = new HashMap<>();
        reader.lines().limit(d)
                .map(line -> Arrays.stream(line.split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray())
                .forEach(drink -> {
                    int person = drink[0];
                    int[] milkInfo = {drink[1], drink[2]};
                    drinkInfos.putIfAbsent(person, new ArrayList<>());
                    drinkInfos.get(person).add(milkInfo);
                });
        drinkInfos.forEach((ignored, drinkInfo) -> drinkInfo.sort(Comparator.comparingInt(i -> i[1])));
        reader.lines().limit(s)
                .map(line -> Arrays.stream(line.split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray())
                .forEach(sick -> sickAt.put(sick[0], sick[1]));

        Set<Integer> mayBeBad = new HashSet<>();
        IntStream.range(1, m + 1)
                .forEach(mayBeBad::add);

        sickAt.forEach((person, time) -> {
            List<int[]> drinkInfo = drinkInfos.get(person);
            Set<Integer> canBeBad = new HashSet<>();
            for (int[] drink : drinkInfo) {
                if (drink[1] > time) break;
                canBeBad.add(drink[0]);
            }
            mayBeBad.retainAll(canBeBad);
        });

        mayBeBad.stream().mapToLong(badMilk -> drinkInfos.values().stream()
                        .filter(drinkInfo -> drinkInfo.stream()
                                .anyMatch(drink -> drink[0] == badMilk)
                        ).count())
                .max()
                .ifPresent(System.out::println);
    }
}
