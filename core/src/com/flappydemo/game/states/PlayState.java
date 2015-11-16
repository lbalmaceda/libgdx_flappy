package com.flappydemo.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.flappydemo.game.FlappyDemo;
import com.flappydemo.game.sprites.Bird;
import com.flappydemo.game.sprites.Tube;

/**
 * Created by lbalmaceda on 11/15/15.
 */
public class PlayState extends State {
    private static final int TUBE_SPACING = 125;
    private static final int TUBE_COUNT = 4;
    private static final int GROUND_Y_OFFSET = -50;

    private Bird mBird;
    private Texture mBackground;
    private Tube mTube;
    private Texture mGround;
    private Vector2 mGroundPosition1;
    private Vector2 mGroundPosition2;

    private Array<Tube> mTubes;

    public PlayState(GameStateManager manager) {
        super(manager);
        mBird = new Bird(50, 350);
        mBackground = new Texture("bg.png");
        mTube = new Tube(100);

        mGround = new Texture("ground.png");
        mGroundPosition1 = new Vector2(mCam.position.x - mCam.viewportWidth / 2, GROUND_Y_OFFSET);
        mGroundPosition2 = new Vector2((mCam.position.x - mCam.viewportWidth / 2) + mGround.getWidth(), GROUND_Y_OFFSET);

        mTubes = new Array<Tube>();
        for (int i = 1; i <= TUBE_COUNT; i++) {
            mTubes.add(new Tube(i * (TUBE_SPACING + Tube.TUBE_WIDTH)));
        }

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
        mCam.position.x = mBird.getPosition().x + 80;
        updateGround();

        //check for collisions
        for (Tube tube : mTubes) {
            //camera was on the middle of the screen. Move to the 0,0 and check if the tube its gone
            if (mCam.position.x - (mCam.viewportWidth / 2) > tube.getPosTopTube().x + tube.getTopTube().getWidth()) {
                tube.reposition(tube.getPosTopTube().x + ((Tube.TUBE_WIDTH + TUBE_SPACING) * TUBE_COUNT));
            }

            if (tube.collides(mBird.getBounds())) {
                mGSM.set(new PlayState(mGSM));
            }
        }

        if (mBird.getPosition().y <= mGround.getHeight() + GROUND_Y_OFFSET) {
            mGSM.set(new PlayState(mGSM));
        }

        mCam.update();
    }

    @Override
    protected void render(SpriteBatch spriteBatch) {
        spriteBatch.setProjectionMatrix(mCam.combined);
        spriteBatch.begin();
        spriteBatch.draw(mBackground, mCam.position.x - (mCam.viewportWidth / 2), 0);
        spriteBatch.draw(mBird.getTexture(), mBird.getPosition().x, mBird.getPosition().y);
        for (Tube tube : mTubes) {
            spriteBatch.draw(tube.getTopTube(), tube.getPosTopTube().x, tube.getPosTopTube().y);
            spriteBatch.draw(tube.getBottomTube(), tube.getPosBotTube().x, tube.getPosBotTube().y);
        }
        spriteBatch.draw(mGround, mGroundPosition1.x, mGroundPosition1.y);
        spriteBatch.draw(mGround, mGroundPosition2.x, mGroundPosition2.y);
        spriteBatch.end();
    }

    @Override
    protected void dispose() {
        mBackground.dispose();
        mBird.dispose();
        mGround.dispose();
        for (int i = 0; i < mTubes.size; i++) {
            mTubes.get(i).dispose();
        }
        System.out.println("Play State Disposed");
    }

    private void updateGround() {
        if (mCam.position.x - mCam.viewportWidth / 2 > mGroundPosition1.x + mGround.getWidth()) {
            mGroundPosition1.add(mGround.getWidth() * 2, 0);
        }
        if (mCam.position.x - mCam.viewportWidth / 2 > mGroundPosition2.x + mGround.getWidth()) {
            mGroundPosition2.add(mGround.getWidth() * 2, 0);
        }
    }
}
