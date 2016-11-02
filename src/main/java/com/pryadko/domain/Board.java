package com.pryadko.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;

public class Board {
    private static int SIZE = 9;
    private static int SMALL_SIZE = SIZE / 3;
    private List<Cell> cells = new ArrayList<>(81);

    public Board() {
        for (int i = 0; i < SIZE * SIZE; i++) {
            cells.add(new Cell(i));
        }
    }

    public void setValue(int index, int value) {
        cells.get(index).setValue(value);
    }

    public void setValue(int index, String value) {
        cells.get(index).setValue(value);
    }

    protected Set<Cell> getDependentCell(Integer cellId) {
        Set<Cell> dependentCells = new HashSet<>();
        int col = (cellId + 1) / SIZE;
        int row = (cellId) * 10 / SIZE;
        int boxCol = (col + 1) / SMALL_SIZE;
        int boxRow = (row) * 10 / SMALL_SIZE;
        IntStream.range(col, SIZE + col)
                .filter(id -> cellId != id)
                .forEach(id -> dependentCells.add(cells.get(id)));

        IntStream.range(0, SIZE)
                .forEach(value -> dependentCells.add(cells.get(value * SIZE + row)));

        IntStream.range(0, SMALL_SIZE)
                .forEach(x -> IntStream.range(0, SMALL_SIZE)
                        .forEach(y -> {
                            Cell e = cells.get(x + boxCol * SMALL_SIZE + (boxRow * SMALL_SIZE * SIZE) + y * SIZE);
                            dependentCells.add(e);
                        }));

        return dependentCells;
    }

    @Override
    public String toString() {
        String result = "*************\n";
        for (int i = 0; i < SIZE; i++) {
            result += "*";
            for (int j = 0; j < SIZE; j++) {
                Cell cell = cells.get(i * SIZE + j);
                result += cell.valueToString() + ((j + 1) % SMALL_SIZE == 0 ? "*" : "");
            }
            result += "\n" + ((i + 1) % SMALL_SIZE == 0 ? "*************\n" : "");

        }
        return result;
    }
}
