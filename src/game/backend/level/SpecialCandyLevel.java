package game.backend.level;

import game.backend.cell.BombCandyGeneratorCell;
import game.backend.cell.SpecialCandyGeneratorCell;

public abstract class SpecialCandyLevel extends Level {
    private int maxSpecialCandy;
    private int currentSpecialCandy = 0;

    public SpecialCandyLevel(int maxSpecialCandy) {
        super();
        this.maxSpecialCandy = maxSpecialCandy;
    }

    public void increaseSpecialCandy() {
        currentSpecialCandy++;
    }

    public boolean reachedMax() {
        return maxSpecialCandy == currentSpecialCandy;
    }


}
