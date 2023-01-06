package hust.soict.dsai.javafx;

import javafx.stage.Stage;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;

public class Painter extends Application{
	@Override
	public void start(Stage stage) throws Exception {
	Parent root = FXMLLoader.load(getClass().getResource("/hust/soict/dsai/javafx/Painter.fxml"));
	stage.setTitle("Painter");
	Scene scene = new Scene(root);
	stage.setScene(scene);
	stage.show();
	}
	public static void main(String args[]) {
		launch(args);
	}
}