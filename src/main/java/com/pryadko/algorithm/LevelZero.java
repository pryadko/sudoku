package com.pryadko.algorithm;

import com.pryadko.domain.Cell;
import javafx.util.Pair;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Service
public class LevelZero implements Algorithm {
    @Override
    public Collection<? extends Pair<Integer, Integer>> solve(Set<Cell> dependentCell) {
        HashSet<Pair<Integer, Integer>> queue = new HashSet<>();
        dependentCell.forEach(cell -> {
            if (cell.hasOneVariant()) {
                Pair<Integer, Integer> newPairToSolve = new Pair<>(cell.getId(), cell.getVariant());
                queue.add(newPairToSolve);
            }
        });

        return queue;
    }
}
