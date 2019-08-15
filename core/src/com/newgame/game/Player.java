package com.newgame.game;

import com.badlogic.gdx.graphics.Texture;

public class Player {
    int x;
    int y;
    Texture texture;

    public Player(Texture texture, int x, int y){
        this.x = x;
        this.y = y;
        this.texture = texture;
    }
    public Texture getTexture(){
        return texture;
    }
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
}
