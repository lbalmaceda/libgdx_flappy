package com.flappydemo.game.states;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.flappydemo.game.FlappyDemo;
import com.flappydemo.game.sprites.Bird;

/**
 * Created by lbalmaceda on 11/15/15.
 */
public class PlayState extends State {

    private Bird mBird;

    public PlayState(GameStateManager manager) {
        super(manager);
        mBird = new Bird(50, 350);
        mCam.setToOrtho(false, FlappyDemo.WIDTH / 2, FlappyDemo.HEIGHT / 2);
    }

    @Override
    protected void handleInput() {
    }

    @Override
    protected void update(float delta) {
        handleInput();
        mBird.update(delta);
    }

    @Override
    protected void render(SpriteBatch spriteBatch) {
        spriteBatch.setProjectionMatrix(mCam.combined);
        spriteBatch.begin();
        spriteBatch.draw(mBird.getTexture(), mBird.getPosition().x, mBird.getPosition().y);
        spriteBatch.end();
    }

    @Override
    protected void dispose() {
    }
}
