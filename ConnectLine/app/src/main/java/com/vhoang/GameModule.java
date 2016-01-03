package com.vhoang;

import com.gameframework.Game;
import com.gameframework.Input;
import com.gameframework.Screen;
import com.google.common.collect.Maps;
import com.vhoang.connectline.MainGame;
import com.vhoang.connectline.model.Board;
import com.vhoang.connectline.screen.ScreenType;
import com.vhoang.connectline.TouchInput;
import com.vhoang.connectline.screen.GameScreen;

import java.util.Map;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class GameModule {

    @Singleton @Provides
    Game provideGame(MainGame mainGame) {
        return mainGame;
    }

    @Singleton @Provides
    Input provideInput(TouchInput touchInput) {
        return touchInput;
    }

    @Singleton @Provides
    Board provideBoard() {
        return new Board();
    }

    @Provides @Singleton
    Map<ScreenType, Screen> provideScreens(GameScreen gameScreen) {
        Map<ScreenType, Screen> screens = Maps.newHashMap();
        screens.put(ScreenType.GAME_SCREEN, gameScreen);
        return screens;
    }
}
