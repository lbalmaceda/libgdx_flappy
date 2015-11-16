package com.flappydemo.game.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector3;

/**
 * Created by lbalmaceda on 11/15/15.
 */
public class Bird {
    private static final int GRAVITY = -15;

    private Vector3 mPosition;
    private Vector3 mVelocity;
    private Texture mTexture;

    public Bird(int x, int y) {
        mPosition = new Vector3(x, y, 0);
        mVelocity = new Vector3(0, 0, 0);
        mTexture = new Texture("bird.png");
    }

    public void update(float delta) {
        mVelocity.add(0, GRAVITY, 0);

        mVelocity.scl(delta);   //scale to multiple for the time that has passed
        mPosition.add(0, mVelocity.y, 0);

        mVelocity.scl(1 / delta); //scale back so next call to update method, will scale things fine
    }

    public Vector3 getPosition() {
        return mPosition;
    }

    public void setPosition(Vector3 position) {
        mPosition = position;
    }

    public Texture getTexture() {
        return mTexture;
    }

    public void setTexture(Texture texture) {
        mTexture = texture;
    }
}