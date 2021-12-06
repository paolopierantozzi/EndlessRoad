package utilities;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;

/**
 * Manages the game assets loading process
 * @author Paolo Pierantozzi
 *
 */
public class AssetsLoader
{
	private AssetManager manager;
	
	public AssetsLoader() {manager = new AssetManager();}
	
	/**
	 * Returns an AssetsManager with all game assets loaded yet
	 */
	public AssetManager getManager() {return manager;}
	
	/**
	 * Loads all the assets needed for the main menu screen
	 */
	public void loadMainMenuAssets()
	{
		manager.load("Backgrounds/menus-bg.png",Texture.class);
		manager.load("Logos/endlessroad.png",Texture.class);
		manager.load("Buttons/playbutton.png",Texture.class);
		manager.load("Buttons/creditsbutton.png",Texture.class);
		manager.load("Buttons/quitbutton.png",Texture.class);
		manager.finishLoading();
	}
	
	/**
	 * Loads all the assets needed for the gameplay screen
	 */
	public void loadGameplayAssets()
	{
		manager.load("Backgrounds/road.png",Texture.class);
		manager.load("Cars/player.png",Texture.class);
		
		for (int i=1;i<9;i++) manager.load("Cars/car" + i + ".png",Texture.class);
		manager.finishLoading();
	}
	
	/**
	 * Loads all the assets needed for the game over screen
	 */
	public void loadGameOverAssets()
	{
		manager.load("Backgrounds/menus-bg.png",Texture.class);
		manager.load("Logos/gameover.png",Texture.class);
		manager.load("Buttons/replaybutton.png",Texture.class);
		manager.load("Buttons/menubutton.png",Texture.class);
		manager.finishLoading();
	}
	
	/**
	 * Loads all the assets needed for the credits screen 
	 */
	public void loadCreditsAssets()
	{
		manager.load("Backgrounds/menus-bg.png",Texture.class);
		manager.load("Logos/credits.png",Texture.class);
		manager.load("Buttons/backbutton.png",Texture.class);
		manager.load("Fonts/Agency FB.fnt",BitmapFont.class);
		manager.finishLoading();
	}
	
	
	
	
	
	
	
}
