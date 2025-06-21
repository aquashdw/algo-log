package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.acmicpc.net/problem/5073
public class Prob5073 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();
        String line;
        while (!(line = reader.readLine()).equals("0 0 0")) {
            int[] lens = Arrays.stream(line.split(" "))
                    .mapToInt(Integer::parseInt)
                    .sorted()
                    .toArray();

            if (lens[0] + lens[1] <= lens[2]) {
                answer.append("Invalid\n");
                continue;
            }

            if (lens[0] == lens[1] && lens[1] == lens[2]) {
                answer.append("Equilateral\n");
                continue;
            }

            if (lens[0] == lens[1] || lens[1] == lens[2]) {
                answer.append("Isosceles\n");
                continue;
            }

            answer.append("Scalene\n");
        }

        System.out.print(answer);
    }
}
