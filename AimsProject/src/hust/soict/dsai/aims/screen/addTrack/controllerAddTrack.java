package hust.soict.dsai.aims.screen.addTrack;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import hust.soict.dsai.aims.cart.Cart.Cart;
import hust.soict.dsai.aims.exception.NonPositiveException;
import hust.soict.dsai.aims.media.Track;
import hust.soict.dsai.aims.store.Store;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class controllerAddTrack {
    @FXML
    Store store;
    Cart cart;
    JFrame JFrameTrack;
    Label numTrack;
    private Button add;
    ArrayList<Track> tracks;

    @FXML
    private TextField length;

    @FXML
    private TextField title;

//    @FXML
//    void 5b5050(ActionEvent event) {
//
//    }

    @FXML
    void PressedAdd(ActionEvent event) {
    	JFrameTrack.setVisible(true);
    	String titlet = title.getText();
    	try {
    	int lengtht = Integer.valueOf(length.getText());
    	if (lengtht >0) {
    	Track t;
		try {
			t = new Track(titlet,lengtht);
			tracks.add(t);
	    	numTrack.setText(""+tracks.size());
	    	JFrameTrack.setVisible(false);
		} catch (NonPositiveException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
  
    	
    	
//    	Track t = new Track(titlet,lengtht);
//    	
//    	tracks.add(t);
//    	numTrack.setText(""+tracks.size());
//    	JFrameTrack.setVisible(false);
    	}
    	else JOptionPane.showMessageDialog(JFrameTrack, "Invalid length", "ERROR", JOptionPane.ERROR_MESSAGE);
    	}
    	
    	catch(NumberFormatException e) {
        	JOptionPane.showMessageDialog(JFrameTrack, "Invalid length", "ERROR", JOptionPane.ERROR_MESSAGE);
    	}
    }
    public controllerAddTrack(Store s, Cart c, JFrame j,ArrayList<Track> tracks,Label numTrack) {
    	this.cart = c;
    	this.store = s;
    	this.JFrameTrack = j;
    	this.tracks = tracks;
    	this.numTrack = numTrack;
    }
}
