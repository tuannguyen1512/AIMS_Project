package hust.soict.dsai.aims.screen.addDVD;

import java.io.IOException;

import javax.swing.JFrame;

import hust.soict.dsai.aims.cart.Cart.Cart;
import hust.soict.dsai.aims.store.Store;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class AddDigitalVideoDiscToStoreScreen extends JFrame {
	public Cart cart;
    public Store store;
    public AddDigitalVideoDiscToStoreScreen(Store store, Cart cart) {
    	super();
    	this.cart = cart;
    	this.store = store;
    	JFXPanel fxPanel = new JFXPanel();
    	JFrame JFrameDVD = new JFrame();
    	JFrameDVD.setTitle("Add DVD");
    	JFrameDVD.setSize(425, 446);
    	JFrameDVD.setVisible(true);
    	JFrameDVD.add(fxPanel);
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("DVD.fxml"));
                    controllerAddDVD controller = new controllerAddDVD(store, cart,JFrameDVD );
                    loader.setController(controller);
                    Parent root = loader.load();
                    fxPanel.setScene(new Scene(root));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
	
	

	
}
