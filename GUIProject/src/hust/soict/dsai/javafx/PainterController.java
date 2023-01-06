package hust.soict.dsai.javafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class PainterController {

    @FXML
    private Pane drawingAreaPane;
    @FXML
	private ToggleGroup tool;
	@FXML
	private RadioButton pen,eraser;
    @FXML
    void drawingAreaMouseDragged(MouseEvent event) {   	
    	if (pen.isSelected()) {
            Circle newCircle1 = new Circle(event.getX(), event.getY(), 4, Color.BLACK);
            drawingAreaPane.getChildren().add(newCircle1);
        } 
    	else if (eraser.isSelected()) {
            Circle newCircle2 = new Circle(event.getX(), event.getY(), 6, Color.WHITE);
            drawingAreaPane.getChildren().add(newCircle2);
        }
    	else {
    		//
    	}
    }
    
    @FXML	
    void clearButtonPressed(ActionEvent event) {
    	drawingAreaPane.getChildren().clear();
    }

}