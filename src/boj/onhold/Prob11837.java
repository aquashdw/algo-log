package boj.onhold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.acmicpc.net/problem/11837
public class Prob11837 {
    private static int rows;
    private static int cols;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        // 우선 누적합으로 나올 수 있는 모든 경우의 수의 크기를 구해둔다.
        // 이 누적합은 이후 경로 선택에도 활용

        // 움직이는 방향은 오른쪽과 아래쪽 뿐이다. 이때, 시작점을 기준으로
        // 1. 아래로 움직여서 만들 수 있는 경우의 갯수는 누적합 배열의 가장 오른쪽 아래에서 위쪽 칸의 숫자의 갯수
        // 2. 오른쪽으로 움직여서 만들 수 있는 경우의 갯수는 누적합 배열의 가장 오른쪽 아래에서 왼쪽 칸의 숫자의 갯수
        // 가 된다.

        // 만약 오른쪽 칸의 알파벳이 아래쪽 칸의 알파벳보다 빠를 경우,
        // 오른쪽으로 이동했을 때 선택 가능해지는 알파벳 나열은 위의 예시의 2.의 갯수에 해당하는 순서상 상위 문자열의 갯수이다. (늦을 경우 하위)
        // 이는 아래쪽 칸의 경우도 마찬가지로, 이때는 1.의 갯수에 해당하는 순서상 상위 문자열의 갯수가 된다.
        // 이와 내가 찾아야 하는 K를 비교하면서, 이동 방향을 결정한다. 만약 K가 하위 문자열에 속할 경우, K를 조정한다.

        // 이때 이동하게 될 경우 그 이후로 만들 수 있는 총 갯수가 조정이 되는데,
        // 이는 목적지에서 출발하여, 내가 이동한 방향의 반대 방향으로 이동한 것과 동일하다.

        int[] nm = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        rows = nm[0];
        cols = nm[1];
        char[][] board = new char[rows][];
        for (int i = 0; i < rows; i++) {
            board[i] = reader.readLine().toCharArray();
        }

        int[][] cases = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            cases[i][0] = 1;
        }
        for (int i = 0; i < cols; i++) {
            cases[0][i] = 1;
        }

        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                cases[i][j] = cases[i - 1][j] + cases[i][j - 1];
            }
        }

        long rank = Long.parseLong(reader.readLine());
        int[] now = {0, 0};
        int[] pivot = {rows - 1, cols - 1};
        StringBuilder answer = new StringBuilder();
        while (now[0] != rows - 1 && now[1] != cols - 1) {
            answer.append(board[now[0]][now[1]]);
            // 1. 오른쪽으로 갈때 나오는 경우의 수를 구한다.
            int[] rightIdx = {now[0], now[1] + 1};
            int[] rightCasesIdx = {pivot[0], pivot[1] - 1};
            if (!checkBounds(rightIdx[0], rightIdx[1])) {
                now[0]++;
                pivot[0]--;
                continue;
            }

            // 2. 아래로 갈때 나오는 경우의 수를 구한다.
            int[] downIdx = {now[0] + 1, now[1]};
            int[] downCasesIdx = {pivot[0] - 1, pivot[1]};

            // 만일 둘 중 하나가 범위를 벗어나면 한쪽으로만 갈 수 있다.
            if (!checkBounds(downIdx[0], downIdx[1])) {
                now[1]++;
                pivot[1]--;
                continue;
            }

            long rightCases = cases[rightCasesIdx[0]][rightCasesIdx[1]];
            long downCases = cases[downCasesIdx[0]][downCasesIdx[1]];

            // 3. 오른쪽과 아래를 비교하여 상위 하위를 결정한다.
            if (board[rightIdx[0]][rightIdx[1]] < board[downIdx[0]][downIdx[1]]) {
                // 3-1. 오른쪽이 상위일 경우 오른쪽으로 갔을 때 경우의 수가 rank를 포함하는지 확인
                // 포함할 경우 오른쪽으로 이동, rank 미조정
                // 포함하지 못할 경우 아래쪽으로 이동, rank 조정

            } else if (board[rightIdx[0]][rightIdx[1]] > board[downIdx[0]][downIdx[1]]) {
                // 3-2. 아래쪽이 상위일 경우 아래로 갔을 때 경우의 수가 rank를 포함하는지 확인
                // 포함할 경우 아래쪽으로 이동, rank 미조정
                // 포함하지 못할 경우 오른쪽으로 이동, rank 조정
            }
            // 3-3. 둘이 같은 경우 ......
        }
        answer.append(board[now[0]][now[1]]);
        System.out.println(answer);

    }

    private static boolean checkBounds(int y, int x) {
        return y >= 0 && y < rows && x >= 0 && x < cols;
    }
}

/*
abcd
efdg
hijk



a 1 1 1
1 2 3 4
1 3 6 10
-> 4 < 6 -> 4

b 1 1
1 2 3
1 3 6
-> 4 > 3 -> 4 - 3 == 1

f 1 1
1 2 3
-> 1 < 2 -> 1

d 1
1 2
-> 1 < 1

 */