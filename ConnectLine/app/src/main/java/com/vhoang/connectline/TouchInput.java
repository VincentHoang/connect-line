package com.vhoang.connectline;

import com.gameframework.Input;

import javax.inject.Inject;

public class TouchInput implements Input {

    @Inject
    public TouchInput() {

    }

    @Override
    public int getTouchX(int pointer) {
        return 0;
    }

    @Override
    public int getTouchY(int pointer) {
        return 0;
    }
}
