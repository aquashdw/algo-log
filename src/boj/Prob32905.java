package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.acmicpc.net/problem/32905
public class Prob32905 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] nm = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        boolean success = reader.lines().limit(nm[0]).noneMatch(line -> Arrays.stream(line.split(" "))
                .filter(ch -> ch.charAt(0) == 'A')
                .count() != 1);
        System.out.println(success ? "Yes" : "No");
    }

}
