package com.pryadko.algorithm;


import com.pryadko.domain.Board;
import com.pryadko.process.Loader;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import java.io.File;
import java.util.Arrays;

public class LevelSecondTest {
    private static final String EXPECTED =
            "*************\n" +
                    "*154*893*726*\n" +
                    "*976*412*853*\n" +
                    "*823*765*491*\n" +
                    "*************\n" +
                    "*285*147*369*\n" +
                    "*749*536*182*\n" +
                    "*361*289*574*\n" +
                    "*************\n" +
                    "*698*354*217*\n" +
                    "*537*921*648*\n" +
                    "*412*678*935*\n" +
                    "*************\n";

    private static final String EXPECTED_YOUTUBE =
            "*************\n" +
                    "*814*329*675*\n" +
                    "*576*481*923*\n" +
                    "*932*657*481*\n" +
                    "*************\n" +
                    "*159*273*864*\n" +
                    "*647*198*532*\n" +
                    "*283*546*719*\n" +
                    "*************\n" +
                    "*728*934*156*\n" +
                    "*391*865*247*\n" +
                    "*465*712*398*\n" +
                    "*************\n";
    private final Loader loader = new Loader();

    @Test
    @Ignore
    public void shouldSolveLevelSecond() throws Exception {
        File file = new File("src/test/resources/input_level_2.txt");
        Board board = loader.loadBoard(file);
        Solver solver = new Solver(Arrays.asList(new LevelZero(), new LevelFirst()));

        Board actual = solver.solve(board);

        Assert.assertEquals(EXPECTED, actual.toString());
    }

    @Test
    public void shouldSolveYoutubeSudoku() throws Exception {
        File file = new File("src/test/resources/input_level_youtube.txt");
        Board board = loader.loadBoard(file);
        Solver solver = new Solver(Arrays.asList(new LevelZero(), new LevelFirst()));

        Board actual = solver.solve(board);

        Assert.assertEquals(EXPECTED_YOUTUBE, actual.toString());
    }

    @Test
    public void shouldSolveTutorialSudoku() throws Exception {
        File file = new File("src/test/resources/input_level_2_tutorial.txt");
        Board board = loader.loadBoard(file);
        Solver solver = new Solver(Arrays.asList(new LevelZero(), new LevelFirst()));

        Board actual = solver.solve(board);

        Assert.assertTrue(actual.isSolved());
    }

}