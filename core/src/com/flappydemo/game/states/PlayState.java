package com.flappydemo.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.flappydemo.game.FlappyDemo;
import com.flappydemo.game.sprites.Bird;

/**
 * Created by lbalmaceda on 11/15/15.
 */
public class PlayState extends State {

    private Bird mBird;
    private Texture mBackground;

    public PlayState(GameStateManager manager) {
        super(manager);
        mBird = new Bird(50, 350);
        mBackground = new Texture("bg.png");
        mCam.setToOrtho(false, FlappyDemo.WIDTH / 2, FlappyDemo.HEIGHT / 2);
    }

    @Override
    protected void handleInput() {
        if (Gdx.input.justTouched()) {
            mBird.jump();
        }
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
        spriteBatch.draw(mBackground, mCam.position.x - (mCam.viewportWidth / 2), 0);
        spriteBatch.draw(mBird.getTexture(), mBird.getPosition().x, mBird.getPosition().y);
        spriteBatch.end();
    }

    @Override
    protected void dispose() {
    }
}
