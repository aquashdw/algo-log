package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.acmicpc.net/problem/5866
public class Prob5866 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] be = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        int[] bessiePos = new int[1_000_001];
        int[] elsiePos = new int[1_000_001];
        int now = 1;
        for (int i = 0; i < be[0]; i++) {
            String[] token = reader.readLine().split(" ");
            int time = Integer.parseInt(token[0]);
            int dir = token[1].equals("L") ? -1 : 1;
            for (int j = 0; j < time; j++) {
                bessiePos[now] = bessiePos[now - 1] + dir;
                now++;
            }
        }
        int bessieEnd = now;
        for (int i = now; i < bessiePos.length; i++) {
            bessiePos[i] = bessiePos[i - 1];
        }

        now = 1;
        for (int i = 0; i < be[1]; i++) {
            String[] token = reader.readLine().split(" ");
            int time = Integer.parseInt(token[0]);
            int dir = token[1].equals("L") ? -1 : 1;
            for (int j = 0; j < time; j++) {
                elsiePos[now] = elsiePos[now - 1] + dir;
                now++;
            }
        }
        int elsieEnd = now;
        for (int i = now; i < elsiePos.length; i++) {
            elsiePos[i] = elsiePos[i - 1];
        }

        int end = Math.max(bessieEnd, elsieEnd);
        int moos = 0;
        boolean met = true;
        for (int i = 1; i < end; i++) {
            if (bessiePos[i] == elsiePos[i]) {
                moos += met ? 0 : 1;
                met = true;
            } else met = false;
        }
        System.out.println(moos);
    }
}
