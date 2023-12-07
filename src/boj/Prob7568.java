package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


// https://www.acmicpc.net/problem/7568
public class Prob7568 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        List<int[]> people = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            String[] personInfo = reader.readLine().split(" ");
            people.add(new int[]{
                    Integer.parseInt(personInfo[0]),
                    Integer.parseInt(personInfo[1])
            });
        }
        int[] over = new int[n];
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                int[] personA = people.get(i);
                int[] personB = people.get(j);
                if (personA[0] > personB[0] && personA[1] > personB[1])
                    over[j]++;
                else if (personA[0] < personB[0] && personA[1] < personB[1])
                    over[i]++;
            }
        }

        StringBuilder answerBuilder = new StringBuilder();
        for (int i = 0; i < n; i++) {
            answerBuilder.append(over[i] + 1);
            answerBuilder.append(" ");
        }
        System.out.println(answerBuilder);
    }
}
