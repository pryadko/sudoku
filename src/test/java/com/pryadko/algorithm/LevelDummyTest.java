package com.pryadko.algorithm;

import com.pryadko.domain.Board;
import com.pryadko.process.Loader;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.util.ArrayList;

public class LevelDummyTest {
    private static final String EXPECTED =
            "*************\n" +
                    "*53 * 7 *   *\n" +
                    "*6  *195*   *\n" +
                    "* 98*   * 6 *\n" +
                    "*************\n" +
                    "*8  * 6 *  3*\n" +
                    "*4  *8 3*  1*\n" +
                    "*7  * 2 *  6*\n" +
                    "*************\n" +
                    "* 6 *   *28 *\n" +
                    "*   *419*  5*\n" +
                    "*   * 8 * 79*\n" +
                    "*************\n";
    private final Loader loader = new Loader();

    @Test
    public void shouldSolveNothing() throws Exception {
        File file = new File("src/test/resources/input_level_0.txt");
        Board board = loader.loadBoard(file);
        Solver solver = new Solver(new ArrayList<>());

        Board actual = solver.solve(board);

        Assert.assertEquals(EXPECTED, actual.toString());
    }
}