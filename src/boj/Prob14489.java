package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.acmicpc.net/problem/14489
public class Prob14489 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        long money = Arrays.stream(reader.readLine().split(" ")).mapToLong(Long::parseLong).sum();
        long price = Long.parseLong(reader.readLine());
        long left = money - price * 2;
        System.out.println(left >= 0 ? left : money);
    }
}
