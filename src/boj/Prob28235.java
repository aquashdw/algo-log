package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;

// https://www.acmicpc.net/problem/28235
public class Prob28235 {
    private static final Map<String, String> chants = Map.of(
            "SONGDO", "HIGHSCHOOL",
            "CODE", "MASTER",
            "2023", "0611",
            "ALGORITHM", "CONTEST"
    );

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(chants.get(reader.readLine()));
    }
}
