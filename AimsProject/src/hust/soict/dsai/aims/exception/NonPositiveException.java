package hust.soict.dsai.aims.exception;

import javax.swing.JOptionPane;

public class NonPositiveException extends Exception {
	public NonPositiveException(String message){
		JOptionPane.showMessageDialog(null, message, "ERROR",
                JOptionPane.ERROR_MESSAGE);
	}
}
