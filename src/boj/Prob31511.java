package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.IntStream;

// https://www.acmicpc.net/problem/31511
public class Prob31511 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] nmspq = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        int n = nmspq[0];
        int m = nmspq[1];
        int pages = n / m + (n % m == 0 ? 0 : 1);
        int currentPage = nmspq[2] - 1;

        boolean[] selected = new boolean[n];
        reader.lines().limit(nmspq[3]).mapToInt(Integer::parseInt).forEach(item -> selected[item - 1] = true);

        boolean[] required = new boolean[n];
        reader.lines().limit(nmspq[4]).mapToInt(Integer::parseInt).forEach(item -> required[item - 1] = true);

        boolean[] pageNeedWork = new boolean[pages];
        IntStream.range(0, pages).forEach(page -> {
            int first = page * m;
            int last = (page + 1) * m;
            if (last > n) last = n;
            pageNeedWork[page] = IntStream.range(first, last)
//                    .anyMatch(item -> (required[item] && !selected[item]) || (!required[item] && selected[item]));
                    .anyMatch(item -> required[item] != selected[item]);
        });

        if (IntStream.range(0, pages).noneMatch(i -> pageNeedWork[i])) {
            System.out.println(0);
            return;
        }

        int firstTargetPage = Integer.MAX_VALUE;
        for (int i = 0; i < pages; i++) {
            if (pageNeedWork[i]) {
                firstTargetPage = i;
                break;
            }
        }

        int lastTargetPage = Integer.MIN_VALUE;
        for (int i = pages - 1; i > -1; i--) {
            if (pageNeedWork[i]) {
                lastTargetPage = i;
                break;
            }
        }

        // first you navigate to the nearer farthest incorrect page, left (0) or right (n / m)
        // then you re-navigate to the other farthest incorrect page
        int pageClicks = Math.min(Math.abs(currentPage - firstTargetPage), Math.abs(currentPage - lastTargetPage)) + lastTargetPage - firstTargetPage;

        System.out.println(IntStream.range(0, pages)
                .filter(page -> pageNeedWork[page])
                .map(page -> {
                    int pageItems = m;
                    int first = page * pageItems;
                    int last = (page + 1) * pageItems;
                    if (last > n) {
                        last = n;
                        pageItems = last - first;
                    }
                    int requireCount = 0;
                    int diffCount = 0;
                    for (int i = first; i < last; i++) {
                        if (required[i]) requireCount++;
                        if (required[i] != selected[i]) diffCount++;
                    }
                    // if none or all are required in the page,
                    // just hit the unselect or select all button
                    // unless diffCount is 0 (which is impossible),
                    // min # of button hits are always 1
                    if (requireCount == 0 || requireCount == pageItems) return 1;
                    // if we use the all button in other circumstances, there are two outcomes
                    // 1. select all then unselect unneeded items
                    // 2. unselect all then select needed items
                    // which means hit one of the all buttons once, then hit checkboxes for
                    // either not required or required items
                    int useAllButton = Math.min(pageItems - requireCount, requireCount) + 1;
                    // then compare that to clicking separate item buttons
                    return Math.min(useAllButton, diffCount);
                }).sum() + pageClicks);
    }
}
/*
13 4 1 5 5
1
4
9
10
11
1
3
6
7
8

13 4 1 0 10
1
2
3
4
5
6
7
8
9
13

 */