package game.backend.level;

<<<<<<< HEAD
import com.sun.javaws.exceptions.InvalidArgumentException;
import game.backend.GameState;

public abstract class TimeLevel extends Level {
private int maxObjectiveCandy;

public TimeLevel(int maxObjectiveCandy) {
    if(maxObjectiveCandy <= 0)
        throw new IllegalArgumentException("The maximum quota of special candy must be greater than 0.");
    this.maxObjectiveCandy = maxObjectiveCandy;
}

protected class TimeState extends GameState {
    private int timer;
    private int objectivesLeft;
    private int currentObjectives = 0;

    public TimeState(int objectives) {
        objectivesLeft = objectives;
    }

    @Override
    public boolean gameOver() {
        return playerWon() || timer == 0;
    }

    @Override
    public boolean playerWon() {
        return objectivesLeft == 0;
    }


}
=======
import game.backend.GameState;

public abstract class TimeLevel extends Level{
    private final int qty;

    public TimeLevel(int qty) {
        //podria ser <= pero si fuera 0 lo unico que pasa es que el nivel esta completado al empezar
        if(qty < 0){
            throw new IllegalStateException();
        }
        this.qty = qty;
    }


     //DESPUES HAY QUE BORRAR ESTE METODO
    @Override
    public void nothing() {

    }



    public int getQty() {
        return qty;
    }
>>>>>>> 3387fbb79ae8b1b0847f8d3c8a8bb4c0279b11de

}
