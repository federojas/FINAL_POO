package game.frontend;

import game.backend.CandyGame;
import game.backend.level.Level1;
import game.backend.level.Level2;
import game.backend.level.LevelTimeTest;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.Label;



public class GameApp extends Application {

	public static void main(String[] args) {
		launch(args);
		// hola
	}

	@Override
	public void start(Stage primaryStage) {
		primaryStage.setScene(mainMenu(primaryStage));
		primaryStage.setY(30);
		primaryStage.setX(350);
		primaryStage.setResizable(false);
		primaryStage.setTitle("Crush Candy");
		primaryStage.getIcons().add(new Image("images/icono_candy.png"));
		primaryStage.show();
	}
	private Scene mainMenu(Stage primaryStage){
		Label title= new Label("Crush Candy");
		title.setFont(new Font("Roboto",30));
		title.setStyle("-fx-background-color:#e30052;-fx-font-weight: 800;-fx-padding: 10px;");
		title.setTextFill(Paint.valueOf("white"));

		Label description= new Label("Welcome to the most flexible Candy Crush of all times!!");
		description.setFont(new Font("Roboto",16));
		description.setStyle("-fx-background-color:#e30052;-fx-font-weight: 800;-fx-padding: 10px;");
		description.setTextFill(Paint.valueOf("white"));

		Label choose =new Label("Choose your level please");
		choose.setFont(new Font("Roboto",12));
		choose.setStyle("-fx-background-color:#e30052;-fx-font-weight: 800;-fx-padding: 10px;");
		choose.setTextFill(Paint.valueOf("white"));



		Button button1= new Button("Level 1");
		Button button2= new Button("Level 2");
		Button button3= new Button("Level 3");
		Button button4= new Button("Level 4");

		button1.setStyle("-fx-background-color: #5490ff;");
		button1.setTextFill(Paint.valueOf("white"));
		button1.setPrefHeight(20);
		button1.setPrefWidth(100);

		button2.setStyle("-fx-background-color: #5490ff;");
		button2.setTextFill(Paint.valueOf("white"));
		button2.setPrefHeight(20);
		button2.setPrefWidth(100);

		button3.setStyle("-fx-background-color: #5490ff;");
		button3.setTextFill(Paint.valueOf("white"));
		button3.setPrefHeight(20);
		button3.setPrefWidth(100);

		button4.setStyle("-fx-background-color: #5490ff;");
		button4.setTextFill(Paint.valueOf("white"));
		button4.setPrefHeight(20);
		button4.setPrefWidth(100);

		button1.setOnAction(e -> openLevel(button1.getText(),primaryStage));
		button2.setOnAction(e -> openLevel(button2.getText(), primaryStage));
		button3.setOnAction(e -> openLevel(button3.getText(),primaryStage));
		button4.setOnAction(e -> openLevel(button4.getText(), primaryStage));

		VBox menu = new VBox(15);
		menu.getChildren().addAll(title,description,choose,button1,button2,button3,button4);
		menu.setPrefSize(600,400);
		menu.setAlignment(Pos.CENTER);
		StackPane stackPane= new StackPane(new ImageView(new Image("images/fondo.jpg")),menu);

		return new Scene(stackPane);
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
