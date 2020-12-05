package game.backend.level;

import game.backend.GameState;

public class TimeLevel extends Level{
    @Override
    protected GameState newState() {
        return null;
    }

   private class ObjectiveLevelState extends GameState{
       /*
       tanto timebomb como time candy tienen condiciones que comparten
       ambas tienen un cupo de caramelos "objetivos" que hay que eliminar
       antes de que que sus respectivos contadores lleguen a cero
        */
       private int amount, timeLeft;

       public ObjectiveLevelState(int amount, int timeLeft) {
           this.amount = amount;
           this.timeLeft = timeLeft;
       }

       @Override
       public boolean gameOver() {
           return false;
       }

       @Override
       public boolean playerWon() {
           return false;
       }
   }
}
