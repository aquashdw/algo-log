package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

// https://www.acmicpc.net/problem/31661
public class Prob31661 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int base = Integer.parseInt(reader.readLine());
        List<String> digits = Arrays.stream(reader.readLine().split(" "))
                .collect(Collectors.toList());

        String number = reader.readLine();
        int result = 0;
        int nextIdx = 0;
        while (nextIdx < number.length()) {
            result *= base;
            for (int i = 0; i < digits.size(); i++) {
                String digit = digits.get(i);
                boolean success = true;
                for (int j = 0; j < digit.length(); j++) {
                    if (digit.charAt(j) != number.charAt(j + nextIdx)) {
                        success = false;
                        break;
                    }
                }
                if (success) {
                    result += i;
                    nextIdx += digit.length();
                    break;
                }
            }
        }
        System.out.println(result);
    }
}
