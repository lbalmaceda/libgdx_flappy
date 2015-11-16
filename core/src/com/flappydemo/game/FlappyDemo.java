package com.flappydemo.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.flappydemo.game.states.GameStateManager;
import com.flappydemo.game.states.MenuState;

public class FlappyDemo extends ApplicationAdapter {

    public static final int WIDTH = 480;
    public static final int HEIGHT = 800;
    public static final String TITLE = "FlappyDemo";

    private GameStateManager mGSM;
    SpriteBatch batch;
    Texture img;

    @Override
    public void create() {
        batch = new SpriteBatch();
        mGSM = new GameStateManager();

        Gdx.gl.glClearColor(1, 0, 0, 1);    //wipe the screen
        mGSM.push(new MenuState(mGSM));
    }

    @Override
    public void render() {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        mGSM.update(Gdx.graphics.getDeltaTime());
        mGSM.render(batch);
    }
}
