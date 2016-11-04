package com.pryadko.algorithm;

import com.pryadko.domain.Board;
import com.pryadko.process.Loader;
import org.junit.Assert;
import org.junit.Test;

public class LevelZeroTest {
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
    public void shouldSolveLevelZero() throws Exception {
        Board board = loader.loadBoard("src/test/resources/input_level_0.txt");
        Algorithm algorithm = new LevelZero(board);

        Board actual = algorithm.solve();

        Assert.assertEquals(EXPECTED, actual.toString());
    }

}