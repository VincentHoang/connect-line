package com.vhoang.connectline.model;

import javax.inject.Inject;

public class BoardState {

    Cell[][] board;

    @Inject
    public BoardState() {
        board = new Cell[4][4];
    }

    public Cell getTokenAt(int i) {
        return Cell.NEUTRAL;
    }
}
