package com.pryadko.algorithm;

import com.pryadko.domain.Board;
import com.pryadko.domain.Cell;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static com.pryadko.domain.Board.SIZE;

@Service
public class LevelSecond implements Algorithm {
    //todo need implement
// 2) more flexible find pair not only for size = 2, 3 or 4
// 3) increase delete availible variant if pair in one block
    @Override
    public Board solve(Board board) {
        Board solved = new Board(board);
        IntStream.range(0, SIZE)
                .forEach(ind -> resolveNakedPair(solved, ind));
        return solved;
    }

    private void resolveNakedPair(Board solved, int ind) {
        Set<Cell> dependencyRow = solved.getDependencyRow(ind);
        clearNaked(dependencyRow);
        Set<Cell> dependencyCol = solved.getDependencyCol(ind);
        clearNaked(dependencyCol);
        Set<Cell> dependencyBox = solved.getDependencyBox(ind);
        clearNaked(dependencyBox);
    }

    private void clearNaked(Set<Cell> dependencyCells) {
        Map<Set<Integer>, List<Cell>> mapDependentCells = dependencyCells.stream()
                .filter(Cell::isEmpty)
                .collect(Collectors.groupingBy(Cell::getAllowNumbers));

        mapDependentCells.forEach((keys, cells) -> {
            if (keys.size() == cells.size()) {
                clearNakedPair(dependencyCells, cells);
            }
        });
    }

    private void clearNakedPair(Set<Cell> decencies, List<Cell> cells) {
        decencies.stream()
                .filter(cell -> !cells.contains(cell))
                .forEach(cell -> cell.removeVariants(cells.get(0).getAllowNumbers()));
    }

}
