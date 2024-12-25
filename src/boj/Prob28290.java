package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/28290
public class Prob28290 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(switch (reader.readLine()) {
            case "fdsajkl;", "jkl;fdsa" -> "in-out";
            case "asdf;lkj", ";lkjasdf" -> "out-in";
            case "asdfjkl;" -> "stairs";
            case ";lkjfdsa" -> "reverse";
            default -> "molu";
        });
    }
}
