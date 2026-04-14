package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.acmicpc.net/problem/7601
public class Prob7601 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();
        int testCase = 1;
        String line;
        while (!(line = reader.readLine()).equals("0 0")) {
            answer.append(String.format("Scenario %d", testCase)).append('\n');
            int[] nd = Arrays.stream(line.split(" "))
                    .mapToInt(Integer::parseInt).toArray();
            int total = nd[0];
            int becRemoved = Integer.parseInt(reader.readLine());
            int casRemoved = Integer.parseInt(reader.readLine());

            for (int i = 1; i < nd[1] + 1; i++) {
                int[] choices = Arrays.stream(reader.readLine().split(" "))
                        .mapToInt(Integer::parseInt).toArray();
                int becChose = choices[0];
                int casChose = choices[1];
                if (becChose >= becRemoved && becRemoved != 0) becChose++;
                if (casChose >= casRemoved && casRemoved != 0) casChose++;
                casChose = total - casChose + 1;
                answer.append(String.format("Day %d ", i)).append(becChose == casChose ? "ALERT" : "OK").append('\n');
            }
            testCase++;
        }
        System.out.print(answer);
    }
}
/*
1 2 3 4 5
2 3 4 5
1 2 3 4 5
1 2 3 4

5 3
1
1
3 1
1 3
2 2
0 0

1 2 3 4 5
1 2 4 5
1 2 3 4 5
1 2 3 4

5 3
3
1
1 4
2 3
3 1
0 0
 */