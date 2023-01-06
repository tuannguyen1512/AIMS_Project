package hust.soict.dsai.aims.screen;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.naming.LimitExceededException;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import hust.soict.dsai.aims.cart.Cart.Cart;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Playable;
import hust.soict.dsai.aims.media.Track;

public class MediaStore extends JPanel{
	private Media media;
	private Cart cart;
	
	public MediaStore(Media media, Cart cart) {
		this.cart = cart;
		this.media = media;
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		JLabel title = new JLabel(media.getTitle());
		title.setFont(new Font(title.getFont().getName(),Font.PLAIN,20));
		title.setAlignmentX(CENTER_ALIGNMENT);
		
		
		JLabel cost = new JLabel(""+media.getCost()+" $");
		cost.setAlignmentX(CENTER_ALIGNMENT);
		
		JPanel container = new JPanel();
		container.setLayout(new FlowLayout(FlowLayout.CENTER));
		
		JButton btnAdd = new JButton("Add to cart");
		btnAdd.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					cart.addMedia(media);
					JOptionPane.showMessageDialog(null,"Add successfully");
				} catch (LimitExceededException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null,"ERROR",e1.getMessage(),JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		container.add(btnAdd);
		
		if (media instanceof Playable) {
			JButton buttonPlay = new JButton("Play");
			container.add(buttonPlay);
			buttonPlay.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
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
			});
			
		}
		
		
		this.add(Box.createVerticalGlue());
		this.add(title);
		this.add(cost);
		this.add(Box.createVerticalGlue());
		this.add(container);
		this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
	}
}
