package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/4999
public class Prob4999 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String ah = reader.readLine();
        System.out.println(ah.length() >= reader.readLine().length() ? "go" : "no");
    }
}

