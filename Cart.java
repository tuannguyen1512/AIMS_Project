package hust.soict.dsai.aims.cart;

import hust.soict.dsai.aims.disc.DigitalVideoDisc;

public class Cart {
	public static int MAX_NUMBERS_ORDERED = 20 ;
	private DigitalVideoDisc itemsOrdered [] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED]; 
	private int qtyOrdered = 0 ;
	
	public void addDigitalVideoDisc(DigitalVideoDisc disc) {
		if (qtyOrdered >= MAX_NUMBERS_ORDERED) {
			System.out.println("The cart is almost full " );
			return ;
		}
		itemsOrdered[qtyOrdered] = disc ;
		qtyOrdered = qtyOrdered + 1 ;
		System.out.println("The disc has been added" );
	}
	
	public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
		for (int i = 0 ; i < qtyOrdered ; i++ ) {
			if (disc.equals(itemsOrdered[i])) {
//				itemsOrdered[i] = null ;
				for (int j = i ; j < qtyOrdered; j++) {
					itemsOrdered[j] = itemsOrdered[j+1];
				}
				
				itemsOrdered[qtyOrdered-1] = null ; 
				qtyOrdered-- ;
			}
		}
	}
	
	public void addDigitalVideoDisc(DigitalVideoDisc [] dvdList) {
		for (DigitalVideoDisc disc : dvdList) {
			this.addDigitalVideoDisc(disc);
		}
	}
	
	public void addDigitalVideoDisc(DigitalVideoDisc dvd1,DigitalVideoDisc dvd2) {
		this.addDigitalVideoDisc(dvd1);
		this.addDigitalVideoDisc(dvd2);
	}
	
	
	public float totalCost() {
		float sum = 0.0f ; 
		for (int i = 0 ; i < qtyOrdered ; i++ ) {
			sum = sum + itemsOrdered[i].getCost();
		}
		return sum ;
	}
	
	public void printList(){
		System.out.println("***********************CART***********************");
		for( int i = 1 ; i <= this.qtyOrdered; i++){
			
			System.out.println("" + i + ". " + this.itemsOrdered[i-1]);
		}
		System.out.println("Total cost: " + this.totalCost());
		System.out.println("**************************************************");
	}
	
	public void searchById(int id){
		for (int i = 0 ; i < this.qtyOrdered ; i++ ) {
			if(this.itemsOrdered[i].getId() == id ) {
				System.out.println(this.itemsOrdered[i]);
				return ;
 			}
		}
		System.out.println("Not found");
		return ;
	}

	public void searchByTitle(String title) {
		for (int i = 0 ; i < this.qtyOrdered ; i++ ) {
			if(title.equals(this.itemsOrdered[i].getTitle())) {
				System.out.println(this.itemsOrdered[i]);
				return ;
 			}
		}
		System.out.println("Not found");
		return ;
	}
}