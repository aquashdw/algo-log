package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// https://www.acmicpc.net/problem/13593
public class Prob13593 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (Integer.parseInt(reader.readLine()) != 0) {
            int[] commands = Arrays.stream(reader.readLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();

            Map<Integer, Integer> history = new HashMap<>();
            int clicks = 0;
            for (int i = 0; i < commands.length; i++) {
                int addClicks = i;
                if (history.containsKey(commands[i])) {
                    addClicks -= history.get(commands[i]);
                }
                else {
                    addClicks += commands[i];
                }
                history.put(commands[i], i);
                clicks += addClicks;
            }
            System.out.println(clicks);
        }
    }
}
/*
1
1 3 1 3
0

1
1 3 1 4
0

 */