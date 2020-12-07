package game.backend.level;

import game.backend.GameState;
import game.backend.cell.*;
import game.backend.element.TimeBonusCandy;

public class Level4 extends SpecialCandyLevel {

    private static int MAX_BONUS_CANDY = 10;
    private static int TIMER = 60;
    private static double BONUS_CANDY_RATE = 0.25;


    public Level4(){
        super(MAX_BONUS_CANDY);
    }

    @Override
    protected GameState newState() {
        return new Level4State();
    }

    @Override
    public CandyGeneratorCell generateCandyCell() {
        return new TimeBonusGeneratorCell(this, BONUS_CANDY_RATE);
    }


    public void removeTimeBonusCandy(TimeBonusCandy candy) {
        ((Level4.Level4State) state()).removeBonusTimeCandy(candy);
    }


    protected class Level4State extends TimeState {

        public void addTime(int time) {
            TIMER += time;
        }

        public void removeBonusTimeCandy( TimeBonusCandy candy ){
            specialEliminated();
            addTime( candy.getBonus() );
        }

        public void timeUp() {
            lostGame();
        }


    }
}
