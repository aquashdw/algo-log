package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/14928
public class Prob14928 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String bigNum = reader.readLine();
        long answer = 0;
        for (int i = 0; i < bigNum.length(); i++) {
            answer = (answer * 10 + bigNum.charAt(i) - '0') % 20000303;
        }
        System.out.println(answer);
    }
}
