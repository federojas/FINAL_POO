package game.backend.level;

public abstract class TimeLevel extends Level{
    private final int qty;

    public TimeLevel(int qty) {
        //podria ser <= pero si fuera 0 lo unico que pasa es que el nivel esta completado al empezar
        if(qty < 0){
            throw new IllegalStateException();
        }
        this.qty = qty;
    }
    public int getQty() {
        return qty;
    }
}