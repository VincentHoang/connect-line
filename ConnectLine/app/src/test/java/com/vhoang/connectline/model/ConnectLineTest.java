package com.vhoang.connectline.model;

import org.junit.Before;

public class ConnectLineTest {

    ConnectLine connectLine;

    Board board;

    @Before
    public void setup() {
        board = new Board();

        connectLine = new ConnectLine(board);
    }


}