package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// https://www.acmicpc.net/problem/2021
public class Prob2021 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        int stationCnt = info[0];
        int laneCnt = info[1];
        List<Set<Integer>> laneStations = new ArrayList<>(laneCnt);
        List<Set<Integer>> stationLanes = new ArrayList<>(stationCnt);
        stationLanes.add(null);
        for (int i = 0; i < stationCnt; i++) {
            stationLanes.add(new HashSet<>());
        }
        for (int i = 0; i < laneCnt; i++) {
            laneStations.add(new HashSet<>());
            int lane = i;
            Arrays.stream(reader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .filter(station -> station != -1)
                    .forEach(station -> {
                        stationLanes.get(station).add(lane);
                        laneStations.get(lane).add(station);
                    });
        }

        int[] path = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        int start = path[0];
        int goal = path[1];

        if (stationLanes.get(start).stream().anyMatch(lane -> laneStations.get(lane).contains(goal))) {
            System.out.println(0);
            return;
        }

        int[] visited = new int[laneCnt];
        Arrays.fill(visited, -1);
        Queue<int[]> toVisit = new LinkedList<>();
        for (int lane : stationLanes.get(start)) {
            toVisit.add(new int[]{lane, 0});
            visited[lane] = 0;
        }

        while (!toVisit.isEmpty() && stationLanes.get(goal).stream().allMatch(lane -> visited[lane] == -1)) {
            int[] now = toVisit.poll();

            Set<Integer> stations = laneStations.get(now[0]);
            for (int station : stations) {
                stationLanes.get(station).stream()
                        .filter(lane -> visited[lane] == -1)
                        .forEach(lane -> {
                            visited[lane] = now[1] + 1;
                            toVisit.add(new int[]{lane, now[1] + 1});
                        });
            }
        }


        System.out.println(stationLanes.get(goal).stream()
                .filter(lane -> visited[lane] != -1)
                .mapToInt(lane -> visited[lane])
                .min()
                .orElse(-1));
    }

}
