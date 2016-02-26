package org.otw.open.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import org.otw.open.OpenGame;
import org.otw.open.util.UserSettings;

public class DesktopLauncher {


    public static void main(String[] arg) {
        LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
        config.width = 1440;
        config.height = 900;
        config.resizable = true;
        config.title = "OPEN - a children's game";
        UserSettings.setUserSettings(arg[0],arg[1],arg[2]);
        new LwjglApplication(OpenGame.getGame(), config);

    }
}
