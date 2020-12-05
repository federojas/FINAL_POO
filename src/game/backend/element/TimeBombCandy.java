package game.backend.element;

public class TimeBombCandy extends TimeCandy {
    private static final int TIMER = 10;
    public TimeBombCandy(CandyColor color) {
        super(color,TIMER);
    }
    public void decreaseTimer(){
        setTime(getTime()-1);
    }

    public boolean timeUp() {
        return getTime() <= 0;
    }
}
