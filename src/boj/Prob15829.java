package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


// https://www.acmicpc.net/problem/15829
public class Prob15829 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int length = Integer.parseInt(reader.readLine());
        String word = reader.readLine();
        long ratio = 31;
        long r = 1;
        long m = 1234567891;
        long hash = 0;
        for (int i = 0; i < length; i++) {
            int a = word.charAt(i) - 'a' + 1;
            long ar = a * r;
            r *= ratio;
            r %= m;
            hash += ar % m;
        }
        hash %= m;
        System.out.println(hash);
    }
}
