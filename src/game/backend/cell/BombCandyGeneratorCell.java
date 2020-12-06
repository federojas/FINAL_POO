package game.backend.cell;

import game.backend.element.Candy;
import game.backend.element.TimeBombCandy;
import game.backend.element.TimeCandy;
import game.backend.level.Level;

public class BombCandyGeneratorCell extends SpecialCandyGeneratorCell{


    public BombCandyGeneratorCell(Level level, double generateRate) {
        super(level, generateRate);
    }

    @Override
    protected TimeCandy getSpecialCandy(Candy base) {
        return new TimeBombCandy(base.getColor());
    }
}
