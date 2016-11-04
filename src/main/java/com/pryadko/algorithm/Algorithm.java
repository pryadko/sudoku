package com.pryadko.algorithm;

import com.pryadko.domain.Cell;
import javafx.util.Pair;

import java.util.Collection;
import java.util.Set;

public interface Algorithm {

    Collection<? extends Pair<Integer, Integer>> solve(Set<Cell> dependentCell);
}
