package com.pryadko.algorithm;

import com.pryadko.domain.Board;
import com.pryadko.domain.Cell;
import javafx.util.Pair;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;

import static com.pryadko.domain.Board.SIZE;

@Service
public class LevelFirst implements Algorithm {

    @Override
    public Board solve(Board board) {
        Board solved = new Board(board);
        IntStream.range(0, SIZE)
                .forEach(ind -> {
                    Set<Cell> dependencyCol = board.getDependencyCol(ind);
                    solved.setValues(getToQueUnicqCell(dependencyCol));
                    dependencyCol = board.getDependencyRow(ind);
                    solved.setValues(getToQueUnicqCell(dependencyCol));
                    dependencyCol = board.getDependencyBox(ind);
                    solved.setValues(getToQueUnicqCell(dependencyCol));
                });
        return solved;
    }


    private List<Pair<Integer, Integer>> getToQueUnicqCell(Set<Cell> dependencyCol) {
        List<Pair<Integer, Integer>> values = new ArrayList<>();
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
                                values.add(new Pair<>(cell.getId(), integer));
                            }
                        }));

        return values;
    }

}
