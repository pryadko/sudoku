package com.pryadko.process;

import com.pryadko.domain.Board;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.Objects;

@Service
public class Loader {
    public Board loadBoard(String fileName) {
        Board board = new Board();
        File file = new File(fileName);
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            InputStreamReader in = new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader = new BufferedReader(in);
            String line;
            int index = 0;
            while ((line = bufferedReader.readLine()) != null) {
                for (int i = 0; i < line.length(); i++) {
                    String symbol = String.valueOf(line.charAt(i));
                    if (!Objects.equals(symbol, "*")) {
                        board.setValue(index++, symbol);
                    }
                }
            }

        } catch (IOException e) {
            //todo need append logger
        }


        return board;
    }
}
