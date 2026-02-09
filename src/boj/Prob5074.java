package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/5074
public class Prob5074 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();
        reader.lines().takeWhile(line -> !line.equals("00:00 00:00"))
                .forEach(line -> {
                    String[] times = line.split(" ");
                    String[] startTime = times[0].split(":");
                    int startHour = Integer.parseInt(startTime[0]);
                    int startMinute = Integer.parseInt(startTime[1]);

                    String[] addTime = times[1].split(":");
                    int addHour = Integer.parseInt(addTime[0]);
                    int addMinute = Integer.parseInt(addTime[1]);

                    int dateChange = 0;

                    startMinute += addMinute;
                    if (startMinute >= 60) {
                        startMinute -= 60;
                        startHour += 1;
                    }

                    startHour += addHour;
                    while (startHour >= 24) {
                        startHour -= 24;
                        dateChange += 1;
                    }

                    answer.append(String.format("%02d:%02d", startHour, startMinute));
                    if (dateChange > 0) {
                        answer.append(" +").append(dateChange);
                    }
                    answer.append('\n');
                });
        System.out.print(answer);
    }
}
