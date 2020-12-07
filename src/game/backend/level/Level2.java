package game.backend.level;

import game.backend.GameState;

public class Level2 extends Level {
    private static int MAX_MOVES = 20;

    @Override
    protected GameState newState() {
        return new Level2State(MAX_MOVES);
    }

    @Override
    public String information() {
        return "Each explosion paints row or column depending on the direction of the movement. You should paint all cells before "+MAX_MOVES+" moves";
    }

    @Override
    public boolean tryMove(int i1, int j1, int i2, int j2) {
        boolean ret;
        if (ret = super.tryMove(i1, j1, i2, j2)) {
            state().addMove();
            if(j1==j2){
                setGoldenCol(j2);
            }
            else{
                setGoldenRow(i1);
            }
        wasUpdated();
        }
        return ret;
    }

    private void  setGoldenCol(int col){
        int newGoldenCells=0;
        for(int i = 0; i < getSize(); i++){
            if(g[i][col].getColor()==null) {
                g[i][col].setGolden();
                newGoldenCells++;
            }
        }
        ((Level2State)state()).addGoldenCells(newGoldenCells);
    }

    private void setGoldenRow(int fil){
        int newGoldenCells=0;
        for (int i = 0; i < getSize(); i++) {
            if (g[fil][i].getColor()==null) {
                g[fil][i].setGolden();
                newGoldenCells++;
            }
        }
        ((Level2State)state()).addGoldenCells(newGoldenCells);
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

        public void addGoldenCells(int newGoldenCells) {
            this.goldenCells += newGoldenCells;
        }

        @Override
        public String toString() {
            return String.format("%s \t Remaining golden cells: %d", super.toString(), getGoldenLeftToWin());
        }

        public long getGoldenLeftToWin () {
            return getSize()*getSize() - goldenCells;
        }
    }
}
