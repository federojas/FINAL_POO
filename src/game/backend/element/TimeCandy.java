package game.backend.element;

public abstract class TimeCandy extends SpecialCandy{
    private int time;

    public TimeCandy(CandyColor color, int time) {
        super(color);
        this.time = time;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }
}
