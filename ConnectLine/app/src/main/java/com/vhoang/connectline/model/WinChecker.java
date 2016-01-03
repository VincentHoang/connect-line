package com.vhoang.connectline.model;

import javax.inject.Inject;

public class WinChecker {

    private final Board board;

    @Inject
    public WinChecker(Board board) {
        //Either check whole board, or check board around last placed token
        this.board = board;
    }
}
