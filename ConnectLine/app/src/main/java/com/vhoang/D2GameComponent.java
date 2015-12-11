package com.vhoang;

import com.gameframework.Game;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {GameModule.class})
public interface D2GameComponent {
    Game provideGame();
}
