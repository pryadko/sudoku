package com.pryadko.algorithm;

import com.pryadko.domain.Board;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Solver {

    private final List<Algorithm> algorithms;

    @Autowired
    public Solver(List<Algorithm> algorithms) {
        this.algorithms = algorithms;
    }

    public Board solve(Board board) {
        Board before;
        Board solved = new Board(board);
        do {
            before = new Board(solved);
            for (Algorithm algorithm : algorithms) {
                solved = algorithm.solve(before);
                if (!solved.equals(before)) {
                    break;
                }
            }
        } while (!solved.equals(before));


        return solved;
    }

}