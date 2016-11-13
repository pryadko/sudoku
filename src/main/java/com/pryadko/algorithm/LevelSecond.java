package com.pryadko.algorithm;

import com.pryadko.domain.Board;
import com.pryadko.domain.Cell;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static com.pryadko.domain.Board.SIZE;

@Service
public class LevelSecond implements Algorithm {
    //todo need implement
// 1)remove triade and quadre
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
        clearNakedPair(dependencyRow);
        Set<Cell> dependencyCol = solved.getDependencyCol(ind);
        clearNakedPair(dependencyCol);
        Set<Cell> dependencyBox = solved.getDependencyBox(ind);
        clearNakedPair(dependencyBox);
    }

    private void clearNakedPair(Set<Cell> dependencyRow) {
        List<Cell> cells = dependencyRow.stream()
                .filter(cell -> cell.getCountVariants() == 2)
                .collect(Collectors.toList());
        if (cells.size() != 2) {
            return;
        }
        for (int i = 0; i < cells.size() - 1; i++) {
            if (cells.get(i).getAllowNumbers().equals(cells.get(i + 1).getAllowNumbers())) {
                Iterator<Integer> iterator = cells.get(i).getAllowNumbers().iterator();
                clearNakedPair(dependencyRow, cells, iterator.next(), iterator.next());
            }
        }
    }

    private void clearNakedPair(Set<Cell> dependies, List<Cell> cells, Integer one, Integer two) {
        dependies.stream()
                .filter(cell -> !cells.contains(cell))
                .forEach(cell -> {
                    cell.removeVariant(one);
                    cell.removeVariant(two);
                });
    }

}
