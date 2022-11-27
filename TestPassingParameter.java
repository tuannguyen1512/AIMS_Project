package hust.soict.dsai.test.disc;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.disc.DigitalVideoDisc;

public class TestPassingParameter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DigitalVideoDisc jungleDVD = new DigitalVideoDisc("Jungle");
		DigitalVideoDisc cinderellaDVD = new DigitalVideoDisc("Cinderella");
		swap(jungleDVD, cinderellaDVD);
		System.out.println("jungle dvd title: " + jungleDVD.getTitle());
		System.out.println("cinderella dvd title: " + cinderellaDVD.getTitle());
		// changeTitle(jungleDVD, cinderellaDVD.getTitle()) ;
		System.out.println("jungle dvd title: " + jungleDVD.getTitle());
		Cart abc = new Cart() ;
		abc.addDigitalVideoDisc(jungleDVD);
		abc.addDigitalVideoDisc(cinderellaDVD);
		jungleDVD.setCost(20); cinderellaDVD.setCost(70);
		abc.printList();
		abc.searchById(0);
		abc.searchById(1);
		// System.out.println(jungleDVD.getId());
		// System.out.println(cinderellaDVD.getId());
		abc.searchByTitle("Cinderella");
		abc.searchByTitle("null");
	}
	
	public static void swap(Object o1 , Object o2) {
		Object tmp = o1 ; 
		o1 = o2 ; 
		o2 = tmp ;
	}
	
	public static void changeTitle(DigitalVideoDisc dvd, String title) {
		String old = dvd.getTitle();
		dvd.setTitle(title);
		dvd = new DigitalVideoDisc(old) ;
	}
}