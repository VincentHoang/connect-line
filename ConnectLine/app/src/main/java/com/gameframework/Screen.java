package com.gameframework;

public interface Screen {
    void update(float deltaTime);
    void present(float deltaTime);
    void pause();
    void resume();
    void dispose();
}
