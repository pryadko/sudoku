package com.pryadko.algorithm;

import com.pryadko.domain.Cell;
import javafx.util.Pair;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Service
public class LevelDummy implements Algorithm {
    @Override
    public Collection<? extends Pair<Integer, Integer>> solve(Set<Cell> dependentCell) {
        return new HashSet<>();
    }
}
