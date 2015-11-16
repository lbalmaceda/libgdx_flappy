package com.flappydemo.game.states;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;

/**
 * Created by lbalmaceda on 11/15/15.
 */
public abstract class State {
    protected OrthographicCamera mCam;
    protected Vector3 mMouse;
    protected GameStateManager mManager;

    public State(GameStateManager manager) {
        mManager = manager;
        mCam = new OrthographicCamera();
        mMouse = new Vector3();


    }

    protected abstract void handleInput();
    protected abstract void update(float delta);
    protected abstract void render(SpriteBatch spriteBatch);
    protected abstract void dispose();
}
