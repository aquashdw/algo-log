package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Prob7569 {
    private final int[] dx = {-1, 1, 0, 0, 0, 0};
    private final int[] dy = {0, 0, -1, 1, 0, 0};
    private final int[] dh = {0, 0, 0, 0, -1, 1};
    private int x;
    private int y;
    private int h;

    public int solution() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer infoParser = new StringTokenizer(reader.readLine());
        x = Integer.parseInt(infoParser.nextToken());
        y = Integer.parseInt(infoParser.nextToken());
        h = Integer.parseInt(infoParser.nextToken());
        int[][][] tomatoRack = new int[h][y][x];

        Queue<int[]> toVisit = new LinkedList<>();

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < y; j++) {
                StringTokenizer tomatoStore = new StringTokenizer(reader.readLine());
                for (int k = 0; k < x; k++) {
                    int tomato = Integer.parseInt(tomatoStore.nextToken());
                    if(tomato == 1) {
                        toVisit.add(new int[]{i, j, k, 0});
                    }
                    tomatoRack[i][j][k] = tomato;
                }
            }
        }

        int days = 0;
        while (!toVisit.isEmpty()) {
            int [] tomato = toVisit.poll();
            assert tomatoRack[tomato[0]][tomato[1]][tomato[2]] != -1;
            if (days != tomato[3]) days = tomato[3];

            for (int i = 0; i < 6; i++) {
                int nextH = tomato[0] + dh[i];
                int nextY = tomato[1] + dy[i];
                int nextX = tomato[2] + dx[i];
                if (
                        checkBounds(nextX, nextY, nextH)
                        && tomatoRack[nextH][nextY][nextX] == 0
                ) {
                    tomatoRack[nextH][nextY][nextX] = 1;
                    toVisit.offer(new int[]{nextH, nextY, nextX, tomato[3] + 1});
                }
            }
        }

        for (int i = 0; i < this.h; i++) {
            for (int j = 0; j < this.y; j++) {
                for (int k = 0; k < this.x; k++) {
                    if (tomatoRack[i][j][k] == 0) return -1;
                }
            }
        }
        return days;
    }

    private boolean checkBounds(int x, int y, int h) {
        return
                -1 < x && x < this.x
                && -1 < y && y < this.y
                && -1 < h && h < this.h;
    }

    public static void main(String[] args) throws IOException {
        System.out.println(new Prob7569().solution());
    }
}
