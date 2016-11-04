package com.pryadko.algorithm;

import com.pryadko.domain.Board;
import javafx.util.Pair;
import org.springframework.stereotype.Service;

@Service
public class LevelZero extends AbstractAlgorithm {
    public LevelZero(Board board) {
        super(board);
    }

    @Override
    public Board solve() {
        if (queue.isEmpty()) {
            return board;
        }
        Pair<Integer, Integer> pair = queue.poll();
        board.setValue(pair.getKey(), pair.getValue());

        board.getDependentCell(pair.getKey())
                .forEach(cell -> {
                    if (cell.hasOneVariant()) {
                        Pair<Integer, Integer> newPairToSolve = new Pair<>(cell.getId(), cell.getVariant());
                        queue.add(newPairToSolve);
                    }
                });

        return solve();
    }
}
