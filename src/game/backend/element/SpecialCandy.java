package game.backend.element;

public abstract class SpecialCandy extends Candy {

    public SpecialCandy(CandyColor color) {
        super(color);
    }

    @Override
    public boolean isSpecialCandy() {
        return true;
    }
}
