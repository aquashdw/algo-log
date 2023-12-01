package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Prob15903 {
    public long solution() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer infoToken = new StringTokenizer(reader.readLine());
        int cardCount = Integer.parseInt(infoToken.nextToken());
        int actions = Integer.parseInt(infoToken.nextToken());

        StringTokenizer cardToken = new StringTokenizer(reader.readLine());
        PriorityQueue<Long> smallestCards = new PriorityQueue<>();
        for (int i = 0; i < cardCount; i++) {
            smallestCards.offer(Long.parseLong(cardToken.nextToken()));
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
