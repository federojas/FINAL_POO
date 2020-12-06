package game.frontend;

import game.backend.CandyGame;
import game.backend.level.Level1;
import game.backend.level.Level2;
import game.backend.level.LevelTimeTest;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.Button;

import java.awt.*;

public class GameApp extends Application {

	public static void main(String[] args) {
		launch(args);
		// hola
	}

	@Override
	public void start(Stage primaryStage) {
		primaryStage.setScene(mainMenu(primaryStage));
		/*CandyGame game = new CandyGame(Level1.class);
		CandyFrame frame = new CandyFrame(game);
		Scene scene = new Scene(frame);
		primaryStage.setResizable(false);
		primaryStage.setScene(scene);*/
		primaryStage.show();
	}
	private Scene mainMenu(Stage primaryStage){
		Label name= new Label("Crush Candy");
		Button button1= new Button("Level 1");
		Button button2= new Button("Level 2");
		Button button3= new Button("Level 3");
		Button button4= new Button("Level 4");

		button1.setOnAction(e -> openLevel(button1.getText(),primaryStage));
		button2.setOnAction(e -> openLevel(button2.getText(), primaryStage));
		button3.setOnAction(e -> openLevel(button3.getText(),primaryStage));
		button4.setOnAction(e -> openLevel(button4.getText(), primaryStage));

		VBox menu = new VBox();
		menu.getChildren().addAll(button1,button2,button3,button4);

		return new Scene(menu);
	}
	private void openLevel(String level, Stage stage){

		Class levelClass;
		switch(level){
			case "Level 1":
				levelClass = Level1.class;
				break;
			case "Level 2":
				levelClass = Level2.class;
				break;
			case "Level 3":

				levelClass = LevelTimeTest.class;
				break;
			default:
				levelClass = null;
		}

		CandyGame game = new CandyGame(levelClass);
		Scene scene= new Scene(new CandyFrame(game));
		stage.setScene(scene);
	}

}
