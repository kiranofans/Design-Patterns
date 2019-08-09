package Models;

import java.util.Observable;

public class Players extends Observable {
    private String playerX,playerO;
    private int scores;

    public String getPlayerX() {
        return playerX;
    }

    public int getScores() {
        return scores;
    }

    public void setScores(int scores) {
        this.scores = scores;
        setChanged();
        notifyObservers();
    }

    public void setPlayerX(String playerX) {
        this.playerX = playerX;
        setChanged();
        notifyObservers();
    }

    public String getPlayerO() {
        return playerO;
    }

    public void setPlayerO(String playerO) {
        this.playerO = playerO;
        setChanged();
        notifyObservers();
    }
}
