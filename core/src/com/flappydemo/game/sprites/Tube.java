package com.flappydemo.game.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

import java.util.Random;

/**
 * Created by lbalmaceda on 11/15/15.
 */
public class Tube {
    public static final int TUBE_WIDTH = 52;

    private static final int FLUCTUATION = 130;
    private static final int TUBE_GAP = 100;
    private static final int LOWEST_OPENING = 120;

    private Texture mTopTube;
    private Texture mBottomTube;
    private Rectangle mBoundsTop;
    private Rectangle mBoundsBot;

    private Vector2 mPosTopTube, mPosBotTube;
    private Random mRand;

    public Tube(float x) {
        mTopTube = new Texture("topTube.png");
        mBottomTube = new Texture("bottomTube.png");
        mRand = new Random();
        mPosTopTube = new Vector2(x, mRand.nextInt(FLUCTUATION) + TUBE_GAP + LOWEST_OPENING);
        mPosBotTube = new Vector2(x, mPosTopTube.y - TUBE_GAP - mBottomTube.getHeight());
        mBoundsTop = new Rectangle(mPosTopTube.x, mPosTopTube.y, mTopTube.getWidth(), mTopTube.getHeight());
        mBoundsBot = new Rectangle(mPosBotTube.x, mPosBotTube.y, mBottomTube.getWidth(), mBottomTube.getHeight());
    }

    public Texture getTopTube() {
        return mTopTube;
    }

    public Texture getBottomTube() {
        return mBottomTube;
    }

    public Vector2 getPosTopTube() {
        return mPosTopTube;
    }

    public Vector2 getPosBotTube() {
        return mPosBotTube;
    }

    public void reposition(float x) {
        mPosTopTube.set(x, mRand.nextInt(FLUCTUATION) + TUBE_GAP + LOWEST_OPENING);
        mPosBotTube.set(x, mPosTopTube.y - TUBE_GAP - mBottomTube.getHeight());
        mBoundsTop.setPosition(mPosTopTube.x, mPosTopTube.y);
        mBoundsBot.setPosition(mPosBotTube.x, mPosBotTube.y);
    }

    public boolean collides(Rectangle player) {
        return player.overlaps(mBoundsTop) || player.overlaps(mBoundsBot);
    }

    public void dispose() {
        mTopTube.dispose();
        mBottomTube.dispose();
    }
}
