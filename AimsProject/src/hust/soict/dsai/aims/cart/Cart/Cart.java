package hust.soict.dsai.aims.cart.Cart;
import java.util.ArrayList;

import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Cart {
	public static int MAX_NUMBERS_ORDERED = 10 ;
	private ObservableList<Media> itemsOrdered = FXCollections.observableArrayList();
	
	private int nbLuckyItems = 0;
	public int id;
	public boolean addMedia(Media media) {
        if (itemsOrdered.contains(media)) {
            System.out.println("The media is already exist");
            return false;
        }
        itemsOrdered.add(media);
        return true;
    }
	public boolean removeMedia(Media media) {
        if (itemsOrdered.contains(media)) {
            itemsOrdered.remove(media);
            return true;
        }
        System.out.println("The media is not exist");
        return false;
    }
	public ObservableList<Media> getOrder(){
		return itemsOrdered;
	}
	
	public float totalCost() {
		float sum = 0;
		Media FreeMedia = this.getALuckyItem();
		for (int i = 0; i < itemsOrdered.size(); i++) {
			if (itemsOrdered.get(i).equals(FreeMedia))
				System.out.println("Your free item: " + itemsOrdered.get(i).getTitle());
			else
				sum += itemsOrdered.get(i).getCost();
		}
		return sum;
	}
	
	public void cartPrint(){
		if(itemsOrdered.size() == 0){
			System.out.println("There's no items in the order to display!");
			return;
		}
		System.out.println("***********************Cart***********************");
		System.out.println("Ordered Items:");
		for (int i = 0; i < itemsOrdered.size(); i++) {
			System.out.println(itemsOrdered.get(i).getId() + ". Item - " + itemsOrdered.get(i).getTitle() + " - " + itemsOrdered.get(i).getCategory() + ": " + itemsOrdered.get(i).getCost() + "$");
		}
		System.out.println("Total cost: " + this.totalCost());
		System.out.println("***************************************************");
	}
	 public int getQty() {
	        return itemsOrdered.size();
	    }

	 public void sortCartByTitle() {
	        itemsOrdered.sort(Media.COMPARE_BY_TITLE_COST);
	    }

	    public void sortCartByCost() {
	        itemsOrdered.sort(Media.COMPARE_BY_COST_TITLE);
	    }

	 public void filterByTitle(String st) {
	        for (Media media : itemsOrdered) {
	            if (media.isMatch(st)) {
	                System.out.println(media.toString());
	            }
	        }
	    }

	    public Media searchCart(String st) {
	        for (Media media : itemsOrdered) {
	            if (media.isMatch(st)) {
	                return media;
	            }
	        }
	        return null;
	    }

	    public void newCart() {
	        // remove all items in itemsOrderd;
	        itemsOrdered.clear();

	    }

	public Media getALuckyItem(){
		int lucky = (int) (Math.random() * itemsOrdered.size());
		return itemsOrdered.get(lucky);
	}
	
	public void clearCart() {
		itemsOrdered.clear();
	}
	
}
	
	
	

