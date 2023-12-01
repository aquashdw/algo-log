package graph;

import java.util.LinkedList;
import java.util.Queue;

public class Programmers43162 {
    public int solution(int n, int[][] computers) {
        int answer = 0;

        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!visited[i]){
                network(i, n, computers, visited);
                answer++;
            }
        }

        return answer;
    }

    public void network(int computer, int n, int[][] computers, boolean[] visited) {
        Queue<Integer> toVisit = new LinkedList<>();
        toVisit.offer(computer);
        while (!toVisit.isEmpty()) {
            int next = toVisit.poll();
//            visited[next] = true;

            for (int i = 0; i < n; i++) {
                if (computers[next][i] == 1 && !visited[i]) {
                    toVisit.offer(i);
                    visited[i] = true;
                }
            }
        }
    }

    public static void main(String[] args) {
        int answer = new Programmers43162().solution(3, new int[][]{
                {1, 1, 0},
                {1, 1, 0},
                {0, 0, 1}
        });
        System.out.println(answer);
    }
}
