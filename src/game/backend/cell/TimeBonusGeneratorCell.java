package game.backend.cell;

import game.backend.element.*;
import game.backend.level.Level;


public class TimeBonusGeneratorCell extends SpecialCandyGeneratorCell{

    private int bonusTime;
    public TimeBonusGeneratorCell(Level level, double generateRate, int timer) {
        super(level, generateRate);
        bonusTime = timer;
    }

    @Override
    protected Element getSpecialCandy(Candy base){
        return new TimeBonusCandy(base.getColor(), bonusTime);
    }
}
