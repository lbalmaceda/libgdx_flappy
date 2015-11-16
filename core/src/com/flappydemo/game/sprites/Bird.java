package com.flappydemo.game.sprites;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;

/**
 * Created by lbalmaceda on 11/15/15.
 */
public class Bird {
    private static final int GRAVITY = -15;
    private static final int MOVEMENT = 100;
    private final Texture mBirdTexture;

    private Vector3 mPosition;
    private Vector3 mVelocity;
    private Rectangle mBounds;

    private Sound mSound;
    private Animation mAnimation;

    public Bird(int x, int y) {
        mPosition = new Vector3(x, y, 0);
        mVelocity = new Vector3(0, 0, 0);
        mBirdTexture = new Texture("birdanimation.png");
        mAnimation = new Animation(mBirdTexture, 3, 0.5f);
        mBounds = new Rectangle(x, y, mBirdTexture.getWidth() / 3, mBirdTexture.getHeight());
        mSound = Gdx.audio.newSound(Gdx.files.internal("sfx_wing.ogg"));
    }

    public void update(float delta) {
        mAnimation.update(delta);
        if (mPosition.y > 0) {
            mVelocity.add(0, GRAVITY, 0);
        }

        mVelocity.scl(delta);   //scale to multiple for the time that has passed
        mPosition.add(MOVEMENT * delta, mVelocity.y, 0);

        if (mPosition.y < 0) {
            mPosition.y = 0;
        }

        mBounds.setPosition(mPosition.x, mPosition.y);
        mVelocity.scl(1 / delta); //scale back so next call to update method, will scale things fine
    }

    public Vector3 getPosition() {
        return mPosition;
    }

    public TextureRegion getBirdTexture() {
        return mAnimation.getFrame();
    }

    public void jump() {
        mVelocity.y = 250;
        mSound.play(0.5f);
    }

    public Rectangle getBounds() {
        return mBounds;
    }

    public void dispose() {
        mBirdTexture.dispose();
        mSound.dispose();
    }
}
