package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Prob7662 {
    public void solution() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(reader.readLine());

        StringBuilder outBuilder = new StringBuilder();
        for (int i = 0; i < testCases; i++) {
            int commands = Integer.parseInt(reader.readLine());
            PriorityQueue<Integer> maxQueue = new PriorityQueue<>(Collections.reverseOrder());
            PriorityQueue<Integer> minQueue = new PriorityQueue<>();
            Map<Integer, Integer> tracker = new HashMap<>();
            int size = 0;
            for (int j = 0; j < commands; j++) {
                StringTokenizer commandToken = new StringTokenizer(reader.readLine());
                String command = commandToken.nextToken();
                int number = Integer.parseInt(commandToken.nextToken());
                if (command.equals("I")) {
                    minQueue.offer(number);
                    maxQueue.offer(number);
                    tracker.put(number, tracker.getOrDefault(number, 0) + 1);
                    size++;
                } else if (number == 1 && size > 0){
                    while (!tracker.containsKey(maxQueue.peek())) {
                        maxQueue.poll();
                    }
                    int polled = maxQueue.poll();
                    tracker.put(polled, tracker.get(polled) - 1);
                    if (tracker.get(polled) == 0) tracker.remove(polled);
                    size--;
                } else if (number == -1 && size > 0) {
                    while (!tracker.containsKey(minQueue.peek())) {
                        minQueue.poll();
                    }
                    int polled = minQueue.poll();
                    tracker.put(polled, tracker.get(polled) - 1);
                    if (tracker.get(polled) == 0) tracker.remove(polled);
                    size--;
                }
            }

            if (size == 0) {
                outBuilder.append("EMPTY\n");
            } else {
                while (!tracker.containsKey(maxQueue.peek())) {
                    maxQueue.poll();
                }
                while (!tracker.containsKey(minQueue.peek())) {
                    minQueue.poll();
                }
                outBuilder.append(maxQueue.poll())
                        .append(" ")
                        .append(minQueue.poll())
                        .append("\n");
            }
        }

        System.out.print(outBuilder);
    }

    public static void main(String[] args) throws IOException {
        new Prob7662().solution();
    }
}

/*
1
13
I 1
I 1
I 1
I 1
D 1
D 1
I 0
I 1
I 2
D -1
D -1
D -1
D -1
 */