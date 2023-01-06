package hust.soict.dsai.swing;

import java.awt.*;       
import java.awt.event.*; 
import javax.swing.*;

public class AWTAccumulator extends Frame { // JFrame instead of Frame
	private TextField tfInput;
	private TextField tfOutput;
	private int sum = 0;

	// Constructor to setup the GUI components and event handlers
	public AWTAccumulator() {
	      setLayout(new GridLayout(2, 2));   
	 
	      add(new Label("Enter an Integer: "));
	      
	      tfInput = new TextField("10");
	      add(tfInput);
	      tfInput.addActionListener(new TFInputListener());
	      add(new Label("The Accumlator Sum is: "));
	 
	      tfOutput = new TextField("10");
	      tfOutput.setEditable(false);
	      add(tfOutput);
	      
	      setTitle("AWT Accumlator");
	      setSize(350,120);
	      setVisible(true);
	   }

	public static void main(String[] args) {
		new AWTAccumulator();
	}

	private class TFInputListener implements ActionListener {
		public void actionPerformed(ActionEvent evt) {
			int numberIn = Integer.parseInt(tfInput.getText());
			sum += numberIn;
			tfInput.setText("");
			tfOutput.setText(sum + "");
		}
	}
}
