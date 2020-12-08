package game.frontend;

import game.backend.CandyGame;
import game.backend.GameListener;
import game.backend.cell.Cell;
import game.backend.element.Element;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.geometry.Point2D;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.Optional;

public class CandyFrame extends VBox {

	private static final int CELL_SIZE = 65;

	private BoardPanel boardPanel;
	private ScorePanel scorePanel;
	private ImageManager images;
	private Point2D lastPoint;
	private CandyGame game;

	public CandyFrame(CandyGame game) {
		this.game = game;
		images = new ImageManager();
		boardPanel = new BoardPanel(game.getSize(), game.getSize(), CELL_SIZE);
		scorePanel = new ScorePanel();

		getChildren().add(new AppMenu());
		getChildren().add(boardPanel);
		getChildren().add(scorePanel);

		game.initGame();

		GameListener listener;
		game.addGameListener(listener = new GameListener() {
			@Override
			public void gridUpdated() {
				Timeline timeLine = new Timeline();
				Duration frameGap = Duration.millis(50);
				Duration frameTime = Duration.ZERO;
				for (int i = game().getSize() - 1; i >= 0; i--) {
					for (int j = game().getSize() - 1; j >= 0; j--) {
						int finalI = i;
						int finalJ = j;
						Cell cell = CandyFrame.this.game.get(i, j);
						Element element = cell.getContent();
						Image image = images.getImage(element);
						timeLine.getKeyFrames().add(new KeyFrame(frameTime, e -> boardPanel.setImage(finalI, finalJ, image, cell.getColor(),cell.getFrontText())));
					}
					frameTime = frameTime.add(frameGap);
				}
				timeLine.play();
			}
			@Override
			public void cellExplosion(Element e) {}

			@Override
			public void updateScorePanel() {
				scorePanel.updateScore(game().getStateMessage());
			}
		});

		listener.gridUpdated();
		listener.updateScorePanel();

		addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
			if (lastPoint == null) {
				lastPoint = translateCoords(event.getX(), event.getY());
				System.out.println("Get first = " +  lastPoint);
			} else {
				Point2D newPoint = translateCoords(event.getX(), event.getY());
				if (newPoint != null) {
					System.out.println("Get second = " +  newPoint);
					game().tryMove((int)lastPoint.getX(), (int)lastPoint.getY(), (int)newPoint.getX(), (int)newPoint.getY());
					String message = game().getStateMessage();
					if (game().isFinished()) {
						boolean won = false;
						if (game().playerWon()) {
							message =  " Finished - Player Won!";
							won = true;
						} else {
							message =  " Finished - Loser !";
						}
						finishAlert(won);
					}
					scorePanel.updateScore(message);
					lastPoint = null;
				}
			}
		});

	}

	private CandyGame game() {
		return game;
	}

	private Point2D translateCoords(double x, double y) {
		double i = x / CELL_SIZE;
		double j = y / CELL_SIZE;
		return (i >= 0 && i < game.getSize() && j >= 0 && j < game.getSize()) ? new Point2D(j, i) : null;
	}
	private void finishAlert(boolean won){
		String playAgainText = "Main Menu";
		ButtonType playAgain = new ButtonType(playAgainText);
		ButtonType exit = new ButtonType("Exit");
		Alert alert = new Alert(Alert.AlertType.INFORMATION,"", playAgain, exit);
		alert.setTitle("Game Finished");
		if(won) {
			alert.setContentText("You Won!!");
		}else{
			alert.setContentText("You Lost :(");
		}
		/*alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
*/
		Optional<ButtonType> result = alert.showAndWait();
		ButtonType button = result.orElse(ButtonType.CANCEL);

		if(button.getText().equals(playAgainText)) {
			new GameApp().start((Stage)getScene().getWindow());
	    } else {
			Platform.exit();
		}
	}

}
