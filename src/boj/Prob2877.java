package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/2877
public class Prob2877 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(reader.readLine());
        int totalCount = 2;
        int roundCount = 2;
        while (k > totalCount) {
            roundCount *= 2;
            totalCount += roundCount;
        }
        int base = k - (totalCount - roundCount);
        StringBuilder answer = new StringBuilder();
        while (roundCount > 1) {
            roundCount /= 2;
            if (base <= roundCount) {
                answer.append(4);
            }
            else {
                answer.append(7);
                base -= roundCount;
            }
        }
        System.out.println(answer);
    }
}

/*
1 2 -> 4 7
3 4 5 6 -> 44 47 74 77
7 8 9 10 11 12 13 14 -> 444 447 474 477 744 747 774 777
15 16 17 18 19 20 21 22 | 23 24 25 26 27 28 29 30  ->  4444 4447 4474 4477 4744 4747 4774 4777 7444 7447
10 ->
10 - 6 == 4
 9 - 6 == 3
 8 - 6 == 2
 7 - 6 == 1

22 ->
22 - 14 == 8

 8 +  6 -> 14
14 -  6 -> 8
 8 > 8 / 2 -> up
 8 -= 4 -> 4

 4 +  2 == 6


24 ->

// 한번만 직전까지의 총 숫자의 갯수를 현재 구하고자 하는 숫자에서 뺀다.
24 - 14 == 10

// 현재 자릿수로 만들수 있는 숫자의 갯수의 절반보다 크면 7, 작으면 4
10 >  16 / 2 -> up
// 크면 현재 숫자에서 절반에 해당하는 숫자를 감한다. 작으면 스킵
10 -= 8 -> 2
// 이를 반복해서 현재 자릿수가 한자라기 될때 1이냐 2이냐에 따라 4 또는 7을 만든다.

 2 <=  8 / 2 -> down
 2 -= 4 -> skip

 2 <= 4 / 2 -> down
 2 -= 2 -> skip

 1 || 2 -> 2 -> up

7447
 */