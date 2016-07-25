package com.balance.balancegame.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.balance.balancegame.Constants;
import com.balance.balancegame.Game;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.height = 800;
		config.width = 480;
		config.resizable = false;
		new LwjglApplication(new Game(), config);
	}
}
