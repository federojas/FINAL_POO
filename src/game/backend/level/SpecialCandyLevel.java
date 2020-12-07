package game.backend.level;

import game.backend.GameState;
import game.backend.cell.BombCandyGeneratorCell;
import game.backend.cell.SpecialCandyGeneratorCell;
import game.backend.element.TimeCandy;

public abstract class SpecialCandyLevel extends Level {
    private int maxSpecialCandy;
    private int currentSpecialCandy = 0;

    public SpecialCandyLevel(int maxSpecialCandy) {
        super();
        this.maxSpecialCandy = maxSpecialCandy;
    }

    public void increaseSpecialCandy() {
        currentSpecialCandy++;
    }

    public boolean reachedMax() {
        return maxSpecialCandy == currentSpecialCandy;
    }

    protected class TimeState extends GameState {

        private boolean gameLost = false;
        private int specialsEliminated = 0;

        @Override
        public boolean gameOver() {
            return playerWon() || gameLost;
        }

        @Override
        public boolean playerWon() {
            return specialsEliminated == maxSpecialCandy;
        }

        public void specialEliminated() {
            specialsEliminated++;
        }

        public void lostGame() {
            gameLost = true;
        }
    }
}
