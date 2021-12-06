package com.pierantozzi.endlessroad.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.pierantozzi.endlessroad.GameMain;

import utilities.GameInfos;

public class DesktopLauncher {
	public static void main (String[] args) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "Endless Road";
		config.height = GameInfos.HEIGHT;
		config.width = GameInfos.WIDTH;
		new LwjglApplication(new GameMain(), config);
	}
}
