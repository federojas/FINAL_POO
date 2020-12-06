package game.backend.cell;

import game.backend.element.Candy;
import game.backend.element.Element;
import game.backend.element.TimeCandy;
import game.backend.level.Level;
import game.backend.level.SpecialCandyLevel;

public abstract class SpecialCandyGeneratorCell extends CandyGeneratorCell {
    private double generateRate;
    protected SpecialCandyGeneratorCell( Level level, double generateRate ){
        super( level );
        this.generateRate = generateRate;
    }

    @Override
    public Element getContent(){
        Element result = super.getContent();
        SpecialCandyLevel current = ((SpecialCandyLevel) getGrid());
        if( !current.reachedMax() && (Math.random() < generateRate )){
            current.increaseSpecialCandy();
            return getSpecialCandy( ((Candy)result) );
        }
        return result;
    }

    protected abstract TimeCandy getSpecialCandy(Candy base);

}
