package hust.soict.dsai.aims.screen.addCD;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import hust.soict.dsai.aims.cart.Cart.Cart;
import hust.soict.dsai.aims.exception.NonPositiveException;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.Track;
import hust.soict.dsai.aims.screen.addTrack.addTrackToCD;
import hust.soict.dsai.aims.store.Store;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class controllerAddCD {
    private Store store;
    private JFrame JFrameCD;
    private Cart cart;
    private CompactDisc cd;
    ArrayList<Track> tracks = new ArrayList<Track>();
    @FXML
    private TextField newCDTitle;

    @FXML
    private TextField newCDDirector;

    @FXML
    private Button buttonCancel;

    @FXML
    private TextField newCDArtist;

    @FXML
    private TextField newCDCost;

    @FXML
    private TextField newCDCategory;

    @FXML
    private Button buttonAdd;
    @FXML
    private Label numTrack;
    @FXML
    void dd2222(ActionEvent event) {

    }
    @FXML
    private Button ButtonAddTrack;
    public controllerAddCD( Store store,Cart cart, JFrame jfr) {
    	this.cart = cart;
    	this.store = store;
    	this.JFrameCD = jfr;
    }
    @FXML
    void PressedAdd(ActionEvent event) {
    	JFrameCD.setVisible(true);
    	String CDtitle = newCDTitle.getText();
    	String CDcategory = newCDCategory.getText();
    	String CDdirector = newCDDirector.getText();
    	String CDartist = newCDArtist.getText();
    	
    	
    	try {
    		float CDcost = Float.valueOf(newCDCost.getText());
    		if (CDcost >0) {
    		try {
				cd = new CompactDisc();
				store.addMedia(cd);
				JOptionPane.showMessageDialog(null,"Added success");
		    	JFrameCD.setVisible(false);
			} catch (NonPositiveException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	
//	    	cd = new CompactDisc(CDtitle,CDcategory,CDdirector,CDcost,CDartist,tracks);
//			store.addMedia(cd);
//			JOptionPane.showMessageDialog(null,"Added success");
//	    	JFrameCD.setVisible(false);
    		}
    		else JOptionPane.showMessageDialog(JFrameCD, "Invalid cost", "ERROR", JOptionPane.ERROR_MESSAGE);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(JFrameCD, "Invalid cost", "ERROR", JOptionPane.ERROR_MESSAGE);
		}
//    	JOptionPane.showMessageDialog(null,"Added success");
//    	JFrameCD.setVisible(false);
    }

    @FXML
    void pressedCancel(ActionEvent event) {
    	JFrameCD.setVisible(false);
    }
	
    @FXML
    void addTrack(ActionEvent event) {
    	
    	new addTrackToCD(store,cart,tracks,numTrack);
    	
    }

}
