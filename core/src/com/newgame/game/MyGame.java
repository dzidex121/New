package com.newgame.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;


public class MyGame extends ApplicationAdapter implements InputProcessor {
	public static final int WIDTH = 720;
	public static final int HEIGHT = 1440;
	Player player;
	Button exit,new_game;
	boolean menu;
	SpriteBatch batch;
	Texture img,img_new_game,img_exit;
	OrthographicCamera camera;
	Assets assets;
	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("badlogic.jpg");
		Gdx.input.setInputProcessor(this);
		camera = new OrthographicCamera(Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
		menu = true;
		assets = new Assets();
		assets.load();
		assets.manager.finishLoading();
		if(assets.manager.update()) {
			loadData();
		}
	}

	@Override
	public void render () {
		update();
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		if(menu = true) {
			batch.begin();
			batch.draw(exit.getTexture(), exit.getX(), exit.getY());
			batch.draw(new_game.getTexture(), new_game.getX(), new_game.getY());
			batch.end();
		}
		if(menu = false){
			batch.begin();
			batch.draw(player.getTexture(), player.getX(), player.getY());
			batch.end();


		}
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		assets.dispose();
	}

	public void update(){
		camera.update();
	}

	private void loadData(){
		menu = true;
		img_new_game = assets.manager.get("button_new-game.jpg", Texture.class);
		img_exit = assets.manager.get("button_exit.jpg", Texture.class);
		player = new Player(assets.manager.get("car.png", Texture.class),0,0);
		// BUTTONY W MENU
		exit = new Button(img_exit,410,600);
		new_game = new Button(img_new_game ,410,800);
	}

	@Override
	public boolean keyDown(int keycode) {
		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		return false;
	}

	@Override
	public boolean keyTyped(char character) {
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		System.out.println("X i Y: " + screenX + " ; " + (Gdx.graphics.getHeight() - screenY));
		if(screenX>exit.getX() && screenX<exit.getX()+exit.getTexture().getWidth() && (Gdx.graphics.getHeight() - screenY)>exit.getY()
				&& (Gdx.graphics.getHeight() - screenY)< exit.getY() + exit.getTexture().getHeight())
		{
			menu = false;
			Gdx.app.exit();
		}
		if(screenX>new_game.getX() && screenX<new_game.getX()+new_game.getTexture().getWidth() && (Gdx.graphics.getHeight() - screenY)>new_game.getY()
				&& (Gdx.graphics.getHeight() - screenY)< new_game.getY() + new_game.getTexture().getHeight()){
			menu = false;
		}

		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		return false;
	}
}
