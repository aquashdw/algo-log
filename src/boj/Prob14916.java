package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Prob14916 {
    public int solution() throws IOException {
        int change = Integer.parseInt(
                new BufferedReader(new InputStreamReader(System.in)).readLine()
        );

        // 5로 나눈 나머지가 짝수 -> 5를 최대로, 남은건 2
        // 5로 나눈 나머지가 홀수 -> 5 최대 -1, 남은건 2, 단 입력이 5보다 커야 한다.
        if (change < 5 && change % 2 != 0) return -1;
        else if ((change % 5) % 2 == 0) {
            return change / 5 + ((change % 5) / 2);
        } else {
            return (change / 5 - 1) + ((change % 5) + 5) / 2;
        }
    }

    public static void main(String[] args) throws IOException {
        System.out.println(new Prob14916().solution());
    }
}

