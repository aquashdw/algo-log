package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/10768
public class Prob10768 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int month = Integer.parseInt(reader.readLine());
        int day = Integer.parseInt(reader.readLine());
        if (month != 2) {
            if (month < 2) {
                System.out.println("Before");
            }
            else {
                System.out.println("After");
            }
        }
        else if (day != 18) {
            if (day < 18) {
                System.out.println("Before");
            }
            else {
                System.out.println("After");
            }
        }
        else {
            System.out.println("Special");
        }
    }
}
