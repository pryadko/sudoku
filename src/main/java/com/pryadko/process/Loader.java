package com.pryadko.process;

import com.pryadko.domain.Board;
import org.springframework.stereotype.Service;

import java.io.*;

@Service
public class Loader {
    private static final String ALLOW_NUMBERS = "123456789";
    private static final String DELIMETERS = "\n*";

    public Board loadBoard(File file) {
        Board board = new Board();
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            InputStreamReader in = new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader = new BufferedReader(in);
            String line;
            int index = 0;
            while ((line = bufferedReader.readLine()) != null) {
                for (int i = 0; i < line.length(); i++) {
                    String symbol = String.valueOf(line.charAt(i));
                    if (isNotDelimiter(symbol)) {
                        if (ALLOW_NUMBERS.contains(symbol)) {
                            board.setValue(index, Integer.parseInt(symbol));
                        }
                        index++;
                    }
                }
            }

        } catch (IOException e) {
            //todo need append logger
        }

        return board;
    }

    public Board loadBoard(String string) {
        Board board = new Board();
        int index = 0;
        for (int i = 0; i < string.length(); i++) {
            String symbol = String.valueOf(string.charAt(i));
            if (isNotDelimiter(symbol)) {
                if (ALLOW_NUMBERS.contains(symbol)) {
                    board.setValue(index, Integer.parseInt(symbol));
                }
                index++;
            }
        }
        return board;
    }

    private boolean isNotDelimiter(String symbol) {
        return !DELIMETERS.contains(symbol);
    }
}
