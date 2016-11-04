package com.pryadko.domain;

import javafx.util.Pair;

import java.util.*;
import java.util.stream.IntStream;

public class Board {
    private static int SIZE = 9;
    private static int SMALL_SIZE = SIZE / 3;
    private List<Cell> cells = new ArrayList<>(81);
    private Queue<Pair<Integer, Integer>> queue = new ArrayDeque<>();

    public Board() {
        for (int i = 0; i < SIZE * SIZE; i++) {
            cells.add(new Cell(i));
        }
    }

    public void setValue(int index, int value) {
        //todo need add range validation
        queue.add(new Pair<>(index, value));
        solve();
    }

    private void solve() {
        if (queue.isEmpty()) {
            return;
        }
        Pair<Integer, Integer> pairToSolve = queue.poll();
        Integer key = pairToSolve.getKey();
        Integer value = pairToSolve.getValue();
        cells.get(key).setValue(value);

        getDependentCell(key).forEach(cell -> {
            cell.removeDependency(value);
            if (cell.hasOneVariant()) {
                Pair<Integer, Integer> newPairToSolve = new Pair<>(cell.getId(), cell.getVariant());
                queue.add(newPairToSolve);
            }
        });

        solve();
    }

    public void setValue(int index, String value) {
        if (Objects.equals(value, " ")) {
            return;
        }
        setValue(index, Integer.valueOf(value));
    }

    protected Set<Cell> getDependentCell(Integer cellId) {
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
