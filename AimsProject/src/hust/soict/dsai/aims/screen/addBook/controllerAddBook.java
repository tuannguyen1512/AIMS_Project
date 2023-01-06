package hust.soict.dsai.aims.screen.addBook;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import hust.soict.dsai.aims.cart.Cart.Cart;
import hust.soict.dsai.aims.exception.NonPositiveException;
import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.store.Store;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class controllerAddBook {
    private Store store;
    private JFrame JFrameBook;
    private Cart cart;
    @FXML
    private Button buttonCancel;

    @FXML
    private TextField newBookTitle;

    @FXML
    private TextField newBookCategory;

    @FXML
    private TextField newBookAuthors;

    @FXML
    private TextField newBookCost;

    @FXML
    private Button buttonAdd;

    @FXML
    void dd2222(ActionEvent event) {

    }
    public controllerAddBook( Store store,Cart cart, JFrame jfr) {
    	this.cart = cart;
    	this.store = store;
    	this.JFrameBook = jfr;
    }
    @FXML
    void PressedAdd(ActionEvent event) {
    	JFrameBook.setVisible(true);
    	String Booktitle = newBookTitle.getText();
        String Bookcategory = newBookCategory.getText();
        List<String> authors = new ArrayList<String>();
        for (String author : newBookAuthors.getText().split(",",0)){
            authors.add(author);
        }
        
        try {
        	
	        float Bookcost = Float.valueOf(newBookCost.getText());
	        if (Bookcost >0) {
//	        Book newBook = new Book(Booktitle, Bookcategory, Bookcost,authors);
//	        store.addMedia(newBook);
//	        JOptionPane.showMessageDialog(null,"Added success");
//	        JFrameBook.setVisible(false);
	        	
        	try {
				Book newBook = new Book(Booktitle, Bookcategory, Bookcost,authors);
				store.addMedia(newBook);
		        JOptionPane.showMessageDialog(null,"Added success");
		        JFrameBook.setVisible(false);
			} catch (NonPositiveException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	}
	        else JOptionPane.showMessageDialog(JFrameBook, "Invalid cost", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        catch(NumberFormatException e) {
        	JOptionPane.showMessageDialog(JFrameBook, "Invalid cost", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        

        
    }

    @FXML
    void pressedCancel(ActionEvent event) {
    	JFrameBook.setVisible(false);
    }

}

