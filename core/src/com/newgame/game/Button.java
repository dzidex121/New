package com.newgame.game;

import com.badlogic.gdx.graphics.Texture;

public class Button {
    int x;
    int y;
    Texture texture;

    public Button(Texture texture, int x, int y){
        this.x = x;
        this.y = y;
        this.texture = texture;
    }
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
    public Texture getTexture(){
        return texture;
    }
}
