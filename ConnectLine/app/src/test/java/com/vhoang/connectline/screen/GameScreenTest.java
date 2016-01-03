package com.vhoang.connectline.screen;

import com.vhoang.connectline.model.ConnectLine;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

public class GameScreenTest {

    GameScreen gameScreen;

    @Mock ConnectLine connectLine;

    @Before
    public void setup() {
        gameScreen = new GameScreen(connectLine);
    }

    @Test
    public void when_there_is_an_input_on_the_board_then_place_token_to_corrent_cell() {

    }
}