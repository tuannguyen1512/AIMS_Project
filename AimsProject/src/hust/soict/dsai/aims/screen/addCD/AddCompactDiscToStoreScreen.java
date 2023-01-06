package hust.soict.dsai.aims.screen.addCD;

import java.io.IOException;

import javax.swing.JFrame;

import hust.soict.dsai.aims.cart.Cart.Cart;
import hust.soict.dsai.aims.store.Store;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class AddCompactDiscToStoreScreen {
	private Cart cart;
	private Store store;
	public AddCompactDiscToStoreScreen( Store store,Cart cart) {
		this.cart = cart;
		this.store = store;
		JFXPanel fxPanel = new JFXPanel();
		JFrame JFrameCD = new JFrame();
    	JFrameCD.setTitle("Add CD");
    	JFrameCD.setSize(425, 523);
    	JFrameCD.setVisible(true);
    	JFrameCD.add(fxPanel);
    	
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("CD.fxml"));
                    controllerAddCD controller = new controllerAddCD(store, cart,JFrameCD );
                    loader.setController(controller);
                    Parent root = loader.load();
                    fxPanel.setScene(new Scene(root));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
	}
//	public static void main(String[] args) {
//		Store store = new Store();
//		Cart cart = new Cart();
//		new AddCompactDiscToStoreScreen( store, cart);
//	}
}
