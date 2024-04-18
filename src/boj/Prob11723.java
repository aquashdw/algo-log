package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

// https://www.acmicpc.net/problem/11723
public class Prob11723 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());

        Set<Integer> set = new HashSet<>();
        Set<Integer> allSet = new HashSet<>();
        for (int i = 0; i < 20; i++) {
            allSet.add(i + 1);
        }
        StringBuilder answer = new StringBuilder();
        reader.lines().limit(n).forEach(line -> {
            String[] commands = line.split(" ");
            String command = commands[0];
            Integer value = null;
            if (commands.length == 2) {
                value = Integer.parseInt(commands[1]);
            }

            switch (command) {
                case "add" -> set.add(value);
                case "remove" -> set.remove(value);
                case "check" -> answer
                        .append(set.contains(value) ? 1 : 0)
                        .append('\n');
                case "toggle" -> {
                    if (set.contains(value)) set.remove(value);
                    else set.add(value);
                }
                case "all" -> set.addAll(allSet);
                case "empty" -> set.clear();
            }

        });
        System.out.print(answer);
    }
}
