package com.pryadko.algorithm;


import com.pryadko.domain.Board;
import com.pryadko.domain.Cell;
import com.pryadko.process.Loader;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import java.io.File;
import java.util.Arrays;
import java.util.stream.IntStream;

import static com.pryadko.domain.Board.SIZE;

public class LevelThirdTest {

    private final Loader loader = new Loader();
    private static final String EXPECTED =
            "*************\n" +
                    "*951*672*438*\n" +
                    "*687*543*192*\n" +
                    "*432*819*657*\n" +
                    "*************\n" +
                    "*245*398*761*\n" +
                    "*173*465*289*\n" +
                    "*896*721*345*\n" +
                    "*************\n" +
                    "*768*254*913*\n" +
                    "*514*937*826*\n" +
                    "*329*186*574*\n" +
                    "*************\n";

    @Test
    @Ignore("It should be 'x-wing'")
    public void shouldSolveLevelThird() throws Exception {
        File file = new File("src/test/resources/input_level_3.txt");
        Board board = loader.loadBoard(file);
        Solver solver = new Solver(Arrays.asList(new LevelZero(), new LevelFirst(), new LevelSecond()));

        Board actual = solver.solve(board);
        printDebugInfo(actual);

        Assert.assertEquals(EXPECTED, actual.toString());
    }

    private void printDebugInfo(Board board) {
        IntStream.range(0, SIZE)
                .forEach(i -> {
                    System.out.println("------------------");
                    board.getDependencyBox(i)
                            .stream()
                            .filter(Cell::isEmpty)
                            .forEach(cell -> System.out.println(cell.getId() + " " + cell.getAllowNumbers()));
                });

        System.out.println("===============================");
        IntStream.range(0, SIZE)
                .forEach(i -> {
                    System.out.println("--------" + i + "---------");
                    board.getDependencyCol(i)
                            .stream()
                            .filter(Cell::isEmpty)
                            .forEach(cell -> System.out.println(cell.getId() + " " + cell.getAllowNumbers()));
                });

        System.out.println("===============================");
        IntStream.range(0, SIZE)
                .forEach(i -> {
                    System.out.println("--------" + i + "---------");
                    board.getDependencyRow(i)
                            .stream()
                            .filter(Cell::isEmpty)
                            .forEach(cell -> System.out.println(cell.getId() + " " + cell.getAllowNumbers()));
                });
    }


}