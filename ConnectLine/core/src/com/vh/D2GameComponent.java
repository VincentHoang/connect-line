package com.vh;

import com.vh.model.ConnectLine;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {GameModule.class})
public interface D2GameComponent {
    ConnectLine provideGameLogic();
}
