package com.pryadko.domain;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Repository
public class Board {
    public static final int SIZE = 9;
    public static final int SMALL_SIZE = SIZE / 3;
    private final List<Cell> cells = new ArrayList<>(81);

    public Board() {
        for (int i = 0; i < SIZE * SIZE; i++) {
            cells.add(new Cell(i));
        }
    }

    public List<Cell> getCells() {
        return new ArrayList<>(cells);
    }

    public boolean isSolved() {
        return getCells().stream()
                .allMatch(Cell::isNotEmpty);
    }

    public boolean isValid() {
        //todo not implemented yet
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public void setValue(int index, int value) {
        cells.get(index).setValue(value);
        getDependentCell(index).forEach(cell -> cell.removeDependency(value));
    }

    public Set<Cell> getDependencyCol(Integer row) {
        return IntStream.range(0, SIZE)
                .mapToObj(ind -> cells.get(row * SIZE + ind))
                .collect(Collectors.toSet());
    }

    public Set<Cell> getDependencyRow(Integer col) {
        return IntStream.range(0, SIZE)
                .mapToObj(ind -> cells.get(ind * SIZE + col % SIZE))
                .collect(Collectors.toSet());
    }

    public Set<Cell> getDependencyBox(Integer box) {
        int startPosition = SMALL_SIZE * (box / SMALL_SIZE * SIZE + box % SMALL_SIZE);

        Set<Cell> dependentCells = new HashSet<>();
        IntStream.range(0, SMALL_SIZE)
                .forEach(x -> IntStream.range(0, SMALL_SIZE)
                        .forEach(y -> {
                            dependentCells.add(cells.get(startPosition + y * SIZE + x));
                        }));
        return dependentCells;
    }

    public Set<Cell> getDependentCell(Integer cellId) {
        Set<Cell> dependentCells = new HashSet<>();
        IntStream.range(0, SIZE)
                .forEach(id -> {
                    dependentCells.add(cells.get(cellId / SIZE * SIZE + id));
                    dependentCells.add(cells.get(id * SIZE + cellId % SIZE));
                });

        IntStream.range(0, SMALL_SIZE)
                .forEach(x -> IntStream.range(0, SMALL_SIZE)
                        .forEach(y -> {
                            int startPosition = SMALL_SIZE * (cellId % SIZE / SMALL_SIZE + cellId / SIZE / SMALL_SIZE * SIZE);
                            int index = startPosition + y * SIZE + x;
                            dependentCells.add(cells.get(index));
                        }));

        dependentCells.removeIf(cell -> cell.getId() == cellId);

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
