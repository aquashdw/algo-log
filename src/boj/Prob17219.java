package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// https://www.acmicpc.net/problem/17219
public class Prob17219 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] nm = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        Map<String, String> passMap = new HashMap<>();
        reader.lines()
                .limit(nm[0])
                .map(line -> line.split(" "))
                .forEach(passEntry -> passMap.put(passEntry[0], passEntry[1]));

        StringBuilder answer = new StringBuilder();
        reader.lines()
                .limit(nm[1])
                .forEach(site -> answer.append(passMap.get(site)).append('\n'));
        System.out.print(answer);
    }
}

