package bf;


import java.util.ArrayList;
import java.util.List;

public class PowerSetBit {
    public static void main(String[] args) {
        int[] set = {1, 2, 3};
        new PowerSetBit().powerSet(set);
    }

    public void powerSet(int[] set) {
        int n = set.length;
        int subsetCount = 1 << n;

        for (int i = 0; i < subsetCount; i++) {
            List<Integer> subset = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0) {
                    subset.add(set[j]);
                }
            }

            System.out.println(subset);
        }
    }
}