package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

// https://www.acmicpc.net/problem/1247
public class Prob1247 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            int nums = Integer.parseInt(reader.readLine());
            BigInteger sum = new BigInteger("0");
            for (int j = 0; j < nums; j++) {
                sum = sum.add(new BigInteger(reader.readLine()));
            }
            switch (sum.signum()) {
                case -1 -> answer.append('-').append('\n');
                case 1 -> answer.append('+').append('\n');
                case 0 -> answer.append('0').append('\n');
            }
        }

        System.out.print(answer);
    }

}
