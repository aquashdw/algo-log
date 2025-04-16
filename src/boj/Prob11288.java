package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.acmicpc.net/problem/11288
public class Prob11288 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        long[] input = Arrays.stream(reader.readLine().split(" "))
                .mapToLong(Long::parseLong).toArray();
        long a = input[1];
        long b = input[2];
        long mod = 1;
        for (int i = 0; i < b; i++) {
            mod *= a;
            mod %= 26;
        }
        String encrypted = reader.readLine();
        StringBuilder decrypted = new StringBuilder();
        int key = (int) mod;
        encrypted.chars().forEach(c -> {
            if (c == ' ') {
                decrypted.append((char) c);
                return;
            }
            c -= key;
            if (c < 'A') c += 26;
            decrypted.append((char) c);
        });
        System.out.println(decrypted);
    }
}
