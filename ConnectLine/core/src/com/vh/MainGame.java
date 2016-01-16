package com.vh;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MainGame extends Game {
	SpriteBatch batch;

	@Override
	public void create () {
		batch = new SpriteBatch();
		setScreen(new GameScreen(this));
	}

	@Override
	public void render () {
		super.render();
	}
	//TODO using viewports, keeping the ratio the same.
}
