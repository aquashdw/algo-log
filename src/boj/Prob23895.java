package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

// https://www.acmicpc.net/problem/23895
public class Prob23895 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(reader.readLine());
        StringBuilder answer = new StringBuilder();
        AtomicInteger i =  new AtomicInteger(0);
        reader.lines().limit(tests * 2L)
                .reduce(null, (prev, now) -> {
                    if (prev == null)
                        return now;
                    int budget = Integer.parseInt(prev.split(" ")[1]);
                    int[] prices = Arrays.stream(now.split(" "))
                            .mapToInt(Integer::parseInt)
                            .sorted()
                            .toArray();
                    answer.append("Case #")
                            .append(i.incrementAndGet())
                            .append(": ")
                            .append(buyCount(budget, prices))
                            .append('\n');
                    return null;
                });
        System.out.print(answer);
    }

    private static int buyCount(int budget, int[] prices) {
        int count = 0;
        for (int price: prices) {
            if (price > budget) break;
            budget -= price;
            count++;
        }
        return count;
    }
}
