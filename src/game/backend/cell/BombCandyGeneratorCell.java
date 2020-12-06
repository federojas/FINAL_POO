package game.backend.cell;

import game.backend.element.Candy;
import game.backend.element.Element;
import game.backend.element.TimeBombCandy;
import game.backend.level.Level;
import game.backend.level.Level3;

public class BombCandyGeneratorCell extends SpecialCandyGeneratorCell{


    public BombCandyGeneratorCell(Level level, double generateRate) {
        super(level, generateRate);
    }

    @Override
    protected Element getSpecialCandy(Candy base) {
        TimeBombCandy result = new TimeBombCandy(base.getColor());
        ((Level3) getGrid()).addBomb(result);
        return result;
    }

}
