package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Prob11000 {
    public int solution() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int courses = Integer.parseInt(reader.readLine());
        PriorityQueue<int[]> lectureQueue = new PriorityQueue<>(Comparator.comparingInt(o -> o[0]));
        for (int i = 0; i < courses; i++) {
            StringTokenizer courseToken = new StringTokenizer(reader.readLine());
            lectureQueue.offer(new int[]{
                    Integer.parseInt(courseToken.nextToken()),
                    Integer.parseInt(courseToken.nextToken())
            });
        }

        PriorityQueue<Integer> roomQueue = new PriorityQueue<>();
        while (!lectureQueue.isEmpty()) {
            int[] nextLecture = lectureQueue.poll();
            if (roomQueue.isEmpty() || roomQueue.peek() <= nextLecture[0])
                roomQueue.poll();

            roomQueue.offer(nextLecture[1]);
        }

        return roomQueue.size();
    }

    public static void main(String[] args) throws IOException {
        System.out.println(new Prob11000().solution());
    }
}


/*
8
1 8
9 16
3 7
8 10
10 14
5 6
6 11
11 12

: 3
 */