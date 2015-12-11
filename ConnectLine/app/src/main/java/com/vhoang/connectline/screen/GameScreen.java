package com.vhoang.connectline.screen;

import com.gameframework.Screen;
import com.vhoang.connectline.model.GameLogic;

import javax.inject.Inject;

public class GameScreen implements Screen {

    private GameLogic gameLog;

    @Inject
    public GameScreen(GameLogic gameLog) {
        this.gameLog = gameLog;
    }

    @Override
    public void update(float deltaTime) {

    }

    @Override
    public void present(float deltaTime) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void dispose() {

    }
}
