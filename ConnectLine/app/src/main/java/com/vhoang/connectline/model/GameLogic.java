package com.vhoang.connectline.model;

import javax.inject.Inject;

public class GameLogic {

    private final Turn turn;
    private BoardState boardState;

    @Inject
    public GameLogic(BoardState boardState) {
        this.boardState = boardState;
        turn = Turn.PLAYER1;
    }
}
