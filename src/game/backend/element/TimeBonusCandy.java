package game.backend.element;

public  class TimeBonusCandy extends TimeCandy {
    private int bonus;
    public TimeBonusCandy(CandyColor color, int timer) {
        super(color, timer);
        bonus = timer;
    }

    public int getBonus() {
        return bonus;
    }

    @Override
    public String getTimeInfo() {
        return "+" + bonus;
    }

}
