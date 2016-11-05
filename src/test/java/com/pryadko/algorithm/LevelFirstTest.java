package com.pryadko.algorithm;


import com.pryadko.domain.Board;
import com.pryadko.process.Loader;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.util.Arrays;

public class LevelFirstTest {
    private static final String EXPECTED =
            "*************\n" +
                    "*534*678*912*\n" +
                    "*672*195*348*\n" +
                    "*198*342*567*\n" +
                    "*************\n" +
                    "*859*761*423*\n" +
                    "*426*853*791*\n" +
                    "*713*924*856*\n" +
                    "*************\n" +
                    "*961*537*284*\n" +
                    "*287*419*635*\n" +
                    "*345*286*179*\n" +
                    "*************\n";
    private final Loader loader = new Loader();

    @Test
    public void shouldSolveLevelFirst() throws Exception {
        File file = new File("src/test/resources/input_level_1.txt");
        Board board = loader.loadBoard(file);
        Solver solver = new Solver(board, Arrays.asList(new LevelZero(), new LevelFirst()));

        Board actual = solver.solve();

        Assert.assertEquals(EXPECTED, actual.toString());
    }

}