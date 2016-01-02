package com.vhoang.connectline.model;

import javax.inject.Inject;

public class ConnectLine {

    private final Turn turn;
    private Board board;

    @Inject
    public ConnectLine(Board board) {
        this.board = board;
        turn = Turn.PLAYER1;
    }

    public void placeToken(int column) {

    }

    public boolean canPlaceToken(int column) {
        return true;
    }

    private void checkWin() {

    }
}
