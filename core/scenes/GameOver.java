package scenes;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.SpriteDrawable;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.ilcuriosone.games.endlessroad.EndlessRoad;

import utilities.AssetsLoader;
import utilities.GameConstants;

/**
 * This class represents the game over screen
 * @author Paolo Pierantozzi
 */
public class GameOver implements Screen
{
	private EndlessRoad game;
	private AssetsLoader loader;
	private OrthographicCamera camera;
	private Stage stage;
	private Viewport viewport;
	private Sprite background,gameover;
	private ImageButton replayButton,menuButton;
	private Table table;
	private BitmapFont score;
	
	public GameOver(EndlessRoad game)
	{
		this.game = game;
		loader = new AssetsLoader();
		loader.loadGameOverAssets();
		background = new Sprite(loader.getManager().get("Backgrounds/menus-bg.png",Texture.class));
		
		gameover = new Sprite(loader.getManager().get("Logos/gameover.png",Texture.class));
		gameover.setPosition(0,GameConstants.HEIGHT/2f+150f);
		
		camera = new OrthographicCamera(GameConstants.WIDTH,GameConstants.HEIGHT);
		camera.position.set(GameConstants.WIDTH/2f,GameConstants.HEIGHT/2f,0);
		viewport = new StretchViewport(GameConstants.WIDTH,GameConstants.HEIGHT,camera);
		stage = new Stage(viewport,game.getBatch());
		score = new BitmapFont();
		table = new Table();
		table.bottom();
		table.setFillParent(true);
		createAndPositionButtons();
		stage.addActor(table);
		Gdx.input.setInputProcessor(stage);
		
	}
	
	
	/*
	private void createAndPositionButtons()
	{
		BitmapFont font = new BitmapFont();
		Skin skin = new Skin();
		skin.add("",font);
		
		Pixmap pixmap = new Pixmap(100,50,Pixmap.Format.RGB888);
		pixmap.setColor(Color.WHITE);
		pixmap.fill();
		skin.add("background",new Texture(pixmap));
		
		replay = new TextButton("REPLAY",skin);
		replay.setPosition(GameConstants.WIDTH/2f,GameConstants.HEIGHT/2f);
		stage.addActor(replay);
	}
	*/
	
	private void createAndPositionButtons()
	{
		replayButton = new ImageButton(new SpriteDrawable(new Sprite(loader.getManager().get("Buttons/replaybutton.png",Texture.class))));
		//menuButton = new ImageButton(new SpriteDrawable(new Sprite(new Texture("Buttons/playbutton.png"))));
		menuButton = new ImageButton(new SpriteDrawable(new Sprite(loader.getManager().get("Buttons/menubutton.png",Texture.class))));
		
		replayButton.addListener(new ChangeListener()
		{
			@Override
			public void changed(ChangeEvent event, Actor actor)
			{
				game.setScreen(new Gameplay(game));				
			}
			
		});
		
		menuButton.addListener(new ChangeListener()
		{
			@Override
			public void changed(ChangeEvent event,Actor actor)
			{
				game.setScreen(new MainMenu(game));
			}
		});
		
		table.add(replayButton).padBottom(20f);
		table.row();
		//table.add(menuButton).padBottom(20f);
		//table.row();
		table.add(menuButton).padBottom(40f);
		
	}

	@Override
	public void show()
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(float delta)
	{
		Gdx.gl.glClearColor(0, 0, 0, 0);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		game.getBatch().begin();
		game.getBatch().draw(background,background.getX(),background.getY());
		game.getBatch().draw(gameover,gameover.getX(),gameover.getY());
		score.draw(game.getBatch(),"Your score is: 500m!",0,0);
		game.getBatch().end();
		stage.draw();
		camera.update();
		
	}

	@Override
	public void resize(int width, int height)
	{
		viewport.update(width,height,true);		
	}

	@Override
	public void pause()
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume()
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void hide()
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose()
	{
		game.dispose();	
		loader.getManager().clear();
	}
}
