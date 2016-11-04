package com.pryadko.process;

import javafx.util.Pair;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.HashSet;
import java.util.Objects;

@Service
public class Loader {

    public static final String ALLOW_NUMBERS = "123456789";

    public HashSet<Pair<Integer, Integer>> loadQueue(String fileName) {
        File file = new File(fileName);
        HashSet<Pair<Integer, Integer>> queue = new HashSet<>();
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            InputStreamReader in = new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader = new BufferedReader(in);
            String line;
            int index = 0;
            while ((line = bufferedReader.readLine()) != null) {
                for (int i = 0; i < line.length(); i++) {
                    String symbol = String.valueOf(line.charAt(i));
                    if (isNotDelimeter(symbol)) {
                        if (ALLOW_NUMBERS.contains(symbol)) {
                            queue.add(new Pair<>(index, Integer.parseInt(symbol)));
                        }
                        index++;
                    }
                }
            }

        } catch (IOException e) {
            //todo need append logger
        }

        return queue;
    }

    private boolean isNotDelimeter(String symbol) {
        return !Objects.equals(symbol, "*");
    }
}
