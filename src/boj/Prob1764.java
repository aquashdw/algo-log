package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

// https://www.acmicpc.net/problem/1764
public class Prob1764 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] info = reader.readLine().split(" ");
        int n = Integer.parseInt(info[0]);
        int m = Integer.parseInt(info[1]);
        Set<String> notHeard = new HashSet<>();
        Set<String> notSeen = new HashSet<>();
        for (int i = 0; i < n; i++) {
            notHeard.add(reader.readLine());
        }
        for (int i = 0; i < m; i++) {
            notSeen.add(reader.readLine());
        }

        notHeard.retainAll(notSeen);
        Object[] notSeenOrHeard = notHeard.stream()
                .sorted()
                .toArray();
        System.out.println(notSeenOrHeard.length);
        for (Object name: notSeenOrHeard) {
            System.out.println(name);
        }
    }
}
