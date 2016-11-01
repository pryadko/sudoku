package com.pryadko.domain;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private List<Cell> cells = new ArrayList<>(81);

    public Board() {
        for (int i = 0; i < 81; i++) {
            cells.add(new Cell(i, 0));
        }
    }

    public void setValue(int index, int value) {
        cells.get(index).setValue(value);
    }

    @Override
    public String toString() {
        String result = "*************\n";
        for (int i = 0; i < 9; i++) {
            result += "*";
            for (int j = 0; j < 9; j++) {
                Cell cell = cells.get(i * 9 + j);
                result += cell.valueToString() + ((j+1)%3==0?"*":"");
            }
            result += "\n" +((i+1)%3==0?"*************\n":"");

        }
        return result;
    }
}
