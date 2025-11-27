package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// https://www.acmicpc.net/problem/10673
public class Prob20292 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();
        String line;
        Set<String> read = new HashSet<>();
        Set<String> written = new HashSet<>();
        Set<String> writeRec = new HashSet<>();
        while (!(line = reader.readLine()).equals("EXIT")) {
            String[] tokens = line.split(" ");
            String command = tokens[0];
            String readMem = tokens[1];
            if (command.equals("READ")) {
                if (written.contains(readMem)) {
                    answer.append("WAIT\n");
                    read.clear();
                    written.clear();
                    writeRec.clear();
                }
                read.add(readMem);
            } else if (command.equals("WRITE")) {
                String writeCmd = line.substring(6);
                String writeMem = tokens[3];
                boolean clear = (
                        written.contains(readMem) ||
                                read.contains(writeMem) ||
                                written.contains(writeMem) ||
                                writeRec.contains(writeCmd) ||
                                writeRec.contains(String.join(" ", List.of(writeMem, "TO", readMem)))
                );
                if (clear) {
                    answer.append("WAIT\n");
                    read.clear();
                    written.clear();
                    writeRec.clear();
                }
                read.add(readMem);
                written.add(writeMem);
                writeRec.add(line.substring(6));
            }
            answer.append(line).append('\n');
        }
        answer.append("EXIT");
        System.out.println(answer);
    }
}
