package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/2083
public class Prob2083 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();
        for (String line = reader.readLine(); !line.equals("# 0 0"); line = reader.readLine()) {
            String[] info = line.split(" ");
            if (Integer.parseInt(info[1]) > 17 || Integer.parseInt(info[2]) >= 80)
                answer.append(String.format("%s %s%n", info[0], "Senior"));
            else answer.append(String.format("%s %s%n", info[0], "Junior"));
        }
        System.out.print(answer);
    }
}
