package hust.soict.dsai.aims.screen.addBook;

import java.io.IOException;

import javax.swing.JFrame;

import hust.soict.dsai.aims.cart.Cart.Cart;
import hust.soict.dsai.aims.screen.addBook.controllerAddBook;
import hust.soict.dsai.aims.store.Store;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class AddBookToStoreScreen extends JFrame {
	private Cart cart;
	private Store store;
	public AddBookToStoreScreen( Store store,Cart cart) {
		this.cart = cart;
		this.store = store;
		JFXPanel fxPanel = new JFXPanel();
		JFrame JFrameBook = new JFrame();
    	JFrameBook.setTitle("Add Book");
    	JFrameBook.setSize(425, 446);
    	JFrameBook.setVisible(true);
    	JFrameBook.add(fxPanel);
    	
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("Book.fxml"));
                    controllerAddBook controller = new controllerAddBook(store, cart,JFrameBook );
                    loader.setController(controller);
                    Parent root = loader.load();
                    fxPanel.setScene(new Scene(root));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
	}
//	public static void main(String[] arg) {
//		Cart c = new Cart();
//		Store s = new Store();
//		new AddBookToStoreScreen(s,c);
//
//	}
}
