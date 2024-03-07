package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Prob15903 {
    public long solution() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] info = reader.readLine().split(" ");
        int cardCount = Integer.parseInt(info[0]);
        int actions = Integer.parseInt(info[1]);

        String[] cards = reader.readLine().split(" ");
        PriorityQueue<Long> smallestCards = new PriorityQueue<>();
        for (int i = 0; i < cardCount; i++) {
            smallestCards.offer(Long.parseLong(cards[i]));
        }

        for (int i = 0; i < actions; i++) {
            long first = smallestCards.poll();
            long second = smallestCards.poll();
            smallestCards.offer(first + second);
            smallestCards.offer(first + second);
        }
        long answer = 0;
        while (!smallestCards.isEmpty()) {
            answer += smallestCards.poll();
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        System.out.println(new Prob15903().solution());
    }
}
