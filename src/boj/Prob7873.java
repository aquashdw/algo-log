package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// https://www.acmicpc.net/problem/7873
public class Prob7873 {
    private static final int[][] deltas = {
            {0, -1},
            {-1, 0},
            {0, 1},
            {1, 0},
    };
    private static final Map<Character, Map<Character, Set<Integer>>> adjRule = Map.of(
            'A', Map.of(),
            'B', Map.of(
                    'C', Set.of(3),
                    'D', Set.of(0, 3),
                    'E', Set.of(0),
                    'F', Set.of(0, 3)
            ),
            'C', Map.of(
                    'B', Set.of(1),
                    'D', Set.of(0),
                    'E', Set.of(0, 1),
                    'F', Set.of(0, 1)
            ),
            'D', Map.of(
                    'B', Set.of(1, 2),
                    'C', Set.of(2),
                    'E', Set.of(1),
                    'F', Set.of(1, 2)
            ),
            'E', Map.of(
                    'B', Set.of(2),
                    'C', Set.of(2, 3),
                    'D', Set.of(3),
                    'F', Set.of(2, 3)
            ),
            'F', Map.of(
                    'B', Set.of(1, 2),
                    'C', Set.of(2, 3),
                    'D', Set.of(0, 3),
                    'E', Set.of(0, 1),
                    'F', Set.of(0, 1, 2, 3)
            )
    );
    private static int[] size;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(reader.readLine());
        StringBuilder answer = new StringBuilder();
        for (int testCase = 1; testCase < tests + 1; testCase++) {
            size = Arrays.stream(reader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            char[][] map = new char[size[0]][];
            for (int i = 0; i < size[0]; i++) {
                map[i] = reader.readLine().toCharArray();
            }
            boolean[][] visited = new boolean[size[0]][size[1]];
            int count = 0;
            for (int i = 0; i < size[0] * size[1]; i++) {
                int y = i / size[1];
                int x = i % size[1];
                if (visited[y][x]) continue;
                visited[y][x] = true;
                if (map[y][x] == 'A') continue;
                count++;
                Queue<int[]> toVisit = new LinkedList<>();
                toVisit.add(new int[]{y, x});
                while (!toVisit.isEmpty()) {
                    int[] now = toVisit.poll();
                    Map<Character, Set<Integer>> rule = adjRule.get(map[now[0]][now[1]]);
                    for (int j = 0; j < 4; j++) {
                        int[] delta = deltas[j];
                        int nextY = now[0] + delta[0];
                        int nextX = now[1] + delta[1];
                        if (!checkBounds(nextY, nextX) || visited[nextY][nextX]) continue;
                        char next = map[nextY][nextX];
                        if (!rule.containsKey(next) || !rule.get(next).contains(j)) continue;
                        visited[nextY][nextX] = true;
                        toVisit.add(new int[]{nextY, nextX});
                    }
                }
            }
            answer.append(count).append('\n');
        }
        System.out.print(answer);
    }

    private static boolean checkBounds(int y, int x) {
        return y >= 0 && y < size[0] && x >= 0 && x < size[1];
    }
}
