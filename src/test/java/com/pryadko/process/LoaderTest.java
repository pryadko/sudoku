package com.pryadko.process;

import com.pryadko.algorithm.Algorithm;
import com.pryadko.algorithm.LevelDummy;
import com.pryadko.algorithm.LevelZero;
import com.pryadko.domain.Board;
import org.junit.Assert;
import org.junit.Test;

public class LoaderTest {
    private Loader loader = new Loader();
    private Algorithm levelDummy = new LevelDummy();
    private Algorithm levelZero = new LevelZero();

    public static final String EXPECTED = "*************\n" +
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

    @Test
    public void shouldLoadBoardFromFile() throws Exception {
        Board board = new Board(levelDummy);

        board.addAllToQueue(loader.loadQueue("src/test/resources/input.txt"));

        Assert.assertEquals(EXPECTED, board.toString());
    }

    @Test
    public void shouldSolveLevel0() throws Exception {
        Board board = new Board(levelZero);

        board.addAllToQueue(loader.loadQueue("src/test/resources/input_level_0.txt"));

        Assert.assertEquals(EXPECTED, board.toString());
    }
}