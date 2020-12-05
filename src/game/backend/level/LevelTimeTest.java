package game.backend.level;

import game.backend.GameState;
import game.backend.ObjectiveGameState;

public class LevelTimeTest extends TimeLevel {
    private static final int OBJECTIVE_AMOUNT=10;
    public LevelTimeTest() {
        super(OBJECTIVE_AMOUNT);
    }
    @Override
    protected GameState newState() {
        return new LevelState(getQty());
    }
    @Override
    public boolean tryMove(int i1, int j1, int i2, int j2) {
        boolean ret;
        if (ret = super.tryMove(i1, j1, i2, j2)) {
            ;
        }
        return ret;
    }
    private class LevelState extends ObjectiveGameState{
        public LevelState(int amount) {
            super(amount);
        }
    }



}
