package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// https://www.acmicpc.net/problem/24336
public class Prob24336 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Double> distFromSeoul = new HashMap<>();
        distFromSeoul.put("Seoul", 0.0);
        distFromSeoul.put("Yeongdeungpo", 9.1);
        distFromSeoul.put("Anyang", 23.9);
        distFromSeoul.put("Suwon", 41.5);
        distFromSeoul.put("Osan", 56.5);
        distFromSeoul.put("Seojeongri", 66.5);
        distFromSeoul.put("Pyeongtaek", 75.0);
        distFromSeoul.put("Seonghwan", 84.4);
        distFromSeoul.put("Cheonan", 96.6);
        distFromSeoul.put("Sojeongni", 107.4);
        distFromSeoul.put("Jeonui", 114.9);
        distFromSeoul.put("Jochiwon", 129.3);
        distFromSeoul.put("Bugang", 139.8);
        distFromSeoul.put("Sintanjin", 151.9);
        distFromSeoul.put("Daejeon", 166.3);
        distFromSeoul.put("Okcheon", 182.5);
        distFromSeoul.put("Iwon", 190.8);
        distFromSeoul.put("Jitan", 196.4);
        distFromSeoul.put("Simcheon", 200.8);
        distFromSeoul.put("Gakgye", 204.6);
        distFromSeoul.put("Yeongdong", 211.6);
        distFromSeoul.put("Hwanggan", 226.2);
        distFromSeoul.put("Chupungnyeong", 234.7);
        distFromSeoul.put("Gimcheon", 253.8);
        distFromSeoul.put("Gumi", 276.7);
        distFromSeoul.put("Sagok", 281.3);
        distFromSeoul.put("Yangmok", 289.5);
        distFromSeoul.put("Waegwan", 296.0);
        distFromSeoul.put("Sindong", 305.9);
        distFromSeoul.put("Daegu", 323.1);
        distFromSeoul.put("Dongdaegu", 326.3);
        distFromSeoul.put("Gyeongsan", 338.6);
        distFromSeoul.put("Namseonghyeon", 353.1);
        distFromSeoul.put("Cheongdo", 361.8);
        distFromSeoul.put("Sangdong", 372.2);
        distFromSeoul.put("Miryang", 381.6);
        distFromSeoul.put("Samnangjin", 394.1);
        distFromSeoul.put("Wondong", 403.2);
        distFromSeoul.put("Mulgeum", 412.4);
        distFromSeoul.put("Hwamyeong", 421.8);
        distFromSeoul.put("Gupo", 425.2);
        distFromSeoul.put("Sasang", 430.3);
        distFromSeoul.put("Busan", 441.7);

        int[] info = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        Map<String, String[]> trail = new HashMap<>();
        reader.lines().limit(info[0]).forEach(line -> {
            String[] stop = line.split(" ");
            trail.put(stop[0], new String[]{stop[1], stop[2]});
        });

        StringBuilder answer = new StringBuilder();
        reader.lines().limit(info[1]).forEach(line -> {
            String[] trip = line.split(" ");
            double distance = Math.abs(distFromSeoul.get(trip[0]) - distFromSeoul.get(trip[1]));
            String depTime = trail.get(trip[0])[1];
            String[] depSplit = depTime.split(":");
            int depHour = Integer.parseInt(depSplit[0]);
            int depMin = Integer.parseInt(depSplit[1]);
            String arrTime = trail.get(trip[1])[0];
            String[] arrSplit = arrTime.split(":");
            int arrHour = Integer.parseInt(arrSplit[0]);
            int arrMin = Integer.parseInt(arrSplit[1]);

            if (depHour > arrHour) arrHour += 24;
            if (depMin > arrMin) {
                arrMin += 60;
                arrHour--;
            }
            int totalMin = (arrHour - depHour) * 60 + (arrMin - depMin);
            answer.append(distance / totalMin * 60).append('\n');
        });
        System.out.print(answer);
    }
}
/*
3 2
1 2 1 2 1 2
 */