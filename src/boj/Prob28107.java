package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


// https://www.acmicpc.net/problem/28107
public class Prob28107 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] baseInfo = reader.readLine().split(" ");
        int cCount = Integer.parseInt(baseInfo[0]);
        Map<Integer, Queue<Integer>> sushiWaiters = new HashMap<>();
        int sCount = Integer.parseInt(baseInfo[1]);

        for (int i = 0; i < cCount; i++) {
            baseInfo = reader.readLine().split(" ");
            int waitingCount = Integer.parseInt(baseInfo[0]);
            for (int j = 0; j < waitingCount; j++) {
                int sushi = Integer.parseInt(baseInfo[j + 1]);
                if (sushiWaiters.get(sushi) == null)
                    sushiWaiters.put(sushi, new LinkedList<>());
                sushiWaiters.get(sushi).add(i);
            }
        }

        int[] sushiOut = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int[] customerAte = new int[cCount];

        for (int sushi : sushiOut) {
            Queue<Integer> thisWaiter = sushiWaiters.get(sushi);
            if (thisWaiter == null || thisWaiter.isEmpty()) continue;
            int waiter = thisWaiter.poll();
            customerAte[waiter]++;
        }

        StringBuilder answerBuilder = new StringBuilder();
        for (int ate: customerAte) {
            answerBuilder.append(ate);
            answerBuilder.append(" ");
        }
        System.out.println(answerBuilder);
    }
}
