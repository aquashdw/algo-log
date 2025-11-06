package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.IntStream;


// https://www.acmicpc.net/problem/20901
public class Prob20901 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        boolean[] isCyl = new boolean[n];
        int[] size = new int[n];

        for (int i = 0; i < n; i++) {
            String line = reader.readLine();
            String[] tokens = line.split(" ");
            isCyl[i] = tokens[0].equals("cylinder");
            size[i] = Integer.parseInt(tokens[1]) * (isCyl[i] ? 2 : 1);
        }
        Integer[] indices = IntStream.range(0, n).boxed().toArray(Integer[]::new);
        Comparator<Integer> comparator = (block1, block2) -> {
            if (isCyl[block1] == isCyl[block2]) return Integer.compare(size[block1], size[block2]);
            if (isCyl[block1]) {
                if (size[block1] <= size[block2]) return -1;
                else if (size[block1] * size[block1] >= (size[block2] * size[block2]) * 2) return 1;
                else return 0;
            } else {
                if ((size[block1] * size[block1]) * 2 <= size[block2] * size[block2]) return -1;
                else if (size[block1] >= size[block2]) return 1;
                else return 0;
            }
        };
        Arrays.sort(indices, comparator);
        for (int i = 0; i < n - 1; i++) {
            if (comparator.compare(indices[i], indices[i + 1]) == 0 && isCyl[indices[i]] != isCyl[indices[i + 1]]) {
                System.out.println("impossible");
                return;
            }
        }
        StringBuilder answer = new StringBuilder();
        Arrays.stream(indices).forEach(i -> answer.append(String.format("%s %d%n", isCyl[i] ? "cylinder" : "cube", size[i] / (isCyl[i] ? 2 : 1))));
        System.out.print(answer);
    }
}
