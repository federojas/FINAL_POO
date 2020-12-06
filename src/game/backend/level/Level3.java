package game.backend.level;

import game.backend.GameState;
import game.backend.Grid;
import game.backend.cell.BombCandyGeneratorCell;
import game.backend.cell.CandyGeneratorCell;
import game.backend.cell.Cell;
import game.backend.cell.SpecialCandyGeneratorCell;
import game.backend.element.Element;
import game.backend.element.TimeBombCandy;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

public class Level3 extends SpecialCandyLevel {

    private static int MAX_BOMBS = 10;
    private static int TIMER = 10;
    private static double BOMB_SPAWN_RATE = 0.3;


    public Level3(){
        super(MAX_BOMBS);
    }

    @Override
    protected GameState newState() {
        return new Level3State();
    }

    @Override
    public CandyGeneratorCell generateCandyCell() {
        return new BombCandyGeneratorCell(this, BOMB_SPAWN_RATE);
    }

    public void addBomb(TimeBombCandy bomb) {
        ((Level3State) state()).addBomb(bomb);
    }


    @Override
    public boolean tryMove(int i1, int j1, int i2, int j2) {
        boolean result = super.tryMove(i1, j1, i2, j2);
        if (result) {
            ((Level3State) state()).addMove();
        }
        return result;
    }

    public void deactivateBomb(TimeBombCandy bomb){ ((Level3State) state()).bombDeactivated(bomb); }


    protected class Level3State extends GameState {

        private List<TimeBombCandy> currentBombs = new ArrayList<>();
        private long bombsDeactivated=0;
        private boolean gameLost = false;

        public void bombDeactivated(TimeBombCandy bomb) {
            currentBombs.remove(bomb);
            bombsDeactivated++;
        }

        public void addBomb(TimeBombCandy bomb) {
            currentBombs.add(bomb);
        }

        @Override
        public  void addMove() {
            super.addMove();
            for(TimeBombCandy candy : currentBombs) {
                    candy.decreaseTimer();
            }
            checkBomb();
        }

        private void checkBomb() {
            if(currentBombs.get(0).timeUp())
                gameLost = true;
        }


        public boolean gameOver() { return playerWon() || gameLost; }

        @Override
        public boolean playerWon() {
            return bombsDeactivated == MAX_BOMBS;
        }

    }

}