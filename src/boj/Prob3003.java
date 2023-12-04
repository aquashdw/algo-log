package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

// 기초
public class Prob3003 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] inPiecesRaw = reader.readLine().split(" ");
        int[] normPieces = {1, 1, 2, 2, 2, 8};
        for(int i = 0; i < 6; i++) {
            String pieceRaw = inPiecesRaw[i];
            normPieces[i] -= Integer.parseInt(pieceRaw);
        }
//        Scanner scanner = new Scanner(System.in);
//        int[] currPieces = {
//                scanner.nextInt(),
//                scanner.nextInt(),
//                scanner.nextInt(),
//                scanner.nextInt(),
//                scanner.nextInt(),
//                scanner.nextInt()
//        };
//        scanner.nextLine();
//        for(int i = 0; i < 6; i++) {
//            normPieces[i] -= currPieces[i];
//        }

        System.out.printf("%d %d %d %d %d %d%n",
                normPieces[0], normPieces[1], normPieces[2], normPieces[3], normPieces[4], normPieces[5]);
    }
}
