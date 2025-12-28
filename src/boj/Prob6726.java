package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Collectors;

// https://www.acmicpc.net/problem/6726
public class Prob6726 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();
        reader.lines().takeWhile(line -> !line.equals("0"))
                .mapToInt(Integer::parseInt)
                .forEach(constant -> {
                    answer.append("Constant ").append(constant).append('\n');
                    answer.append(constant < 0 ? "C-1\n" : "C+1\n");
                    if (constant == 1 || constant == -1) {
                        answer.append('\n');
                        return;
                    }

                    int start = 1;
                    int increment = constant < 0 ? -1 : 1;
                    constant *= constant < 0 ? -1 : 1;
                    Queue<int[]> toVisit = new LinkedList<>();
                    int[][] visited = new int[65336][2];
                    for (int i = 0; i < 65336; i++) {
                        visited[i][0] = -1;
                        visited[i][1] = Integer.MAX_VALUE;
                    }
                    visited[start][0] = start;
                    visited[start][1] = 0;
                    toVisit.add(new int[]{start, 0});

                    while (!toVisit.isEmpty()) {
                        int[] now = toVisit.poll();
                        int nextInc = now[0] + increment;
                        int nextIncTime = now[1] + 2;
                        if (0 < nextInc && nextInc < 32768 && visited[nextInc][1] > nextIncTime && visited[constant][1] > nextIncTime) {
                            visited[nextInc][0] = now[0];
                            visited[nextInc][1] = nextIncTime;
                            if (nextInc != constant) {
                                toVisit.add(new int[]{nextInc, nextIncTime});
                            }
                        }

                        int nextDbl = now[0] * 2;
                        int nextDblTime = now[1] + 1;
                        if (0 < nextDbl && nextDbl < 32768 && visited[nextDbl][1] > nextDblTime && visited[constant][1] > nextDblTime) {
                            visited[nextDbl][0] = now[0];
                            visited[nextDbl][1] = nextDblTime;
                            if (nextDbl != constant) {
                                toVisit.add(new int[]{nextDbl, nextDblTime});
                            }
                        }
                    }
                    Deque<String> constructs = new LinkedList<>();
                    int now = constant;
                    while (visited[now][0] != now) {
                        if (now == 2 || now == visited[now][0] * 2) {
                            constructs.addFirst("DBL");
                        } else {
                            constructs.addFirst("INCR");
                        }
                        now = visited[now][0];
                    }
                    answer.append(constructs.stream().collect(Collectors.joining("\n"))).append('\n');
                    answer.append('\n');
                });
        System.out.print(answer);
    }
}
