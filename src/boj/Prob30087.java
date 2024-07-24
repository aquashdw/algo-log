package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

// https://www.acmicpc.net/problem/30087
public class Prob30087 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, String> info = new HashMap<>();
        info.put("Algorithm", "204");
        info.put("DataAnalysis", "207");
        info.put("ArtificialIntelligence", "302");
        info.put("CyberSecurity", "B101");
        info.put("Network", "303");
        info.put("Startup", "501");
        info.put("TestStrategy", "105");

        int count = Integer.parseInt(reader.readLine());
        StringBuilder answer = new StringBuilder();
        reader.lines().limit(count).forEach(line -> answer
                .append(info.get(line))
                .append('\n'));
        System.out.print(answer);
    }
}
