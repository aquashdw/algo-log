package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://www.acmicpc.net/problem/1236
public class Prob1236 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] size = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        char[][] floor = new char[size[0]][];

        List<Integer> emptyRow = new ArrayList<>();
        List<Integer> emptyCol = new ArrayList<>();
        for (int i = 0; i < size[0]; i++) {
            floor[i] = reader.readLine().toCharArray();
            boolean empty = true;
            for (int j = 0; j < size[1]; j++) {
                if (floor[i][j] == 'X') {
                    empty = false;
                    break;
                }
            }
            if (empty) emptyRow.add(i);
        }

        for (int i = 0; i < size[1]; i++) {
            boolean empty = true;
            for (int j = 0; j < size[0]; j++) {
                if (floor[j][i] == 'X') {
                    empty = false;
                    break;
                }
            }
            if (empty) emptyCol.add(i);
        }

        System.out.println(Math.max(emptyRow.size(), emptyCol.size()));
    }
}
