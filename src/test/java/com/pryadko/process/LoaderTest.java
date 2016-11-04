package com.pryadko.process;

import com.pryadko.domain.Board;
import org.junit.Assert;
import org.junit.Test;

public class LoaderTest {

    @Test
    public void shouldLoadBoardFromFole() throws Exception {
        Loader loader = new Loader();
        Board board = loader.loadBoard("src/test/resources/input.txt");

        Assert.assertEquals(
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
                        "*************\n",
                board.toString());
    }
}