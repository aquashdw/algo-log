package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;

// https://www.acmicpc.net/problem/4658
public class Prob4658 {
    private static int maxPoints;
    private static final int[][] triangles = new int[6][3];
    private static final List<Set<Integer>> triContains = new ArrayList<>(6);
    private static final boolean[] used = new boolean[6];
    private static final int[] selectedEdge = new int[6];

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();
        while (true) {
            maxPoints = -1;
            triContains.clear();
            Arrays.fill(selectedEdge, -1);
            for (int i = 0; i < 6; i++) {
                int[] edgeNums = Arrays.stream(reader.readLine().split(" "))
                        .mapToInt(Integer::parseInt).toArray();

                triangles[i][0] = edgeNums[0];
                triangles[i][1] = edgeNums[1];
                triangles[i][2] = edgeNums[2];
                triContains.add(Set.of(edgeNums[0], edgeNums[1], edgeNums[2]));
            }

            used[0] = true;
            int[] firstTriangle = triangles[0];
            for (int i = 0; i < 3; i++) {
                selectedEdge[0] = i;
                int merge = firstTriangle[(i + 1) % 3];
                for (int j = 1; j < 6; j++) {
                    if (triContains.get(j).contains(merge)) {
                        used[j] = true;
                        dfs(j, 2, merge);
                        used[j] = false;
                    }
                }
            }
            used[0] = false;
            answer.append(maxPoints == -1 ? "none" : maxPoints).append('\n');
            String flag = reader.readLine();
            if (flag.equals("$")) break;
        }
        System.out.print(answer);
    }

    private static void dfs(int now, int depth, int merge) {
        // first retrieve now triangle
        int[] triangle = triangles[now];
        // find which edge was merged by the previous triangle
        int mergeNow = -1;
        for (int i = 0; i < 3; i++) {
            if (triangle[i] == merge) {
                mergeNow = i;
                break;
            }
        }
        // this shouldn't happen, but just in case
        assert mergeNow != -1;
        // the point edge is always the next index edge, record
        selectedEdge[now] = (mergeNow + 1) % 3;
        // the next merge edge is the edge after that, find its value
        int mergeNext = triangle[(mergeNow + 2) % 3];
        // if depth is 6, then all the triangles are accounted for
        if (depth == 6) {
            // get the unmerged, unselected edge of zero triangle
            int firstEdge = triangles[0][(selectedEdge[0] + 2) % 3];
            // the two values should be the same, or the hexagon cannot be finished
            if (mergeNext == firstEdge) {
                // then evaluate the result
                maxPoints = Math.max(maxPoints, IntStream.range(0, 6)
                        .map(i -> triangles[i][selectedEdge[i]])
                        .sum());
            }
            return;
        }
        // if depth is not 6
        // lets look for a triangle that can be merged
        for (int i = 1; i < 6; i++) {
            if (used[i]) continue;
            if (!triContains.get(i).contains(mergeNext)) continue;
            used[i] = true;
            dfs(i, depth + 1, mergeNext);
            used[i] = false;
        }
    }
}
