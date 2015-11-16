package com.flappydemo.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.flappydemo.game.FlappyDemo;

/**
 * Created by lbalmaceda on 11/15/15.
 */
public class MenuState extends State {
    private Texture mBackground;
    private Texture mPlayButton;

    public MenuState(GameStateManager manager) {
        super(manager);
        mBackground = new Texture("bg.png");
        mPlayButton = new Texture("playBtn.png");
        mCam.setToOrtho(false, FlappyDemo.WIDTH / 2, FlappyDemo.HEIGHT / 2);
    }

    @Override
    protected void handleInput() {
        if (Gdx.input.justTouched()) {
            mGSM.set(new PlayState(mGSM));
        }
    }

    @Override
    protected void update(float delta) {
        handleInput();
    }

    @Override
    protected void render(SpriteBatch spriteBatch) {
        spriteBatch.setProjectionMatrix(mCam.combined);
        spriteBatch.begin();
        spriteBatch.draw(mBackground, 0, 0);    //bottom left corner
        spriteBatch.draw(mPlayButton, mCam.position.x - mPlayButton.getWidth() / 2, mCam.position.y);
        spriteBatch.end();
    }

    @Override
    protected void dispose() {
        mBackground.dispose();
        mPlayButton.dispose();
        System.out.println("Menu State Disposed");
    }
}
