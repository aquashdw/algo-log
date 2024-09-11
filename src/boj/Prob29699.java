package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/29699
public class Prob29699 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int i = Integer.parseInt(reader.readLine()) - 1;
        String sentence = "WelcomeToSMUPC";
        i %= sentence.length();
        System.out.println(sentence.charAt(i));
    }
}
