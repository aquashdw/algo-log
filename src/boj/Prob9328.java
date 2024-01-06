package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// https://www.acmicpc.net/problem/9328
public class Prob9328 {
    private static int height;
    private static int width;
    private static char[][] map;
    private static Map<Character, Queue<int[]>> doorInfo;
    private static Queue<int[]> starts;
    private static final int[][] deltas = {
            {-1, 0},
            {1, 0},
            {0, -1},
            {0, 1}
    };


    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(reader.readLine());
        StringBuilder answerBuilder = new StringBuilder();
        for (int i = 0; i < tests; i++) {
            String[] mapInfo = reader.readLine().split(" ");
            height = Integer.parseInt(mapInfo[0]);
            width = Integer.parseInt(mapInfo[1]);
            map = new char[height][];
            doorInfo = new HashMap<>();
            starts = new LinkedList<>();
            for (int j = 0; j < height; j++) {
                map[j] = reader.readLine().toCharArray();
                for (int k = 0; k < width; k++) {
                    if (Character.isUpperCase(map[j][k])) {
                        doorInfo.putIfAbsent(map[j][k], new LinkedList<>());
                        doorInfo.get(map[j][k]).offer(new int[]{j, k});
                    }
                }
            }
            char[] keys = reader.readLine().toCharArray();
            for (char key: keys) {
                char keyDoor = Character.toUpperCase(key);
                if (doorInfo.containsKey(keyDoor)) {
                    for (int[] door: doorInfo.get(keyDoor)) {
                        map[door[0]][door[1]] = '.';
                    }
                }
            }

            for (int j = 0; j < height; j++) {
                for (int k = 0; k < width; k++) {
                    if (canMove(j, k) && (j == 0 || j == height - 1 || k == 0 || k == width - 1))
                        starts.offer(new int[]{j, k});
                }
            }

            answerBuilder.append(solve()).append('\n');
        }

        System.out.print(answerBuilder);
    }

    private static int solve() {
        int docs = 0;

        Queue<int[]> toVisit = new LinkedList<>(starts);
        boolean[][] visited = new boolean[height][width];
        while (!toVisit.isEmpty()) {
            int[] now = toVisit.poll();
            if (visited[now[0]][now[1]]) continue;
            visited[now[0]][now[1]] = true;
            // 열쇠를 주움
            if (Character.isLowerCase(map[now[0]][now[1]])) {
                char keyDoor = Character.toUpperCase(map[now[0]][now[1]]);
                // 이 열쇠로 열수 있는 문이 있다면,
                if (doorInfo.containsKey(keyDoor)) {
                    Queue<int[]> doors = doorInfo.get(keyDoor);
                    // 이 열쇠로 열수 있는 문을 전부 연다. 어차피 도달하면 열 수 있으니
                    while (!doors.isEmpty()) {
                        int[] door = doors.poll();
                        map[door[0]][door[1]] = '.';
                        // 가장자리 문이라면 들어갈 수 있는 곳이 늘었다.
                        if (door[0] == 0 || door[0] == height - 1 ||
                                door[1] == 0 || door[1] == width - 1) {
                            toVisit.offer(door);
                        }
                        // 만약 주변에 도달한적 있는 칸이 있다면 다시 올수 있으니
                        // 살펴본 뒤 방문 대상에 포함
                        else for (int[] delta: deltas) {
                            int[] prev = {door[0] + delta[0], door[1] + delta[1]};
                            if (checkBounds(prev[0], prev[1]) && visited[prev[0]][prev[1]]) {
                                toVisit.offer(door);
                                break;
                            }
                        }
                    }
                }
            }
            // 문서를 주움
            else if (map[now[0]][now[1]] == '$') {
                map[now[0]][now[1]] = '.';
                docs++;
            }
            // 이후 주변을 살핀다.
            for (int[] delta: deltas) {
                int[] next = new int[]{now[0] + delta[0], now[1] + delta[1]};
                // 빌딩 안, 갈 수 있음(공백, 열쇠, 문서), 간적 없음
                if (checkBounds(next[0], next[1]) &&
                        canMove(next[0], next[1]) &&
                        !visited[next[0]][next[1]]
                ) toVisit.offer(next);
            }
        }

        /*for (boolean[] row: visited) {
            System.out.println(Arrays.toString(row));
        }*/

        return docs;
    }

    private static boolean checkBounds(int y, int x) {
        return 0 <= y && y < height && 0 <= x && x < width;
    }

    private static boolean canMove(int y, int x) {
        char cell = map[y][x];
        return cell == '.' || cell == '$' || Character.isLowerCase(cell);
    }
}
