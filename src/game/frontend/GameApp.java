package game.frontend;

import game.backend.CandyGame;
import game.backend.level.Level1;
import game.backend.level.LevelTimeTest;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class GameApp extends Application {

	public static void main(String[] args) {
		launch(args);
		// hola
	}

	@Override
	public void start(Stage primaryStage) {
		CandyGame game = new CandyGame(Level1.class);
		CandyFrame frame = new CandyFrame(game);
		Scene scene = new Scene(frame);
		primaryStage.setResizable(false);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

}
