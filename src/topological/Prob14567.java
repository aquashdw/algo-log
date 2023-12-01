package topological;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 14567
public class Prob14567 {
    public void solution() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer infoToken = new StringTokenizer(reader.readLine());
        int lectures = Integer.parseInt(infoToken.nextToken());
        int preReqs = Integer.parseInt(infoToken.nextToken());

        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < lectures + 1; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int i = 0; i < preReqs; i++) {
            StringTokenizer reqToken = new StringTokenizer(reader.readLine());
            int start = Integer.parseInt(reqToken.nextToken());
            int end = Integer.parseInt(reqToken.nextToken());
            adjList.get(start).add(end);
        }

        int[] inDegrees = new int[lectures + 1];
        for (List<Integer> neighbors: adjList) {
            for (int neighbor: neighbors) {
                inDegrees[neighbor]++;
            }
        }

        Queue<int[]> queue = new LinkedList<>();
        for (int i = 1; i < lectures + 1; i++) {
            if (inDegrees[i] == 0) queue.offer(new int[]{i, 1});
        }

        int[] firstSem = new int[lectures + 1];
        while (!queue.isEmpty()) {
            int[] lecture = queue.poll();
            firstSem[lecture[0]] = lecture[1];

            for (int nextLec: adjList.get(lecture[0])) {
                inDegrees[nextLec]--;
                if (inDegrees[nextLec] == 0)
                    queue.offer(new int[]{nextLec, lecture[1] + 1});
            }
        }

        StringBuilder answer = new StringBuilder();
//        for (int sem: firstSem) answer.append(sem).append(' ');
        for (int i = 1; i < lectures + 1; i++)
            answer.append(firstSem[i]).append(' ');
        System.out.println(answer);
    }

    public static void main(String[] args) throws IOException {
        new Prob14567().solution();
    }
}
