package game.backend.cell;

import game.backend.Grid;
import game.backend.element.Element;
import game.backend.element.TimeBombCandy;
import game.backend.level.Level3;

public class Level3Cell extends Cell {
    public Level3Cell(Grid grid) {
        super(grid);
    }

    @Override
    public void clearContent() {
        super.clearContent();
        Element current = getContent();
        System.out.println(current.isSpecialCandy());
        if(current.isSpecialCandy()) {
            System.out.println("entre");
            ((Level3) getGrid()).deactivateBomb((TimeBombCandy) current);
        }

    }
}
