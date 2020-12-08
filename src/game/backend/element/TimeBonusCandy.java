package game.backend.element;

public  class TimeBonusCandy extends TimeCandy {
    public TimeBonusCandy(CandyColor color, int timer) {
        super(color, timer);
    }

    @Override
    public String getTimeInfo() {
        return "+" + getTime();
    }

}
