package game.backend.level;

import game.backend.GameState;

public class Level2 extends Level {
    private static int MAX_MOVES = 20;

    @Override
    protected GameState newState() {
        return new Level2State(MAX_MOVES);
    }

    @Override
    public boolean tryMove(int i1, int j1, int i2, int j2) {
        boolean ret;
        if (ret = super.tryMove(i1, j1, i2, j2)) {
            state().addMove();

        }
        return ret;
    }

    private void setGoldenCross() {

        int newGoldenCells = 0;

        for (int i = 0; i < getSize(); i++) {

        }
    }

    private class Level2State extends GameState {
        private long maxMoves;
        private long goldenCells;

        public Level2State(long maxMoves) {
            this.maxMoves = maxMoves;
        }

        @Override
        public boolean gameOver() {
            return playerWon() || getMoves() >= maxMoves;
        }

        @Override
        public boolean playerWon() {
            return goldenCells == getSize()*getSize();
        }

        public void addGoldenCells (int newGoldenCells) {
            this.goldenCells += newGoldenCells;
        }
    }
}
