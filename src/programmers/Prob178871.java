package programmers;


import java.util.HashMap;
import java.util.Map;

// https://school.programmers.co.kr/learn/courses/30/lessons/178871
public class Prob178871 {
    // 개별 탐색 시 시간초과
    /*
    public String[] solution(String[] players, String[] callings) {
        for (String call : callings) {
            int index = indexOfPlayer(call, players);
            if (index == 0 || index == -1) continue;
            String temp = players[index - 1];
            players[index - 1] = players[index];
            players[index] = temp;
        }

        return players;
    }

    public int indexOfPlayer(String player, String[] players) {
        for (int i = 0; i < players.length; i++) {
            if (player.equals(players[i]))
                return i;
        }
        return -1;
    }
     */

    // Map으로 index 관리
    public String[] solution(String[] players, String[] callings) {
        Map<String, Integer> playerMap = new HashMap<>();
        for (int i = 0; i < players.length; i++) {
            playerMap.put(players[i], i);
        }

        for (String call : callings) {
            int back = playerMap.get(call);
            int front = playerMap.get(players[back - 1]);

            playerMap.put(call, front);
            playerMap.put(players[front], back);

            String temp = players[front];
            players[front] = players[back];
            players[back] = temp;
        }

        return players;
    }
}
