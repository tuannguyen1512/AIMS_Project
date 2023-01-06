package hust.soict.dsai.aims.screen;

import java.io.IOException;

import javax.naming.LimitExceededException;
import javax.swing.JFrame;

import hust.soict.dsai.aims.cart.Cart.Cart;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.store.Store;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class CartScreen extends JFrame {
	private Cart cart;
	private Store store;
	private JFrame frame;
	public CartScreen(Cart cart, Store store, JFrame frame) {
		super();
		this.cart = cart;
		this.store = store;
		this.frame = frame;
		JFXPanel fxPanel = new JFXPanel();
		frame.add(fxPanel);
		frame.setTitle("Cart");
		 frame.setSize(1024, 768);
		frame.setVisible(true);
		
		Platform.runLater(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					FXMLLoader loader = new FXMLLoader(getClass().getResource("Cart.fxml"));
					CartScreenController controller = new CartScreenController(cart,store,frame);
					loader.setController(controller);
					Parent root = loader.load();
					fxPanel.setScene(new Scene(root));
				}
				catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
	}
//	public CartScreen(Cart cart, Store store) {
//		super();
//		this.cart = cart;
//		this.store = store;
//		JFXPanel fxPanel = new JFXPanel();
//		this.add(fxPanel);
//		this.setTitle("Cart");
//		 this.setSize(1024, 768);
//		this.setVisible(true);
//		
//		Platform.runLater(new Runnable() {
//
//			@Override
//			public void run() {
//				// TODO Auto-generated method stub
//				try {
//					FXMLLoader loader = new FXMLLoader(getClass().getResource("/hust/soict/dsai/aims/screen/Cart.fxml"));
//					CartScreenController controller = new CartScreenController(cart,store);
//					loader.setController(controller);
//					Parent root = loader.load();
//					fxPanel.setScene(new Scene(root));
//				}
//				catch (IOException e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

//	public static void main(String[] args) {
//		Cart cart = new Cart();
//		Store store = new Store();
//		JFrame frame = new JFrame();
//		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The lion King","Animation","Roger Allers",87,19.95f);
//		try {
//			cart.addMedia(dvd1);
//		} catch (LimitExceededException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars","Science Fiction","George Lucas",87,24.95f);
//		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin","Animation",18.99f);
//		try {
//			cart.addMedia(dvd2,dvd3);
//		} catch (LimitExceededException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		new CartScreen(cart, store,frame);
//
//	}
}
