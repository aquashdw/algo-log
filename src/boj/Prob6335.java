package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// https://www.acmicpc.net/problem/6335
public class Prob6335 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();
        int caseNum = 1;
        List<int[]> calendars = new ArrayList<>(20);
        String line;
        while (!(line = reader.readLine()).equals("0")) {
            answer.append("Case #").append(caseNum++).append(":\n");
            int n = Integer.parseInt(line);
            calendars.clear();
            reader.lines().limit(n).forEach(calLine -> calendars.add(Arrays.stream(calLine.split(" "))
                    .mapToInt(Integer::parseInt).toArray()));

            int baseCycle = calendars.get(0)[2] - calendars.get(0)[1];
            Set<Integer> candidates = new HashSet<>();
            int candidate = calendars.get(0)[0];
            while (candidate < 10000) {
                candidates.add(candidate);
                candidate += baseCycle;
            }

            for (int i = 1; i < calendars.size(); i++) {
                int[] calendar = calendars.get(i);
                int cycle = calendar[2] - calendar[1];
                Iterator<Integer> iterator = candidates.iterator();
                while (iterator.hasNext()) {
                    int year = iterator.next();
                    while (year >= calendar[2]) {
                        year -= cycle;
                    }
                    if (year != calendar[0]) iterator.remove();
                }
//                candidates = candidates.stream().filter(year -> {
//                    while (year > calendar[2]) {
//                        year -= cycle;
//                    }
//                    return year == calendar[0];
//                }).collect(Collectors.toSet());
                if (candidates.isEmpty()) break;
            }

            candidates.stream()
                    .mapToInt(Integer::intValue)
                    .min()
                    .ifPresentOrElse(
                            year -> answer.append(String.format("The actual year is %d.\n\n", year)),
                            () -> answer.append("Unknown bugs detected.\n\n")
                    );
        }
        System.out.println(answer.toString().trim());
    }
}
