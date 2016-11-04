package com.pryadko.algorithm;

import com.pryadko.domain.Board;
import javafx.util.Pair;
import org.springframework.stereotype.Service;

@Service
public class LevelDummy extends AbstractAlgorithm {
    public LevelDummy(Board board) {
        super(board);
    }

    @Override
    public Board solve() {
        if (queue.isEmpty()) {
            return board;
        }
        Pair<Integer, Integer> pair = queue.poll();
        board.setValue(pair.getKey(), pair.getValue());

        return solve();
    }
}
