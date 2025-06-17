package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.acmicpc.net/problem/31428
public class Prob31428 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        String friends = reader.readLine();
        String me = reader.readLine();
        System.out.println(Arrays.stream(friends.split(" "))
                .filter(me::equals)
                .count());
    }
}
