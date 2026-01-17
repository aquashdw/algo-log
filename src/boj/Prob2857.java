package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

// https://www.acmicpc.net/problem/2857
public class Prob2857 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<String> agents = reader.lines().limit(5).collect(Collectors.toList());
        String result = IntStream.range(0, 5).filter(i -> agents.get(i).contains("FBI")).map(i -> i + 1).mapToObj(String::valueOf).collect(Collectors.joining(" "));

        System.out.println(result.isEmpty() ? "HE GOT AWAY!" : result);
    }
}
