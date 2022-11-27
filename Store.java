package hust.soict.dsai.aims.store;

import hust.soict.dsai.aims.disc.DigitalVideoDisc;

public class Store {
    public static int MAX_NUMBERS_ITEMS = 200 ;
    private DigitalVideoDisc [] items = new DigitalVideoDisc[MAX_NUMBERS_ITEMS];
    private int num_items = 0 ;
    public DigitalVideoDisc [] getItems() {
        return items ;
    }
    public void addDVD (DigitalVideoDisc disc) {
		items[num_items] = disc ;
        num_items++ ;
		System.out.println("The disc has been added" );
	}
    
    public void removeDVD(DigitalVideoDisc disc) {
		for (int i = 0 ; i < num_items ; i++ ) {
			if (disc.equals(items[i])) {
//				items[i] = null ;
				for (int j = i ; j < num_items; j++) {
					items[j] = items[j+1];
				}
				
				items[num_items-1] = null ; 
				num_items-- ;
			}
		}
        System.out.println("The disc has been subed" );
	}
    
}