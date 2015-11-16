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
    protected GameStateManager mGSM;

    public State(GameStateManager gsm) {
        mGSM = gsm;
        mCam = new OrthographicCamera();
        mMouse = new Vector3();
    }

    protected abstract void handleInput();

    protected abstract void update(float delta);

    protected abstract void render(SpriteBatch spriteBatch);

    protected abstract void dispose();
}
