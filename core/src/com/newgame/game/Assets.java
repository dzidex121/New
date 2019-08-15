package com.newgame.game;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.Disposable;

public class Assets implements Disposable {

    public final AssetManager manager  = new AssetManager();

    public void load(){
        manager.load("button_new-game.jpg", Texture.class);
        manager.load("button_exit.jpg", Texture.class);
        manager.load("car.png", Texture.class);
        //System.outprinsadad
    }

    @Override
    public void dispose(){
        manager.dispose();
    }
}
