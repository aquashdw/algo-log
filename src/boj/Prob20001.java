package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


// https://www.acmicpc.net/problem/20001
public class Prob20001 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line = reader.readLine();
        int count = 0;
        while (!(line = reader.readLine()).equals("고무오리 디버깅 끝")) {
            if (line.equals("문제"))
                count++;
            else {
                if (count == 0) count += 2;
                else count--;
            }
        }
        if (count == 0)
            System.out.println("고무오리야 사랑해");
        else
            System.out.println("힝구");
    }
}
