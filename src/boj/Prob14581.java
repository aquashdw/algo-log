package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/14581
public class Prob14581 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String username = reader.readLine();
        System.out.printf("""
                :fan::fan::fan:
                :fan::%s::fan:
                :fan::fan::fan:
                """, username);
    }
}
