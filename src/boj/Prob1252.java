package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/1252
public class Prob1252 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        boolean carry = false;
        String[] ab = reader.readLine().split(" ");
        String a = ab[0];
        String b = ab[1];
        int aIdx = a.length() - 1;
        int bIdx = b.length() - 1;
        StringBuilder binary = new StringBuilder();
        while (aIdx >= 0 && bIdx >= 0) {
            int ones = carry ? 1 : 0;
            ones += a.charAt(aIdx) == '1' ? 1 : 0;
            ones += b.charAt(bIdx) == '1' ? 1 : 0;
            carry = ones >= 2;
            binary.append(ones % 2);
            aIdx--;
            bIdx--;
        }

        while (aIdx >= 0) {
            int ones = carry ? 1 : 0;
            ones += a.charAt(aIdx) == '1' ? 1 : 0;
            carry = ones >= 2;
            binary.append(ones % 2);
            aIdx--;
        }

        while (bIdx >= 0) {
            int ones = carry ? 1 : 0;
            ones += b.charAt(bIdx) == '1' ? 1 : 0;
            carry = ones >= 2;
            binary.append(ones % 2);
            bIdx--;
        }

        if (carry) binary.append('1');


        binary.reverse();
        int firstOne = 0;
        while (firstOne < binary.length() && binary.charAt(firstOne) == '0') {
            firstOne++;
        }
        if (firstOne == binary.length()) {
            System.out.println(0);
            return;
        }

        System.out.println(binary.substring(firstOne));
    }
}
