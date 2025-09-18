package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

// https://www.acmicpc.net/problem/15143
public class Prob15143 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int words = Integer.parseInt(reader.readLine());
        Map<String, Double> atomMassStr = new HashMap<>();
        Map<Character, Double> atomMassChar = new HashMap<>();
        reader.lines().limit(words).forEach(line -> {
            String[] parts = line.split(" ");
            if (parts[0].length() == 2) atomMassStr.put(parts[0], Double.parseDouble(parts[1]));
            else atomMassChar.put(parts[0].charAt(0), Double.parseDouble(parts[1]));
        });

        String molecule = reader.readLine();
        double totalMass = 0;
        int i = 0;
        while (i < molecule.length()) {
            double mass = atomMassChar.getOrDefault(molecule.charAt(i), 0.0);
            if (i < molecule.length() - 1 && Character.isLowerCase(molecule.charAt(i + 1))) {
                mass = atomMassStr.getOrDefault(molecule.substring(i, i + 2), 0.0);
                i += 2;
            } else i++;
            int digits = i;
            while (digits < molecule.length() && Character.isDigit(molecule.charAt(digits))) {
                digits++;
            }
            if (i < digits) {
                mass *= Integer.parseInt(molecule.substring(i, digits));
                i = digits;
            }
            totalMass += mass;
        }
        System.out.println(totalMass);
    }
}
