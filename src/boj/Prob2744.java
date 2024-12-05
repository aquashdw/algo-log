package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/2744
public class Prob2744 {
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input  = reader.readLine();
        StringBuilder answer = new StringBuilder();
        input.chars().forEach(i -> answer.append((char) (Character.isLowerCase(i) ? Character.toUpperCase(i) : Character.toLowerCase(i))));
        System.out.println(answer);
    }
}
