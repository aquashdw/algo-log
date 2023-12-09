package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;


// https://www.acmicpc.net/problem/1043
public class Prob1043 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] info = reader.readLine().split(" ");
        int n = Integer.parseInt(info[0]);
        int m = Integer.parseInt(info[1]);
        // 진실을 아는 사람이 있는 파티가 시작점이다.
        Set<Integer> truths = Arrays.stream(reader.readLine().split(" "))
                .skip(1)
                .map(Integer::parseInt)
                .collect(Collectors.toSet());

        // 파티 정보를 받으면, 각 파티의 참석자를 바탕으로 파티를 그래프로 연결해야 한다.
        // 참석자에 따라 방문한 파티를 기록하고,
        List<List<Integer>> people = new ArrayList<>(n + 1);
        for (int i = 0; i < n + 1; i++) {
            people.add(new ArrayList<>());
        }
        // 파티에 따른 참석자를 기록한다.
        List<List<Integer>> parties = new ArrayList<>(m + 1);
        parties.add(new ArrayList<>());
        for (int i = 0; i < m; i++) {
            List<Integer> partyParticipants = Arrays.stream(reader.readLine().split(" "))
                    .skip(1)
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
            parties.add(partyParticipants);
            for(int person : partyParticipants) {
                people.get(person).add(i + 1);
            }
        }


        // 그러면 진실을 아는 사람을 바탕으로 파티 그래프를 완전탐색했을 때,
        // 방문한적 없는 파티가 진실을 얘기할 수 있는 파티이다.
        boolean[] visited = new boolean[m + 1];
        for (int knows : truths) {
            Queue<Integer> partyToGo = new LinkedList<>();
            for (int party : people.get(knows)) {
                if (!visited[party])
                    partyToGo.add(party);
            }
            while (!partyToGo.isEmpty()) {
                int party = partyToGo.poll();
                if (visited[party]) continue;
                visited[party] = true;

                for (int participant : parties.get(party)) {
                    for (int nextParty : people.get(participant)) {
                        if (!visited[nextParty])
                            partyToGo.offer(nextParty);
                    }
                }
            }
        }

        int sum = 0;
        for (int i = 1; i < visited.length; i++)
            if (!visited[i]) sum++;

        System.out.println(sum);
    }
}
