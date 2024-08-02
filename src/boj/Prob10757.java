package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;

// https://www.acmicpc.net/problem/10757
public class Prob10757 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(Arrays.stream(reader.readLine().split(" "))
                .map(BigInteger::new)
                .reduce(BigInteger.ZERO, BigInteger::add));
    }
}


/*
2 3 3 2
1 2 3
3 2 1
4 5
6 7
8 9
2 3 2 3
1 2 3
3 2 1
4 5 6
7 8 9
2 3 2 3
1 2 3
3 2 1
4 5 6
7 8 9
2 3 3 2
1 2 3
3 2 1
4 5
6 7
8 9
0 0 0 0
 */