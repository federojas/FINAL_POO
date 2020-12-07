package game.frontend;

import game.backend.CandyGame;
import game.backend.level.*;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class GameApp extends Application {

	public static void main(String[] args) {
		launch(args);
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
		Label title = new Label("Crush Candy");
		title.setFont(new Font("Roboto",30));
		setLabelStyle(title);

		Label description= new Label("Welcome to the most flexible Candy Crush of all times!!");
		description.setFont(new Font("Roboto",16));
		setLabelStyle(description);

		Label choose =new Label("Choose your level please");
		choose.setFont(new Font("Roboto",12));
		setLabelStyle(choose);


		Button button1= new Button("Level 1");
		Button button2= new Button("Level 2");
		Button button3= new Button("Level 3");
		Button button4= new Button("Level 4");

		setButtonStyle(button1);
		setButtonStyle(button2);
		setButtonStyle(button3);
		setButtonStyle(button4);

		button1.setOnAction(e -> openLevel(new Level1(),primaryStage));
		button2.setOnAction(e -> openLevel(new Level2(), primaryStage));
		button3.setOnAction(e -> openLevel(new Level3(),primaryStage));
		button4.setOnAction(e -> openLevel(new Level4(), primaryStage));

		VBox menu = new VBox(15);
		menu.getChildren().addAll(title,description,choose,button1,button2,button3,button4);
		menu.setPrefSize(600,400);
		menu.setAlignment(Pos.CENTER);
		StackPane stackPane= new StackPane(new ImageView(new Image("images/fondo.jpg")), menu);

		return new Scene(stackPane);
	}

	private void openLevel(Level level, Stage stage){
		levelinfo(level);
		CandyGame game = new CandyGame(level);
		Scene scene= new Scene(new CandyFrame(game));
		stage.setScene(scene);
	}

	private void levelinfo(Level level){
		Alert alert = new Alert(Alert.AlertType.INFORMATION);
		alert.setTitle("Instructions");
		alert.setContentText(level.toString());
		alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
		alert.showAndWait();
	}

	private void setLabelStyle (Label label) {
		label.setStyle("-fx-background-color:#e30052;-fx-font-weight: 800;-fx-padding: 10px;");
		label.setTextFill(Paint.valueOf("white"));
	}

	private void setButtonStyle (Button button) {
		button.setStyle("-fx-background-color: #5490ff;");
		button.setTextFill(Paint.valueOf("white"));
		button.setPrefHeight(20);
		button.setPrefWidth(100);
	}
}
