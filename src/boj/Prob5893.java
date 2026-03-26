package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/5893
public class Prob5893 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String original = reader.readLine();
        if (original.length() < 5) {
            StringBuilder answer = new StringBuilder(original);
            answer.append("0".repeat(4 - original.length()));
            answer.append(original);
            System.out.println(answer);
            return;
        }
        String reversed = new StringBuilder(original).reverse().toString();
        StringBuilder answer = new StringBuilder();
        answer.append(reversed, 0, 4);
        int carry = 0;
        for (int i = 0; i < reversed.length() - 4; i++) {
            int origin = reversed.charAt(i + 4) - '0';
            int shifted = reversed.charAt(i) - '0';
            int sum = origin + shifted + carry;
            if (sum >= 2) {
                carry = 1;
                sum -= 2;
            } else carry = 0;
            answer.append(sum);
        }
        for (int i = reversed.length() - 4; i < reversed.length(); i++) {
            int shifted = reversed.charAt(i) - '0';
            int sum = shifted + carry;
            if (sum >= 2) {
                carry = 1;
                sum -= 2;
            } else carry = 0;
            answer.append(sum);
        }
        if (carry == 1) answer.append(1);
        System.out.println(answer.reverse());
    }
}
