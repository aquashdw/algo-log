package graph;

import java.util.LinkedList;
import java.util.Queue;

public class Programmers43165 {
    private int answer = 0;
    public int solution(int[] numbers, int target) {
        dfs(numbers, 0, target, 0);
//        bfs(numbers, target);
        return answer;
    }

    public void dfs(int[] numbers, int next, int target, int sum) {
        if (next == numbers.length) {
            if (sum == target) this.answer++;
        }
        else {
            dfs(numbers, next + 1, target, sum + numbers[next]);
            dfs(numbers, next + 1, target, sum - numbers[next]);
        }
    }

    public void bfs(int[] numbers, int target) {
        Queue<Integer[]> toTry = new LinkedList<>();
        toTry.offer(new Integer[]{0, 0});
        while (!toTry.isEmpty()) {
            Integer[] nextTry = toTry.poll();
            if (nextTry[0] == numbers.length) {
                if (nextTry[1] == target) answer++;
            } else {
                toTry.offer(new Integer[]{nextTry[0] + 1, nextTry[1] + numbers[nextTry[0]]});
                toTry.offer(new Integer[]{nextTry[0] + 1, nextTry[1] - numbers[nextTry[0]]});
            }
        }
    }

    public static void main(String[] args) {
        new Programmers43165().solution(new int[]{1, 1, 1, 1, 1}, 3);
    }
}
