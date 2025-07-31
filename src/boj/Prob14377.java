package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

// https://www.acmicpc.net/problem/14377
public class Prob14377 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(reader.readLine());
        for (int test = 0; test < tests; test++) {
            long n = Integer.parseInt(reader.readLine());
            Set<Integer> odds = new HashSet<>();
            reader.lines().limit(2 * n - 1)
                    .forEach(line -> Arrays.stream(line.split(" "))
                            .mapToInt(Integer::parseInt)
                            .forEach(i -> {
                                if (odds.contains(i)) odds.remove(i);
                                else odds.add(i);
                            }));

            System.out.printf("Case #%d: %s%n", test + 1, odds.stream()
                    .sorted()
                    .map(String::valueOf)
                    .collect(Collectors.joining(" ")));
        }
    }
}

/*
1 2 3
2 3 5
3 5 6
2 3 4
1 2 3


1 -> 2
2 -> 4
3 -> 5
4 -> 1
5 -> 2
6 -> 1
1 2 3
1 2 3
2 3 4
2 3 5
3 5 6

1 2 3
2 3 5
3 4 6

1 2 3 4
2 3 4 5
3 4 5 6
4 5 6 7

1 2 3 4
1 2 3 4
2 3 4 5
2 3 4 5
3 4 5 6
3 4 5 6
4 5 6 7
4 5 6 7

1 -> 2
2 -> 4
3 -> 6
4 -> 8
5 -> 6
6 -> 4
7 -> 2
*/
