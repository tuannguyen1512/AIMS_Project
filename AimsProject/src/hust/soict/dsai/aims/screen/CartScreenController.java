package hust.soict.dsai.aims.screen;

import java.util.Optional;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import hust.soict.dsai.aims.cart.Cart.Cart;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Playable;
import hust.soict.dsai.aims.media.Track;
import hust.soict.dsai.aims.screen.addBook.AddBookToStoreScreen;
import hust.soict.dsai.aims.screen.addCD.AddCompactDiscToStoreScreen;
import hust.soict.dsai.aims.screen.addDVD.AddDigitalVideoDiscToStoreScreen;
import hust.soict.dsai.aims.store.Store;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;


public class CartScreenController {
	private JFrame frame;
	private Cart cart;
	private Store store;
    @FXML
    private Button btnPlay;

    @FXML
    private Button btnRemove;
    
	@FXML
    private TableView<Media> tblMedia;
	
	@FXML
	private TableColumn<Media, String> colMediacategory;

    @FXML
    private TableColumn<Media, String> colMediaTitle;
	    
	@FXML
    private TableColumn<Media, Float> colMediaCost;
	
   
    public CartScreenController(Cart cart,Store store,JFrame frame) {
    	super();
    	this.cart = cart;
    	this.store = store;
    	this.frame = frame;
    }

    @FXML
    private RadioButton radioBtnFilterId;
    @FXML
    private TextField tfFilter;
    @FXML
    private RadioButton radioBtnFilterTitle;
    @FXML
    private Label totalCost;
    String title;
    @FXML
    private Button btnPlaceOrder;
    
    @FXML
    private void initialize() {

    	
    	colMediaTitle.setCellValueFactory(new PropertyValueFactory<Media, String>("title"));
    	colMediacategory.setCellValueFactory(new PropertyValueFactory<Media, String>("category"));
    	colMediaCost.setCellValueFactory(new PropertyValueFactory<Media, Float>("cost"));
    	
    	tblMedia.setItems(this.cart.getOrder());
    	totalCost.setText(cart.totalCost()+" $");

    	btnPlay.setVisible(false);
    	btnRemove.setVisible(false);
    	tblMedia.getSelectionModel().selectedItemProperty().addListener(
    			new ChangeListener<Media>() {

					@Override
					public void changed(ObservableValue<? extends Media> observable, Media oldValue, Media newValue) {
						// TODO Auto-generated method stub
						if (newValue != null) {
							updateButtonBar(newValue);
						}
					}
    				
    			});
//    	tfFilter.textProperty().addListener(
//    			new ChangeListener<String>() {
//					@Override
//					public void changed(ObservableValue<? extends String> arg0, String arg1, String newValue) {
//						// TODO Auto-generated method stub
//						showFilteredMedia(newValue);
//					}
//
//					private void showFilteredMedia(String newValue) {
//						// TODO Auto-generated method stub
//						
//					}
//    				
//    			});
    		
    	}
    void updateButtonBar(Media media) {
    	btnRemove.setVisible(true);
    	if (media instanceof Playable) {
    		btnPlay.setVisible(true);
    		
    	}
    	else {
    		btnPlay.setVisible(false);
    	}
    }
    
    @FXML
    private void btnRemovePressed() {
    	Media media = tblMedia.getSelectionModel().getSelectedItem();
    	cart.removeMedia(media);
    	if (cart.getOrder().size()==0) {
    		btnPlay.setVisible(false);
    		btnRemove.setVisible(false);
    	}
    	totalCost.setText(cart.totalCost()+" $");
    }
    
    @FXML
    private void btnPlayPressed() {
    	Media media1 = tblMedia.getSelectionModel().getSelectedItem();
    	Playable media = ((Playable) media1);
    	if (media instanceof DigitalVideoDisc) {
			DigitalVideoDisc d = (DigitalVideoDisc) media;
			if (d.getLength() >0) {
			JOptionPane.showMessageDialog(null,"Playing DVD: " +d.getTitle() +"\nDVD Length: "+d.getLength(),"PLAY",JOptionPane.INFORMATION_MESSAGE );
			}
			else JOptionPane.showMessageDialog(null,"Cannot play DVD (Length <=0)","PLAY",JOptionPane.ERROR_MESSAGE );
		}
		else if (media instanceof CompactDisc) {
			CompactDisc d = (CompactDisc) media;
			String mess = "";
			int sumlen = 0;
			for (Track i: d.getTracks()) {
				if (i.getLength()>0) {
				mess +="Playing Track: "+ i.getTitle() +"\nLength: "+i.getLength()+"\n";
				sumlen+= i.getLength();
				}
				else mess += "Cannot play Track: "+i.getTitle() +" (Length <= 0)"+"\n";
				
			}
			if (sumlen>0) {
			JOptionPane.showMessageDialog(null,mess,"PLAY",JOptionPane.INFORMATION_MESSAGE );
			}
			
			else JOptionPane.showMessageDialog(null,"Cannot play CD because length <=0","PLAY",JOptionPane.ERROR_MESSAGE );
		}
    }
    @FXML
    void btnPlaceOrderPressed() {
    	if (cart.getOrder().size() == 0) {
    		Alert alert1 = new Alert(Alert.AlertType.ERROR);
    		alert1.setTitle("PLACE ORDER");
    		alert1.setHeaderText("THERE IS NO ITEMS IN YOUR CART");
    		alert1.show();
    		return;
    	}
    	
    	Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
    	alert.setTitle("PLACE ORDER");
    	alert.setHeaderText("DO YOU WANT TO CONTINUE ? \n TOTAL COST: "+this.cart.totalCost() +" $");
    	
    	ButtonType buttonTypeYes = new ButtonType("YES", ButtonBar.ButtonData.YES);
        ButtonType buttonTypeNo = new ButtonType("NO", ButtonBar.ButtonData.NO);
        
        alert.getButtonTypes().setAll(buttonTypeYes,buttonTypeNo);
        Optional<ButtonType> result = alert.showAndWait();
        
        if (result.get() == buttonTypeYes) {
        	JOptionPane.showMessageDialog(null,"Successful Payment!");
        	cart.clearCart();
        	totalCost.setText(cart.totalCost()+" $");
        	btnPlay.setVisible(false);
        	btnRemove.setVisible(false);
        }
        else {
        	JOptionPane.showMessageDialog(null,"payment failed");
        }
    }
    @FXML
    void PressViewStore(ActionEvent event) {
    	new StoreScreen(store,cart);
    	frame.setVisible(false);;
    }
    
    @FXML
    void pressedViewCart() {
    	
    }
    
    @FXML 
    void pressedAddBook(){
    	new AddBookToStoreScreen(store,cart);
    }
    @FXML
    void pressedAddDVD() {
    	new AddDigitalVideoDiscToStoreScreen(store,cart);
    }
    @FXML
    void pressedAddCD() {
    	new AddCompactDiscToStoreScreen(store,cart);
    }
    
    
}