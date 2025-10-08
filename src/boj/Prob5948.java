package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

// https://www.acmicpc.net/problem/5948
public class Prob5948 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(reader.readLine());
        Set<Integer> randoms = new HashSet<>();
        num = (num / 10) % 100;
        num *= num;
        while (!randoms.contains(num)) {
            randoms.add(num);
            num = (num / 10) % 100;
            num *= num;
        }
        System.out.println(randoms.size() + 1);
    }
}
