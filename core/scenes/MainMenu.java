package scenes;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
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
 * Represents the main menu screen of the game
 * @author Paolo Pierantozzi
 *
 */
public class MainMenu implements Screen
{
	private EndlessRoad game;
	private AssetsLoader loader;
	private Sprite background,logo;
	private Table table;
	private ImageButton playButton,optionsButton,creditsButton,quitButton;
	private Stage stage;
	private OrthographicCamera camera;
	private Viewport viewport;
	
	public MainMenu(EndlessRoad game)
	{
		this.game = game;
		loader = new AssetsLoader();
		loader.loadMainMenuAssets();
		
		background = new Sprite(loader.getManager().get("Backgrounds/menus-bg.png",Texture.class));
		logo = new Sprite(loader.getManager().get("Logos/endlessroad.png",Texture.class));
		//logo.setScale(1,2);
		logo.setPosition(0,GameConstants.HEIGHT/2f+150f);
		
		camera = new OrthographicCamera(GameConstants.WIDTH,GameConstants.HEIGHT);
		camera.position.set(GameConstants.WIDTH/2f,GameConstants.HEIGHT/2f,0);
		viewport = new StretchViewport(GameConstants.WIDTH,GameConstants.HEIGHT,camera);
		stage = new Stage(viewport,game.getBatch());
		
		table = new Table();
		table.center();
		table.setFillParent(true);
		createAndPositionButtons();
		stage.addActor(table);
		Gdx.input.setInputProcessor(stage);
		
		
	}

	@Override
	public void show()
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(float delta)
	{
		stage.act(delta);
		
		
		Gdx.gl.glClearColor(0, 0, 0, 0);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		game.getBatch().begin();
		background.draw(game.getBatch());
		logo.draw(game.getBatch());
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
	
	private void createAndPositionButtons()
	{
		playButton = new ImageButton(new SpriteDrawable(new Sprite(loader.getManager().get("Buttons/playbutton.png",Texture.class))));
		//optionsButton = new ImageButton(new SpriteDrawable(new Sprite(new Texture("Buttons/playbutton.png"))));
		creditsButton = new ImageButton(new SpriteDrawable(new Sprite(loader.getManager().get("Buttons/creditsbutton.png",Texture.class))));
		quitButton = new ImageButton(new SpriteDrawable(new Sprite(loader.getManager().get("Buttons/quitbutton.png",Texture.class))));
		playButton.addListener(new ChangeListener()
		{
			@Override
			public void changed(ChangeEvent event,Actor actor)
			{
				MainMenu.this.game.setScreen(new Gameplay(MainMenu.this.game));
			}
		});
		
		
		creditsButton.addListener(new ChangeListener()
		{
			@Override
			public void changed(ChangeEvent event,Actor actor)
			{
				MainMenu.this.game.setScreen(new Credits(MainMenu.this.game));
			}
			
		});
		
		
		
		table.add(playButton).padTop(150f).padBottom(30f);
		table.row();
		//table.add(optionsButton).padBottom(20f);
		//table.row();
		table.add(creditsButton).padBottom(30f);
		table.row();
		table.add(quitButton);
		    
	}

}
