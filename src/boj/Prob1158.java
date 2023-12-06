package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


// https://www.acmicpc.net/problem/1158
public class Prob1158 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader
                = new BufferedReader(new InputStreamReader(System.in));
        String[] info = reader.readLine().split(" ");
        int N = Integer.parseInt(info[0]);
        int M = Integer.parseInt(info[1]);

        List<Integer> result = new ArrayList<>(N);
        Queue<Integer> people = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            people.offer(i + 1);
        }

        int round = 0;
        while (!people.isEmpty()) {
            int person = people.poll();
            if (round == M - 1) {
                result.add(person);
                round = 0;
            }
            else {
                people.offer(person);
                round++;
            }
        }

        StringBuilder answerBuilder = new StringBuilder();
        answerBuilder.append("<");
        String resultString = result.toString();
        answerBuilder.append(resultString, 1, resultString.length() - 1);
        answerBuilder.append(">");
        System.out.println(answerBuilder);
    }
}
