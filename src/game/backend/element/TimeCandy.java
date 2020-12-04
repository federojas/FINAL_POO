package game.backend.element;

public abstract class TimeCandy extends Candy{
    private int time;

    public TimeCandy(CandyColor color, int time) {
        super(color);
        this.time = time;
    }

    @Override
    public boolean isObjective() {
        return true;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }
}
