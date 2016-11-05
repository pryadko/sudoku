package com.pryadko.algorithm;

import com.pryadko.domain.Board;
import com.pryadko.domain.Cell;
import javafx.util.Pair;
import org.springframework.stereotype.Service;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;
import java.util.stream.IntStream;

import static com.pryadko.domain.Board.SIZE;

@Service
public class LevelFirst implements Algorithm {

    @Override
    public Queue<Pair<Integer, Integer>> solve(Board board) {
        Queue<Pair<Integer, Integer>> queue = new ArrayDeque<>();

        IntStream.range(0, SIZE)
                .forEach(ind -> {
                    Set<Cell> dependencyCol = board.getDependencyCol(ind);
                    queue.addAll(getToQueUnicqCell(dependencyCol));
                    dependencyCol = board.getDependencyRow(ind);
                    queue.addAll(getToQueUnicqCell(dependencyCol));
                    dependencyCol = board.getDependencyBox(ind);
                    queue.addAll(getToQueUnicqCell(dependencyCol));
                });
        return queue;
    }


    private Queue<Pair<Integer, Integer>> getToQueUnicqCell(Set<Cell> dependencyCol) {
        Queue<Pair<Integer, Integer>> queue = new ArrayDeque<>();
        Set<Integer> ids = new HashSet<>();
        Set<Integer> unique = new HashSet<>();
        dependencyCol.forEach(cell -> {
            Set<Integer> allowNumbers = cell.getAllowNumbers();
            allowNumbers.forEach(integer -> {
                if (!ids.contains(integer)) {
                    unique.add(integer);
                } else {
                    unique.remove(integer);
                }
            });
            ids.addAll(allowNumbers);
        });
        unique
                .forEach(integer -> dependencyCol
                        .forEach(cell -> {
                            if (cell.getAllowNumbers().contains(integer)) {
                                queue.add(new Pair<>(cell.getId(), integer));
                            }
                        }));

        return queue;
    }

}
