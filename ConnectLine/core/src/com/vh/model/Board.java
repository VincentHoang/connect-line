package com.vh.model;

import javax.inject.Inject;

public class Board {

    public static final int HEIGHT = 6;
    public static final int WIDTH = 7;

    Cell[][] boardState;

    @Inject
    public Board() {
        boardState = new Cell[WIDTH][HEIGHT];

        initializeBoard();
    }

    private void initializeBoard() {
        for (int x=0; x<WIDTH; x++) {
            for (int y=0; y< HEIGHT; y++) {
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
