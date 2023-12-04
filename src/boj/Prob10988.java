package boj;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/10988
public class Prob10988 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String target = reader.readLine();

        for (int i = 0; i < target.length() / 2; i++) {
            if (target.charAt(i) != target.charAt(target.length() - 1 - i)) {
                System.out.println(0);
                return;
            }
        }
        System.out.println(1);
    }
}
