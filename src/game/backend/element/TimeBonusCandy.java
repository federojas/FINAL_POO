package game.backend.element;

public  class TimeBonusCandy extends TimeCandy {
    private final static int BONUS =10;
    public TimeBonusCandy(CandyColor color) {
        super(color, BONUS);
    }
    //falta asignar todo lo de front end

    @Override
    public String getTimeInfo() {
        return "+" + BONUS;
    }

}
