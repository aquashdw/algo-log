package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/28295
public class Prob28295 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println((char) switch (reader.lines().limit(10)
                .mapToInt(Integer::parseInt)
                .map(i -> switch (i) {
                    case 1 -> 1;
                    case 2 -> 2;
                    case 3 -> -1;
                    default -> 0;
                })
                .reduce(0, (now, dir) -> {
                    int next = now + dir;
                    if (next >= 4) next -= 4;
                    if (next < 0) next += 4;
                    return next;
                })) {
            case 0 -> 'N';
            case 1 -> 'E';
            case 2 -> 'S';
            case 3 -> 'W';
            default -> 0;
        });
    }
}
