package com.flappydemo.game.states;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created by lbalmaceda on 11/15/15.
 */
public class PlayState extends State {

    private Texture mBird;

    public PlayState(GameStateManager manager) {
        super(manager);
        mBird = new Texture("bird.png");
    }

    @Override
    protected void handleInput() {
    }

    @Override
    protected void update(float delta) {

    }

    @Override
    protected void render(SpriteBatch spriteBatch) {
        spriteBatch.begin();
        spriteBatch.draw(mBird, 50, 50);
        spriteBatch.end();
    }

    @Override
    protected void dispose() {
        mBird.dispose();
    }
}
