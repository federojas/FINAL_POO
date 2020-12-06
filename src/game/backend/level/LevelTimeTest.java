package game.backend.level;

import game.backend.GameState;

public class LevelTimeTest extends TimeLevel {
    private static final int OBJECTIVE_AMOUNT=10;
    public LevelTimeTest() {
        super(OBJECTIVE_AMOUNT);
    }
    @Override
    protected GameState newState() {
        return new ObjectiveLevelState(getQty());
    }

    @Override
    public String information() {
        return null;
    }


    private class ObjectiveLevelState extends GameState{
        /*
        tanto timebomb como time candy tienen condiciones que comparten
        ambas tienen un cupo de caramelos "objetivos" que hay que eliminar
        antes de que que sus respectivos contadores lleguen a cero
         */
        private int amount, timeLeft;

        public ObjectiveLevelState(int amount) {
            this.amount = amount;

        }
        public void decAmount(){
            amount--;
        }

        public void setTimeLeft(int timeLeft) {
            this.timeLeft = timeLeft;
        }

        public int getAmount() {
            return amount;
        }

        public int getTimeLeft() {
            return timeLeft;
        }

        @Override
        public boolean gameOver() {
           /*
           importante denotar que en la consigna de estos niveles no se aclara si ademas
           del tiempo, el jugador tiene un maximo de movimientos a hacer  (MAX_MOVES)
           por lo que se asume que la unica condicion que importa para perder es que algun
           contador llegue a cero
            */

            return playerWon() || timeLeft==0 ;
        }

        @Override
        public boolean playerWon() {
            return amount==0; //cuando no quedan mas caramelos con contador el nivel se ha completado
        }
    }
}
