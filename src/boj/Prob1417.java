package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Prob1417 {
    public int solution() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int candidates = Integer.parseInt(reader.readLine());
        int myVote = Integer.parseInt(reader.readLine());
        PriorityQueue<Integer> otherVotes
                = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < candidates - 1; i++)
            otherVotes.offer(Integer.parseInt(reader.readLine()));

        int answer = 0;
        if (!otherVotes.isEmpty())
            while (otherVotes.peek() >= myVote) {
                otherVotes.offer(otherVotes.poll() - 1);
                myVote++;
                answer++;
            }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        System.out.println(new Prob1417().solution());
    }
}
