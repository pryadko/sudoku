package com.pryadko.algorithm;

import com.pryadko.domain.Board;
import javafx.util.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Queue;

@Service
public class Solver {

    private final List<Algorithm> algorithms;
    private final Board board;

    @Autowired
    public Solver(Board board, List<Algorithm> algorithms) {
        this.board = board;
        this.algorithms = algorithms;
    }

    public Board solve() {

        for (Algorithm algorithm : algorithms) {
            Queue<Pair<Integer, Integer>> queue = algorithm.solve(board);
            if (!queue.isEmpty()) {
                queue.forEach(pair -> board.setValue(pair.getKey(), pair.getValue()));
                solve();
            }
        }

        return board;
    }

}
