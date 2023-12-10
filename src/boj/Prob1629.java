package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


// https://www.acmicpc.net/problem/1629
public class Prob1629 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        long[] numbers = Arrays.stream(reader.readLine().split(" "))
                .mapToLong(Long::parseLong)
                .toArray();

        System.out.println(count(numbers[0], numbers[1], numbers[2]));
    }

    public static long count(long base, long expo, long modulo) {
        if (expo == 0) return 1;
        else if (expo == 1) return base % modulo;
        else if (expo % 2 == 0) {
            long half = count(base, expo / 2, modulo);
            return (half * half) % modulo;
        }
        else return (base * (count(base, expo - 1, modulo))) % modulo;
    }
}
