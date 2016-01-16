package com.vh;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.vh.View.CellView;
import com.vh.model.Board;
import com.vh.model.Cell;
import com.vh.model.ConnectLine;

public class GameScreen implements Screen {

    private final ConnectLine connectLine;
    private final OrthographicCamera cam;
    private final CellView[][] boardView;
    private final Board board;

    private Texture cellTexture;
    private Texture player1Texture;
    private Texture player2Texture;
    private MainGame game;

    public GameScreen(MainGame game) {
        this.game = game;
        Gdx.gl.glClearColor(0.2f, 0.2f, 1, 1);


        D2GameComponent component = DaggerD2GameComponent.create();
        connectLine = component.provideGameLogic();
        board = connectLine.getBoard();
        boardView = new CellView[Board.WIDTH][Board.HEIGHT];
        initializeBoardView(new Vector2(0, 0), 10);

        cellTexture = new Texture("white_square_yellow.jpg");
        player1Texture = new Texture("red_circle.png");
        player2Texture = new Texture("blue_circle.png");

        cam = new OrthographicCamera(100, 100);
        cam.position.set(cam.viewportWidth / 2f, cam.viewportHeight / 2f, 0);
        cam.update();
    }

    private void initializeBoardView(Vector2 offset, int cellSize) {
        for (int i=0; i<Board.WIDTH; i++) {
            for (int j=0; j<Board.HEIGHT; j++) {
                boardView[i][j] = new CellView(i*cellSize, j*cellSize);
            }
        }
    }

    public void update(float deltaTime) {
        if (Gdx.input.justTouched()) {//TODO probably a nicer way of doing this (pressed & release)
            Vector2 input = getInput();
            for (int i=0; i<Board.WIDTH; i++) {
                for (int j=0; j<Board.HEIGHT; j++) { //Make this more efficient. Each row of the same column is the same
                    Rectangle rect = boardView[i][j].getRectangle();
                    if (rect.contains(input.x, input.y)) {
                        connectLine.placeToken(i);
                    }
                }
            }
        }
    }

    private Vector2 getInput() {
        Vector3 input = new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0);
        cam.unproject(input);///converts to "world" coordinates
        return new Vector2(input.x, input.y);
    }

    public void render(SpriteBatch batch) {
        batch.setProjectionMatrix(cam.combined);
        for (int i=0; i<Board.WIDTH; i++) {
            for (int j=0; j<Board.HEIGHT; j++) {
                Rectangle rect = boardView[i][j].getRectangle();
                batch.draw(cellTexture, rect.getX(), rect.getY(), 10, 10);

                if (board.getTokenAt(i, j) == Cell.PLAYER1) {
                    batch.draw(player1Texture, rect.getX(), rect.getY(), 10, 10);
                } else if (board.getTokenAt(i, j) == Cell.PLAYER2) {
                    batch.draw(player2Texture, rect.getX(), rect.getY(), 10, 10);
                }
            }
        }
    }

    @Override
    public void show() {

    }


    public void render(float delta) {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        game.batch.begin();
        update(delta);
        render(game.batch);
        game.batch.end();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
