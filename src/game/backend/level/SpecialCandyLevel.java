package game.backend.level;

import game.backend.GameState;

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

    protected class SpecialState extends GameState {

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
            System.out.println(specialsEliminated);
        }

        protected void lostGame() {
            gameLost = true;
        }
    }
}
