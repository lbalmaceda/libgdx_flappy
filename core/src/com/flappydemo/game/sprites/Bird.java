package com.flappydemo.game.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;

/**
 * Created by lbalmaceda on 11/15/15.
 */
public class Bird {
    private static final int GRAVITY = -15;
    private static final int MOVEMENT = 100;

    private Vector3 mPosition;
    private Vector3 mVelocity;
    private Texture mTexture;
    private Rectangle mBounds;

    public Bird(int x, int y) {
        mPosition = new Vector3(x, y, 0);
        mVelocity = new Vector3(0, 0, 0);
        mTexture = new Texture("bird.png");
        mBounds = new Rectangle(x, y, mTexture.getWidth(), mTexture.getHeight());
    }

    public void update(float delta) {
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

    public Texture getTexture() {
        return mTexture;
    }

    public void jump() {
        mVelocity.y = 250;
    }

    public Rectangle getBounds() {
        return mBounds;
    }

    public void dispose() {
        mTexture.dispose();
    }
}
