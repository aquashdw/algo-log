package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicLong;

// https://www.acmicpc.net/problem/28324
public class Prob28324 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        reader.readLine();

        AtomicLong currentMax = new AtomicLong(0);
        System.out.println(Arrays.stream(reader.readLine().split(" "))
                .sorted((o1, o2) -> -1)
                .mapToLong(Long::parseLong)
                .reduce(0, (total, nowMax) -> {
                    long actualMax = currentMax.incrementAndGet();
                    if (nowMax >= actualMax) {
                        total += actualMax;
                    }
                    else {
                        currentMax.set(nowMax);
                        total += nowMax;
                    }
                    return total;
                }));
    }
}
