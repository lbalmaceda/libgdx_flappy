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
        spriteBatch.begin();
        spriteBatch.draw(mBackground, 0, 0, FlappyDemo.WIDTH, FlappyDemo.HEIGHT);    //bottom left corner
        spriteBatch.draw(mPlayButton, (FlappyDemo.WIDTH / 2) - (mPlayButton.getWidth() / 2), FlappyDemo.HEIGHT / 2);
        spriteBatch.end();
    }

    @Override
    protected void dispose() {
        mBackground.dispose();
        mPlayButton.dispose();
    }
}
