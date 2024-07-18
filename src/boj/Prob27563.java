package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/27563
public class Prob27563 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(reader.readLine());
        StringBuilder answer = new StringBuilder();
        reader.lines().limit(tests).forEach(line -> answer.append(ops(line)).append('\n'));
        System.out.print(answer);
    }

    private static int ops(String canMoo) {
        if (canMoo.length() < 3) return -1;
        if (!canMoo.substring(1, canMoo.length() - 1).contains("O"))
            return -1;
        if (canMoo.contains("MOO"))
            return canMoo.length() - 3;
        if (canMoo.contains("MOM") || canMoo.contains("OOO"))
            return canMoo.length() - 2;
        else return canMoo.length() - 1;
    }
}
