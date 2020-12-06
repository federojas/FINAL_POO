package game.backend.element;

import java.util.Objects;

public class TimeBombCandy extends TimeCandy {
    private static final int TIMER = 10;
    private int id;
    private static int currentId = 0;
    public TimeBombCandy(CandyColor color) {
        super(color,TIMER);
        this.id = getId();
    }
    public void decreaseTimer(){
        setTime(getTime()-1);
    }

    public boolean timeUp() {
        return getTime() <= 0;
    }

    private int getId() {
       return currentId++;
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
