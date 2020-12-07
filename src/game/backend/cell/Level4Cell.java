package game.backend.cell;

import game.backend.Grid;
import game.backend.element.TimeBombCandy;
import game.backend.element.TimeBonusCandy;
import game.backend.element.TimeCandy;
import game.backend.level.Level3;
import game.backend.level.Level4;

public class Level4Cell extends TimeCell {
    public Level4Cell(Grid grid) {
        super(grid);
    }

    @Override
    public void clearContent() {

        if(getContent().isSpecialCandy()) {
            ((Level4) getGrid()).removeTimeBonusCandy((TimeBonusCandy) getContent());
        }
        super.clearContent();
    }

}
