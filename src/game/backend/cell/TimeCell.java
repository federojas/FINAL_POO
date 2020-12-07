package game.backend.cell;

import game.backend.Grid;
import game.backend.element.TimeCandy;

public class TimeCell extends Cell {
    public TimeCell(Grid grid) {
        super(grid);
    }

    @Override
    public String getFrontText() {
        return ((TimeCandy) getContent()).getTimeInfo();
    }


}
