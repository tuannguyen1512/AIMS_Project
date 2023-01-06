package hust.soict.dsai.aims.exception;
import java.lang.Exception;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
public class PlayerException extends Exception{
	String message;
    public PlayerException(String message){
        super();
        this.message = message;
    }
    public void getError() {
    	JOptionPane.showMessageDialog(new JFrame(), message, "ERROR",
                JOptionPane.ERROR_MESSAGE);
    }
}