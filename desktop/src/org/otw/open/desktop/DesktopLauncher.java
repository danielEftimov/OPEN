package org.otw.open.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import org.apache.commons.cli.*;
import org.otw.open.OpenGame;
import org.otw.open.controllers.ScreenController;
import org.otw.open.util.UserSettings;

public class DesktopLauncher {

    public static void main(String[] arg) {
        LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
        config.width = 1440;
        config.height = 900;
        config.resizable = true;
        config.title = "OPEN - a children's game";

        String blackAndWhiteDefault = "false";
        String sizeDefault = "m";
        String pointerColorDefault = "white";

        Options options = new Options();
        options.addOption("bw", "blackAndWhite", true, "black and white or colored theme");
        options.addOption("ps", "pointerSize", true, "pointer size (s or m)");
        options.addOption("pc", "pointerColor", true, "pointer color (red,green,blue,yellow or white)");

        CommandLineParser parser = new DefaultParser();
        CommandLine cmd = null;

        try {
            cmd = parser.parse(options, arg);

            if (cmd.hasOption("bw")) {
                blackAndWhiteDefault = cmd.getOptionValue("bw");
            }
            if (cmd.hasOption("ps")) {
                sizeDefault = cmd.getOptionValue("ps");
            }
            if (cmd.hasOption("pc")) {
                pointerColorDefault = cmd.getOptionValue("pc");
            }

        } catch (ParseException e) {
            e.printStackTrace();
        }

        UserSettings.setUserSettings(blackAndWhiteDefault, sizeDefault, pointerColorDefault);
        new LwjglApplication(OpenGame.getGame(), config);
        ScreenController.setUpCursor();
    }
}
