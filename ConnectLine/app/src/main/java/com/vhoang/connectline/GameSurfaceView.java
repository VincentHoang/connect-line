package com.vhoang.connectline;

import android.opengl.GLSurfaceView;

import com.gameframework.Game;
import com.vhoang.DaggerD2GameComponent;

public class GameSurfaceView extends GLSurfaceView {

    private final Renderer gameRenderer;
    private final Game game;

    public GameSurfaceView(MainActivity context) {
        super(context);

        setEGLContextClientVersion(2);

        gameRenderer = new GameRenderer();

        setRenderer(gameRenderer);

        setRenderMode(GLSurfaceView.RENDERMODE_WHEN_DIRTY); //requestRender() to redraw

        game = DaggerD2GameComponent.create().provideGame();
    }
}
