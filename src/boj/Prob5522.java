package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/5522
public class Prob5522 {
    public static void main(String[] args) throws IOException {
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(new BufferedReader(new InputStreamReader(System.in)).lines().limit(5).mapToInt(Integer::parseInt).sum());
    }
}
