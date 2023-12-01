package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Prob2304 {
    public void solution() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        // 가로의 길이
        int N = Integer.parseInt(reader.readLine());

        // 기둥 높이 정보
        int[][] heights = new int[N][2];

        for (int i = 0; i < N; i++) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            heights[i][0] = Integer.parseInt(tokenizer.nextToken());  // 위치
            heights[i][1] = Integer.parseInt(tokenizer.nextToken());  // 높이
        }

        Arrays.sort(heights, (left, right) -> left[0] - right[0]);

        // 가장 높은 기둥 저장
        int leftMax = 0;
        for (int i = 0; i < N; i++){
            // 기록된 위치의 높이보다 현재 위치의 높이가 높으면
            if (heights[i][1] > heights[leftMax][1]) {
                leftMax = i;
            }
        }
        // 최대 높이가 복수일 경우 오른쪽 높은 기둥도 저장
        int rightMax = 0;
        for (int i = N - 1; i >= leftMax; i--) {
            // 왼쪽 기준의 최댓값까지 확인한다.
            if (heights[i][1] == heights[leftMax][1]) {
                rightMax = i;
                break;
            }
        }

        // 왼쪽 공간 계산 시작
        int leftIdx = 0;
        int leftCurrentMax = leftIdx;

        // 가장 가까운 주변보다 높은 기둥부터 확인하기 위해 스택 활용
        Stack<Integer> leftCeiling = new Stack<>();
        // 첫번째 위치
        leftCeiling.push(leftIdx);
        while (leftIdx < leftMax) {
            // 높아졌으면
            if (heights[leftIdx][1] > heights[leftCurrentMax][1]) {
                // 나중에 확인하기 위해 기록
                leftCeiling.push(leftIdx);
                // 비교를 위해 갱신
                leftCurrentMax = leftIdx;
            }
            // 다음 기둥으로
            leftIdx++;
        }

        // 오른쪽도 동일하나, 반대방향으로
        int rightIdx = N - 1;
        int rightCurrentMax = rightIdx;

        Stack<Integer> rightCeiling = new Stack<>();
        rightCeiling.push(rightCurrentMax);
        while (rightIdx > rightMax) {
            if (heights[rightIdx][1] > heights[rightCurrentMax][1]) {
                rightCeiling.push(rightIdx);
                rightCurrentMax = rightIdx;
            }
            rightIdx--;
        }

        // 제일 높은 기둥 높이 한칸 넓이
        int answer = heights[leftMax][1];

        int pivot = leftMax;
        while (!leftCeiling.isEmpty()) {
            // 가장 가까운 지역 최대 높이 기준
            int next = leftCeiling.pop();
            // 현재 최대에서 부터 해당 지점까지 거리 * 해당 지점 높이
            answer += heights[next][1] * (heights[pivot][0] - heights[next][0]);
            // 다음 넓이는 여기를 기준으로 계산한다.
            pivot = next;
        }

        pivot = rightMax;
        while (!rightCeiling.isEmpty()) {
            int next = rightCeiling.pop();
            // 오른쪽으로 가고있기 때문에 next - pivot
            answer += heights[next][1] * (heights[next][0] - heights[pivot][0]);
            pivot = next;
        }

        // 왼쪽 최대와 오른쪽 최대가 같다면 이쪽은 0이 더해진다.
        answer += (heights[rightMax][0] - heights[leftMax][0]) *  heights[leftMax][1];

        System.out.println(answer);
    }

    public static void main(String[] args) throws IOException {
        new Prob2304().solution();
    }
}

/*
4
1 6
3 6
5 6
7 5
 */