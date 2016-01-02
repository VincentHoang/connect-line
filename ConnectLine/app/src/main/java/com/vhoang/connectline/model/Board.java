package com.vhoang.connectline.model;

import javax.inject.Inject;

public class Board {

    public static final int GRID_SIZE = 4;

    Cell[][] boardState;

    @Inject
    public Board() {
        boardState = new Cell[GRID_SIZE][GRID_SIZE];

        initializeBoard();
    }

    private void initializeBoard() {
        for (int x=0; x<GRID_SIZE; x++) {
            for (int y=0; y<GRID_SIZE; y++) {
                boardState[x][y] = Cell.NEUTRAL;
            }
        }
    }

    public void placeToken(Cell cell, int x, int y) {
        boardState[x][y] = cell;
    }

    public Cell getTokenAt(int x, int y) {
        return boardState[x][y];
    }
}
