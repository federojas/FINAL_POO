package game.backend.level;

import com.sun.javaws.exceptions.InvalidArgumentException;
import game.backend.GameState;

public abstract class TimeLevel extends Level {
private int maxObjectiveCandy;

public TimeLevel(int maxObjectiveCandy) {
    if(maxObjectiveCandy <= 0)
        throw new IllegalArgumentException("The maximum quota of special candy must be greater than 0.");
    this.maxObjectiveCandy = maxObjectiveCandy;
}

protected class TimeState extends GameState {
    private int timer;
    private int objectivesLeft;
    private int currentObjectives = 0;

    public TimeState(int objectives) {
        objectivesLeft = objectives;
    }

    @Override
    public boolean gameOver() {
        return playerWon() || timer == 0;
    }

    @Override
    public boolean playerWon() {
        return objectivesLeft == 0;
    }


}