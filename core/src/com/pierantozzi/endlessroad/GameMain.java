package com.pierantozzi.endlessroad;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

import scenes.EndlessRoad;
import utilities.AssetsLoader;

public class GameMain extends Game {

	private SpriteBatch batch;

	@Override
	public void create () {
		batch = new SpriteBatch();
		setScreen(new EndlessRoad(this));


	}

	@Override
	public void render ()
	{
		super.render();
	}

	@Override
	public void dispose () {
	}



	public SpriteBatch getBatch(){return batch;}
}

/**
 * Returns the Stage of the game
 */
	/*
	public Stage getStage(){return stage;}

	public SpriteBatch getBatch(){return (SpriteBatch)stage.getBatch();}
	*/
