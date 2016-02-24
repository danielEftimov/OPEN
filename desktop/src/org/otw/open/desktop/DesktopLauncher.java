package org.otw.open.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import org.otw.open.OpenGame;
import org.otw.open.controllers.GameState;

public class DesktopLauncher {
    public static void main(String[] arg) {
        LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
        config.width = 1440;
        config.height = 900;
        config.resizable = true;
        config.title = "OPEN - a children's game";
        new LwjglApplication(OpenGame.getGame(), config);
        GameState.initializeUserSettings(arg[0]);
    }
}
