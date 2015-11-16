package com.flappydemo.game.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Array;

/**
 * Created by lbalmaceda on 11/15/15.
 */
public class Animation {
    private Array<TextureRegion> mFrames;
    private float mMaxFrameTime;
    private float mCurrentFrameTime;
    private int mFrameCount;
    private int mFrame;

    public Animation(Texture texture, int frameCount, float cycleTime) {
        mFrames = new Array<TextureRegion>();
        TextureRegion region = new TextureRegion(texture);
        int frameWidth = region.getRegionWidth() / frameCount;
        for (int i = 0; i < frameCount; i++) {
            mFrames.add(new TextureRegion(region, i * frameWidth, 0, frameWidth, region.getRegionHeight()));
        }
        mFrameCount = frameCount;
        mMaxFrameTime = cycleTime / frameCount;
        mFrame = 0;
    }

    public void update(float delta) {
        mCurrentFrameTime = mCurrentFrameTime + delta;
        if (mCurrentFrameTime > mMaxFrameTime) {
            mFrame++;
            mCurrentFrameTime = 0;
        }
        if (mFrame >= mFrameCount) {
            mFrame = 0;
        }
    }

    public TextureRegion getFrame() {
        return mFrames.get(mFrame);
    }
}
