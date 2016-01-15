package com.vh;

import com.vh.model.Board;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class GameModule {

    @Singleton @Provides
    Board provideBoard() {
        return new Board();
    }
}
