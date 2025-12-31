package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.acmicpc.net/problem/2902
public class Prob2902 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String longName = reader.readLine();
        StringBuilder answer = new StringBuilder();
        Arrays.stream(longName.split("-"))
                .map(name -> name.charAt(0))
                .forEach(answer::append);
        System.out.println(answer);
    }
}
