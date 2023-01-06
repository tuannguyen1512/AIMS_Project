package hust.soict.dsai.aims.screen.addTrack;

import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFrame;

import hust.soict.dsai.aims.cart.Cart.Cart;
import hust.soict.dsai.aims.media.Track;
import hust.soict.dsai.aims.store.Store;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;

public class addTrackToCD {
	private Cart cart;
	private Store store;
	ArrayList<Track> tracks;
	private Label numTrack;
	public addTrackToCD( Store store,Cart cart, ArrayList<Track> tracks,Label numTrack) {
		this.cart = cart;
		this.store = store;
		this.tracks = tracks;
		this.numTrack = numTrack;
		JFXPanel fxPanel = new JFXPanel();
		JFrame JFrameTrack = new JFrame();
		JFrameTrack.setTitle("Add Track");
		JFrameTrack.setSize(360,300);
		JFrameTrack.setVisible(true);
		JFrameTrack.add(fxPanel);
    	
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("Track.fxml"));
                    controllerAddTrack controller = new controllerAddTrack(store, cart,JFrameTrack, tracks,numTrack );
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
//	Cart c = new Cart();
//	Store s = new Store();
//	List<Track> tracks;
//	new addTrackToCD(s,c,d);
//
//}
}
