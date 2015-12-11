package com.vhoang.connectline;

import com.gameframework.Audio;
import com.gameframework.FileIO;
import com.gameframework.Game;
import com.gameframework.Graphics;
import com.gameframework.Input;
import com.gameframework.Screen;
import com.vhoang.connectline.screen.ScreenType;

import java.util.Map;

import javax.inject.Inject;

public class MainGame implements Game {

    private final Input input;
    private final Screen currentScreen;

    @Inject
    public MainGame(Input input, Map<ScreenType, Screen> screens) {
        this.input = input;

        currentScreen = screens.get(ScreenType.GAME_SCREEN);
    }

    public void run() {
        currentScreen.update(0);
    }

    @Override
    public Input getInput() {
        return null;
    }

    @Override
    public FileIO getFileIO() {
        return null;
    }

    @Override
    public Graphics getGraphics() {
        return null;
    }

    @Override
    public Audio getAudio() {
        return null;
    }

    @Override
    public void setScreen(Screen screen) {

    }

    @Override
    public Screen getCurrentScreen() {
        return null;
    }

    @Override
    public Screen getStartScreen() {
        return null;
    }
}
