package game.backend.cell;

import game.backend.element.Candy;
import game.backend.element.Element;
import game.backend.element.TimeBombCandy;
import game.backend.level.Level;

public class BombCandyGeneratorCell extends SpecialCandyGeneratorCell{


    protected BombCandyGeneratorCell(Level level, double generateRate) {
        super(level, generateRate);
    }

    @Override
    protected Element getSpecialCandy(Candy base) {
        return (TimeBombCandy) base;
    }
}
