package com.pryadko.algorithm;

import com.pryadko.domain.Board;
import javafx.util.Pair;
import org.springframework.stereotype.Service;

import java.util.ArrayDeque;
import java.util.Queue;

@Service
public class LevelZero implements Algorithm {

    public Queue<Pair<Integer, Integer>> solve(Board board) {

        Queue<Pair<Integer, Integer>> queue = new ArrayDeque<>();
        board.getCells()
                .forEach(cell -> {
                    if (cell.hasOneVariant()) {
                        Pair<Integer, Integer> newPairToSolve = new Pair<>(cell.getId(), cell.getVariant());
                        queue.add(newPairToSolve);
                    }
                });
        return queue;
    }
}
