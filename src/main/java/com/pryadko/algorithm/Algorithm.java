package com.pryadko.algorithm;

import com.pryadko.domain.Board;
import javafx.util.Pair;

import java.util.Queue;

public interface Algorithm {

    Queue<Pair<Integer, Integer>> solve(Board board);
}
