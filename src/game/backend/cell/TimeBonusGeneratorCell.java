package game.backend.cell;

import game.backend.element.*;
import game.backend.level.Level;

public class TimeBonusGeneratorCell extends SpecialCandyGeneratorCell{


    protected TimeBonusGeneratorCell(Level level, double generateRate) {
        super(level, generateRate);
    }

    @Override
    protected TimeCandy getSpecialCandy(Candy base) {
        return new TimeBonusCandy(base.getColor());
    }
}
