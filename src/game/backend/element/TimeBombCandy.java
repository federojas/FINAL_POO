package game.backend.element;

public class TimeBombCandy extends TimeCandy {

    private int id;
    private static int currentId = 0;
    private boolean active = false;

    public TimeBombCandy(CandyColor color, int timer) {
        super(color, timer);
        this.id = getId();
    }

    public boolean isActive() {
        return active;
    }

    public void activate() {
        active = true;
    }
    public void decreaseTimer(){
        if(getTime() > 0) //Timer queda en cero al perder el juego
            setTime(getTime()-1);
    }

    public boolean timeUp() {
        return getTime() <= 0;
    }

    private int getId() {
       return currentId++;
    }

    public boolean equalsId(TimeBombCandy other){
        return id==other.id;
    }
    @Override
    public String getTimeInfo() {
        return String.valueOf(getTime());
    }
}
