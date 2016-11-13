package com.pryadko.algorithm;

import com.pryadko.domain.Board;
import org.springframework.stereotype.Service;

@Service
public class LevelZero implements Algorithm {

    public Board solve(final Board board) {
        Board solved = new Board(board);
        board.getCells()
                .forEach(cell -> {
                    if (cell.hasOneVariant()) {
                        solved.setValue(cell.getId(), cell.getVariant());
                    }
                });

        return solved;
    }
}
