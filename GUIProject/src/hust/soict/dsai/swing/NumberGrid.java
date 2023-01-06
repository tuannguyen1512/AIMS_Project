package hust.soict.dsai.swing;

import java.awt.event.ActionEvent;

import java.awt.*;       
import java.awt.event.*;
import javax.swing.*;

public class NumberGrid extends JFrame {
	private JButton[] btnNumbers = new JButton[10];
	private JButton btnDelete, btnReset;
	private JTextField tfDisplay;
	
	public NumberGrid() {
		
		tfDisplay = new JTextField();
		tfDisplay.setComponentOrientation(
			ComponentOrientation.RIGHT_TO_LEFT
		);
		JPanel panelButtons = new JPanel(new GridLayout(4, 3));
		addButton(panelButtons);

		Container cp = getContentPane();
		cp.setLayout(new BorderLayout());
		cp.add(tfDisplay, BorderLayout.NORTH);
		cp.add(panelButtons, BorderLayout.CENTER);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Number Grid");
		setSize(200, 200);
		setVisible(true);
	}

	void addButton(JPanel panelButtons) {
		ButtonListener btnListener = new ButtonListener();
		for (int i = 0; i <= 9;i++) {
			btnNumbers[i] = new JButton(""+i);
			panelButtons.add(btnNumbers[i]);
			btnNumbers[i].addActionListener(btnListener);
		}
		btnDelete = new JButton("DEL");
		panelButtons.add(btnDelete);
		btnDelete.addActionListener(btnListener);

		btnNumbers[0] = new JButton("0");
		panelButtons.add(btnNumbers[0]);
		btnNumbers[0].addActionListener(btnListener);

		btnReset = new JButton("C");
		panelButtons.add(btnReset);
		btnReset.addActionListener(btnListener);
	}
	
	private class ButtonListener implements ActionListener{
		
		public void actionPerformed(ActionEvent e) {
			String button = e.getActionCommand();
			if(button.charAt(0) >= '0' && button.charAt(0) <= '9') {
				tfDisplay.setText(tfDisplay.getText() + button);
			}
			else if (button.equals("DEL")) {
				String str = tfDisplay.getText();
				str = str.substring(0, str.length() - 1);
				tfDisplay.setText(str);
			}else {
				String str = tfDisplay.getText();
				str = "";
				tfDisplay.setText(str);
			}
		}
	}

}
