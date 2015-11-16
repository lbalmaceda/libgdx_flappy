package com.flappydemo.game.states;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.Stack;

/**
 * Created by lbalmaceda on 11/15/15.
 */
public class GameStateManager {
    private Stack<State> mStates;

    public GameStateManager() {
        mStates = new Stack<State>();
    }

    public void push(State state){
        mStates.push(state);
    }

    public void pop(){
        mStates.pop().dispose();
    }

    public void set(State state){
        mStates.pop();
        mStates.push(state);
    }

    public void update(float delta){
        mStates.peek().update(delta);
    }

    public void render(SpriteBatch spriteBatch){
        mStates.peek().render(spriteBatch);
    }
}
