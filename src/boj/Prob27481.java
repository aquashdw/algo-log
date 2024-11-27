package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Collectors;

// https://www.acmicpc.net/problem/27481
public class Prob27481 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        reader.readLine();
        int[] rooms = new int[10];
        reader.readLine().chars().forEach(next -> {
            if (next == 'L') {
                int i = 0;
                while (rooms[i] != 0) i++;
                rooms[i] = 1;
            }
            else if (next == 'R') {
                int i = 9;
                while (rooms[i] != 0) i--;
                rooms[i] = 1;
            }
            else {
                next -= '0';
                rooms[next] = 0;
            }
        });
        System.out.println(Arrays.stream(rooms).mapToObj(String::valueOf).collect(Collectors.joining("")));
    }
}
