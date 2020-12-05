package game.backend.level;

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

}
