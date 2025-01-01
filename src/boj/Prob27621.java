package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Collectors;

// https://www.acmicpc.net/problem/27621
public class Prob27621 {
    private static final long[][] table = {
            {0, 0, 0},
            {0, 0, 1},
            {0, 1, 1},
            {1, 1, 1},
            null,
            null,
            {-1, -1, 2},
            {0, -1, 2},
            {0, 0, 2},
            {0, 1, 2},
            {1, 1, 2},
            {-2, -2, 3},
            {7, 10, -11},
            null,
            null,
            {-1, 2, 2},
            {-511, -1609, 1626},
            {1, 2, 2},
            {-1, -2, 3},
            {0, -2, 3},
            {1, -2, 3},
            {-11, -14, 16},
            null,
            null,
            {-2901096694L, -15550555555L, 15584139827L},
            {-1, -1, 3},
            {0, -1, 3},
            {0, 0, 3},
            {0, 1, 3},
            {1, 1, 3},
            {-283059965, -2218888517L, 2220422932L},
            null,
            null,
            {-2736111468807040L, -8778405442862239L, 8866128975287528L},
            {-1, 2, 3},
            {0, 2, 3},
            {1, 2, 3},
            {0, -3, 4},
            {1, -3, 4},
            {117367, 134476, -159380},
            null,
            null,
            {-80538738812075974L, 80435758145817515L, 12602123297335631L},
            {2, 2, 3},
            {-5, -7, 8},
            {2, -3, 4},
            {-2, 3, 3},
            {6, 7, -8},
            {-23, -26, 31},
            null,
    };

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        long[] nums = table[Integer.parseInt(reader.readLine())];
        System.out.println(nums == null ? 0 :
                Arrays.stream(nums).mapToObj(String::valueOf).collect(Collectors.joining(" ")));
    }
}
