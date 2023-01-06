package hust.soict.dsai.aims.screen.addDVD;

import javax.naming.LimitExceededException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import hust.soict.dsai.aims.cart.Cart.Cart;
import hust.soict.dsai.aims.exception.NonPositiveException;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.screen.StoreScreen;
import hust.soict.dsai.aims.store.Store;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javax.naming.LimitExceededException;
public class controllerAddDVD {
	private JFrame JFrameDVD;
    private Store store;

    private Cart cart;
    
    @FXML
    private Button buttonCancel;

    @FXML
    private TextField newDVDTitle;

    @FXML
    private TextField newDVDCategory;

    @FXML
    private TextField newDVDDirect;

    @FXML
    private TextField newDVDLength;

    @FXML
    private TextField newDVDCost;

    @FXML
    private Button buttonAdd;

    @FXML
    void dd2222(ActionEvent event) {

    }

    
    public controllerAddDVD(Store store, Cart cart, JFrame jfr) {
        super();
        this.cart = cart;
        this.store = store;
        this.JFrameDVD = jfr;
    }

    @FXML
    void PressedAdd(ActionEvent event) {
    	JFrameDVD.setVisible(true);
        String DVDtitle = newDVDTitle.getText();
        String DVDcategory = newDVDCategory.getText();
        String DVDdirector = newDVDDirect.getText();
        
        try {
	        int DVDlength = Integer.parseInt(newDVDLength.getText());
	        float DVDcost = Float.parseFloat(newDVDCost.getText());
	        if (DVDcost>0 && DVDlength >0) {
		      
		        DigitalVideoDisc newDVD;
				try {
					newDVD = new DigitalVideoDisc(DVDtitle, DVDcategory, DVDdirector, DVDlength, DVDcost);
					store.addMedia(newDVD);
			        JOptionPane.showMessageDialog(null,"Added success");
			        JFrameDVD.setVisible(false);
				} catch (NonPositiveException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		        
		        
//		        DigitalVideoDisc newDVD = new DigitalVideoDisc(DVDtitle, DVDcategory, DVDdirector, DVDlength, DVDcost);
//		        store.addMedia(newDVD);
//		        JOptionPane.showMessageDialog(null,"Added success");
//		        JFrameDVD.setVisible(false);
		        
	        	}
	        else JOptionPane.showMessageDialog(JFrameDVD, "Invalid cost/length", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        catch(NumberFormatException e) {
        	JOptionPane.showMessageDialog(JFrameDVD, "Invalid cost/length", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

    @FXML
//    buttonCancel.setDefaultButton(true);
    void pressedCancel(ActionEvent event) {
    	JFrameDVD.setVisible(false);
    	
    }

}
