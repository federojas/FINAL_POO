package game.backend.element;

import java.util.Objects;

public class TimeBombCandy extends TimeCandy {
    private static final int TIMER = 10;
    private int id;
    private static int currentId = 0;
    private boolean isActive = false;
    public TimeBombCandy(CandyColor color) {
        super(color,TIMER);
        this.id = getId();
    }
    public void decreaseTimer(){
        if(getTime() > 0) //Timer queda en cero al perder el juego
            setTime(getTime()-1);
    }

    public boolean isActivated() {
        return isActive;
    }

    public boolean timeUp() {
        return getTime() <= 0;
    }

    private int getId() {
       return currentId++;
    }

    public void activate() {
        isActive = true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TimeBombCandy)) return false;
        TimeBombCandy aux = (TimeBombCandy) o;
        return id == aux.id;
    }

    @Override
    public int hashCode() { //Implementado por buena practica, no es necesario para arraylist
        return Objects.hash(id);
    }

    @Override
    public String getTimeInfo() {
        return String.valueOf(getTime());
    }
}
