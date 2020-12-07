package game.backend.level;

import game.backend.GameState;
import game.backend.cell.*;
import game.backend.element.TimeBombCandy;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Level3 extends SpecialCandyLevel {

    private static final int MAX_BOMBS = 10;
    private static final int BOMB_TIMER = 10;
    private static final double BOMB_SPAWN_RATE = 0.05;


    public Level3(){
        super(MAX_BOMBS);
    }

    @Override
    public String information() {
        return "Special bomb candies will appear on screen with counters attached. Destroy all bombs before their counters reach zero!";
    }

    @Override
    public void initialize() {
       super.initialize();
       activateInitialBombs(); //activa las bombas iniciales de la grilla
    }

    public void activateInitialBombs() {
        ((Level3State) state()).activateInitialBombs();
    }

    @Override
    protected GameState newState() {
        return new Level3State();
    }

    @Override
    public CandyGeneratorCell generateCandyCell() {
        return new BombCandyGeneratorCell(this, BOMB_SPAWN_RATE, BOMB_TIMER);
    }

    public void addBomb(TimeBombCandy bomb) {
        ((Level3State) state()).addBomb(bomb);
    }


    @Override
    public boolean tryMove(int i1, int j1, int i2, int j2) {
        boolean result = super.tryMove(i1, j1, i2, j2);
        if (result) {
            ((Level3State) state()).addMove();
            wasUpdated();
        }
        return result;
    }


    public void deactivateBomb(TimeBombCandy bomb){ ((Level3State) state()).bombDeactivated(bomb); }

    @Override
    protected void setCell(int i, int j) {
        Cell[][] current=g();
        current[i][j]= new Level3Cell(this);
    }

    protected class Level3State extends TimeState {

        private List<TimeBombCandy> currentBombs = new ArrayList<>();

        public void activateInitialBombs() {
            for(TimeBombCandy candy : currentBombs) {
                candy.activate();
            }
        }

        public void bombDeactivated(TimeBombCandy bomb) {
            specialEliminated();
            Iterator<TimeBombCandy> timeBombCandyIterator = currentBombs.iterator();
            while(timeBombCandyIterator.hasNext()) {
                if(bomb.equalsId(timeBombCandyIterator.next())){
                    timeBombCandyIterator.remove();
                    break;
                }
            }
        }


        public void addBomb(TimeBombCandy bomb) {
            currentBombs.add(bomb);
        }

        @Override
        public void addMove() {
            super.addMove();
            for(TimeBombCandy candy : currentBombs) {
                if(candy.isActivated()) //previene que se bajen la cantidad de vidas de las bombas que spawnean nuevas
                    candy.decreaseTimer();
                candy.activate();
            }
            checkBomb();
        }

        private void checkBomb() {
            if(!currentBombs.isEmpty() && currentBombs.get(0).timeUp())
                lostGame();
        }

        @Override
        public String toString() {
            return "Remaining moves: " + currentBombs.get(0).getTime();
        }

    }

}