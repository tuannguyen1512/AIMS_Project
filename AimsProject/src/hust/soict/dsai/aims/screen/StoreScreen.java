package hust.soict.dsai.aims.screen;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import hust.soict.dsai.aims.exception.NonPositiveException;
import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Track;
import hust.soict.dsai.aims.screen.addBook.AddBookToStoreScreen;
import hust.soict.dsai.aims.screen.addCD.AddCompactDiscToStoreScreen;
import hust.soict.dsai.aims.screen.addDVD.AddDigitalVideoDiscToStoreScreen;
import hust.soict.dsai.aims.store.Store;


public class StoreScreen extends JFrame {
	public static Store store;
	public static Cart cart;


	JPanel createNorth() {
		JPanel north = new JPanel();
		north.setLayout(new BoxLayout(north,BoxLayout.Y_AXIS));
		north.add(createMenuBar());
		north.add(createHeader());
		return north;
	}
	
	JMenuBar createMenuBar() {
		JMenu menu = new JMenu("Options");
		
		JMenu smUpdateStore = new JMenu("Update Store");
		
		JMenuItem dvdmenu = new JMenuItem("Add DVD");
		smUpdateStore.add(dvdmenu);
		dvdmenu.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {new AddDigitalVideoDiscToStoreScreen(store,cart);}
			
		});
		
		JMenuItem bookmenu =  new JMenuItem("Add Book");
		smUpdateStore.add(bookmenu);
		bookmenu.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {new AddBookToStoreScreen(store,cart);}
		});
		
		JMenuItem cdmenu = new JMenuItem("Add CD");
		smUpdateStore.add(cdmenu);
		cdmenu.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {new AddCompactDiscToStoreScreen(store,cart);}
		});
		
		
		menu.add(smUpdateStore);
		menu.add(new JMenuItem("View store"));
		
		JMenuItem viewc =new JMenuItem("View cart");
		menu.add(viewc);
		viewc.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
//				new CartScreen(cart,store);
				JFrame nullframe = new JFrame();
                new CartScreen(cart,store,nullframe);
            dispose();}
		});
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
		menuBar.add(menu);
		
		return menuBar;
	}
	
	JPanel createHeader() {
		JPanel header = new JPanel();
		header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));
		
		JLabel title = new JLabel("AIMS");
		title.setFont(new Font(title.getFont().getName(),Font.PLAIN, 50));
		title.setForeground(Color.CYAN);
		
		JButton viewcart = new JButton("View Cart");
		viewcart.setPreferredSize(new Dimension(100,50));
		viewcart.setMaximumSize(new Dimension(100,50));
		viewcart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	JFrame nullframe = new JFrame();
                new CartScreen(cart,store,nullframe);
//                new CartScreen(cart,store);
                setVisible(false);
            }
        });
		header.add(Box.createRigidArea(new Dimension(10,10)));
		header.add(title);
		header.add(Box.createHorizontalGlue());
		header.add(viewcart);
		header.add(Box.createRigidArea(new Dimension(10,10)));
		
		return header;
	}
	
	JPanel createCenter() {
		JPanel center = new JPanel();
		center.setLayout(new GridLayout(3, 3, 2, 2));
		
		List<Media> mediaInStore = store.getItemsInStore();
		for (int i =0;i<mediaInStore.size();i++) {
			MediaStore cell = new MediaStore(mediaInStore.get(i),cart);
			center.add(cell);
		}
        return center;
	}
	
	public StoreScreen(Store store, Cart cart) {
		this.store = store;
		this.cart = cart;
		Container cp = getContentPane();
		
		cp.setLayout(new BorderLayout());
		cp.add(createNorth(), BorderLayout.NORTH);
		cp.add(createCenter(), BorderLayout.CENTER);
		
		setVisible(true);
		setTitle("Store");
		setSize(1024, 768);
	}

	public static void main(String[] arg) {
		store = new Store();
		cart = new Cart();
		DigitalVideoDisc dvd1;
		try {
			dvd1 = new DigitalVideoDisc("The lion King","Animation","Roger Allers",87,19.95f);
			store.addMedia(dvd1);
		} catch (NonPositiveException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		DigitalVideoDisc dvd2;
		try {
			dvd2 = new DigitalVideoDisc("Star Wars","Science Fiction","George Lucas",87,24.95f);
			store.addMedia(dvd2);
		} catch (NonPositiveException e) {
			// TODO Auto-generated catch block
		}
		
		DigitalVideoDisc dvd3;
		try {
			dvd3 = new DigitalVideoDisc("Aladin","Animation",18.99f);
			store.addMedia(dvd3);
		} catch (NonPositiveException e) {
			// TODO Auto-generated catch block
		}
		

		try {
			CompactDisc cd = new CompactDisc("hihi", "kaka", "hoho", 123, "ko biet");
			store.addMedia(cd);
		} catch (NonPositiveException e) {
			// TODO Auto-generated catch block
		}
		
		DigitalVideoDisc dvd4;
		try {
			dvd4 = new DigitalVideoDisc("Naruto","Animation",88.99f);
			store.addMedia(dvd4);
		} catch (NonPositiveException e) {
			// TODO Auto-generated catch block
		}
		
		Book dvd5;
		try {
			dvd5 = new Book("One Piece","Animation",98.1f, null);
			DigitalVideoDisc dvd6;
			store.addMedia(dvd5);
		} catch (NonPositiveException e1) {
			// TODO Auto-generated catch block
		}
		
		
		try {
			DigitalVideoDisc dvd6 = new DigitalVideoDisc("Dieu anh luon giu kin trong tim","romance",0);
			store.addMedia(dvd6);
		} catch (NonPositiveException e) {
			// TODO Auto-generated catch block
		}
		
		DigitalVideoDisc dvd7;
		try {
			dvd7 = new DigitalVideoDisc("Muon roi ma sao con","romance","ng",0,18.99f);
			store.addMedia(dvd7);
		} catch (NonPositiveException e) {
			// TODO Auto-generated catch block
		}
		
		
		CompactDisc cd3;
		try {
			cd3 = new CompactDisc("co chac yeu la day","ko nho","blackpink",123,"ko biet");
			Track t1 = new Track("day la track 1",2);
			Track t2 = new Track("day la track 2");
			cd3.addTrack(t1);
			cd3.addTrack(t2);
			store.addMedia(cd3);
			
		} catch (NonPositiveException e) {
			
		}
		
		
		new StoreScreen(store,cart);
	}
}
