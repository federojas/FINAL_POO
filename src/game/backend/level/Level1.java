package game.backend.level;

import game.backend.GameState;
import game.backend.cell.CandyGeneratorCell;


public class Level1 extends Level {
	
	private static int REQUIRED_SCORE = 5000; 
	private static int MAX_MOVES = 20;

	@Override
	protected GameState newState() {
		return new Level1State(REQUIRED_SCORE, MAX_MOVES);
	}

	@Override
	public String information() {
		return "You have to achieve "+REQUIRED_SCORE+" points in "+MAX_MOVES+" moves";
	}

	@Override
	public boolean tryMove(int i1, int j1, int i2, int j2) {
		boolean ret;
		if (ret = super.tryMove(i1, j1, i2, j2)) {
			state().addMove();
		}
		return ret;
	}

	@Override
	public CandyGeneratorCell generateCandyCell() {
		return new CandyGeneratorCell(this);
	}

	private class Level1State extends GameState {
		private long requiredScore;
		private long maxMoves;
		
		public Level1State(long requiredScore, int maxMoves) {
			this.requiredScore = requiredScore;
			this.maxMoves = maxMoves;
		}

		@Override
		public boolean gameOver() {
			return playerWon() || getMoves() >= maxMoves;
		}

		@Override
		public boolean playerWon() {
			return getScore() > requiredScore;
		}
	}

}