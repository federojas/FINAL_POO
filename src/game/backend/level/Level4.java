package game.backend.level;

import game.backend.GameState;
import game.backend.cell.*;
import game.backend.element.TimeBonusCandy;
import javafx.application.Platform;
import java.util.Timer;
import java.util.TimerTask;

public class Level4 extends SpecialCandyLevel {

    private static final int MAX_BONUS_CANDY = 10;
    private static final int TIMER = 60;
    private static final double BONUS_CANDY_RATE = 0.08;
    private static final int BONUS_TIME = 10;


    public Level4(){
        super(MAX_BONUS_CANDY);
    }

    @Override
    public String information() {
        return "Special time bonus candy will appear, destroy them all before the counter reaches zero!";
    }

    @Override
    protected GameState newState() {
        return new Level4State();
    }

    @Override
    public CandyGeneratorCell generateCandyCell() {
        return new TimeBonusGeneratorCell(this, BONUS_CANDY_RATE, BONUS_TIME);
    }


    public void removeTimeBonusCandy(TimeBonusCandy candy) {
        if(gridFormed())
            ((Level4State) state()).removeBonusTimeCandy(candy);
    }

    @Override
    protected void setCell(int i, int j) {
        Cell[][] current=g();
        current[i][j]= new Level4Cell(this);
    }


    private class Level4State extends SpecialState {
        private int countdown = TIMER;

        public Level4State() {
            Timer timer = new Timer();
            timer.scheduleAtFixedRate(new TimerTask() {
                @Override
                public void run() {
                    Platform.runLater(new TimerTask() {
                        @Override
                        public void run() {
                            countdown -= 1;
                            if (countdown == 0)
                                timeUp();
                            wasUpdated();
                            if(countdown>=0)
                                updateScorePanel();
                        }
                    });
                }
            }, 0, 1000);
        }

        public void addTime(int time) {
            countdown += time;
        }

        public void removeBonusTimeCandy( TimeBonusCandy candy ){
            specialEliminated();
            addTime( candy.getTime() );
        }

        public void timeUp() {
            lostGame();
        }

        @Override
        public String toString() {
            return "Remaining time: " + countdown + "s";
        }

    }
}
