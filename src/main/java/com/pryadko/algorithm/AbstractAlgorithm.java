package com.pryadko.algorithm;

import com.pryadko.domain.Board;
import com.pryadko.domain.Cell;
import javafx.util.Pair;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayDeque;
import java.util.Queue;

public abstract class AbstractAlgorithm implements Algorithm {
    protected Board board = new Board();
    protected Queue<Pair<Integer, Integer>> queue = new ArrayDeque<>();

    @Autowired
    public AbstractAlgorithm(Board board) {
        board.getCells().stream()
                .filter(Cell::isNotEmpty)
                .forEach(cell -> {
                    Pair<Integer, Integer> value = new Pair<>(cell.getId(), cell.getValue());
                    queue.add(value);
                });
    }

    public abstract Board solve();
}
