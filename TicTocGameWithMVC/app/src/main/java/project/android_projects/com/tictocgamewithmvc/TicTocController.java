package project.android_projects.com.tictocgamewithmvc;

import android.content.Context;

import Models.Players;

public class TicTocController {
    private Context context;
    private GameSeeds seeds;
    private GameState states;

    private static TicTocController mgr;
    private Players playerMod;

    public static TicTocController getInstance() {
        return mgr = new TicTocController();
    }

    public enum GameState {
        CROSS_WON, NOUGHT_WON, DRAW, PLAYING
    }

    public enum GameSeeds {
        EMPTY, CROSS, NOUGHT
    }

    public String getState(String state) {
        switch (states) {
            case PLAYING:
                return state = "The game is still running";

            case CROSS_WON:
                return state = "Cross Won!";

            case NOUGHT_WON:
                return state = "Nought Won!";
            case DRAW:
                return state = "Draw!";
        }
        return state;
    }

    public String getSeeds() {
        playerMod = new Players();
        String seed = "";
        switch (seeds) {
            case EMPTY:
                return seed;

            case CROSS:
                playerMod.setPlayerX("x");
                return seed = playerMod.getPlayerX();

            case NOUGHT:
                playerMod.setPlayerO("o");
                return seed = playerMod.getPlayerO();
        }
        return seed;
    }
}
