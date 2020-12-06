package game.backend.cell;

import game.backend.Grid;
import game.backend.element.Candy;
import game.backend.element.Element;
import game.backend.element.TimeBombCandy;
import game.backend.level.Level3;

public class Level3Cell extends Cell {
    public Level3Cell(Grid grid) {
        super(grid);
    }

    @Override
    public void clearContent() {

        if(getContent().isSpecialCandy()) {
            ((Level3) getGrid()).deactivateBomb((TimeBombCandy) getContent());
        }
        super.clearContent();
    }
}
