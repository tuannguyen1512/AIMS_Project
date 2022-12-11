package hust.soict.dsai.aims.cart.Cart;
import java.util.ArrayList;

import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;

public class Cart {
	public static int MAX_NUMBERS_ORDERED = 10 ;
	private ArrayList<Media> itemsOrdered = new ArrayList<Media>();
	
	private int nbLuckyItems = 0;
	public int id;
	public void addMedia(Media media){
		if (itemsOrdered.size() == MAX_NUMBERS_ORDERED){
			System.out.println("Your order is already full.");
			return;
		}
		else{
			media.setId(itemsOrdered.size() + 1);
			itemsOrdered.add(media);
			System.out.println("Order has been updated. Your order now has "+ itemsOrdered.size() + " items");
		}
	}
	public void removeMedia(int id){
		if (itemsOrdered.size() == 0){
			System.out.println("Your order has no items to be removed.");
			return;
		}
		int search = -1;
		for (int i = 0; i < itemsOrdered.size(); i++) {
            if (itemsOrdered.get(i).getId() == id)
                search = i;
        }
        if (search == -1)
            System.out.println("The media is not in the list.");
        else{
            itemsOrdered.remove(search);
			for (int i = search; i < itemsOrdered.size(); i++) {
				itemsOrdered.get(i).setId(i+1);
			}
            System.out.println("Media removed successfully!");
        }
	}

	
	public void removeMedia(Media media){
		if (itemsOrdered.size() == 0){
			System.out.println("Your order has no items to be removed.");
			return;
		}
		int search = -1;
		for (int i = 0; i < itemsOrdered.size(); i++) {
            if (itemsOrdered.get(i).getTitle().equals(media.getTitle()))
                search = i;
        }
        if (search == -1)
            System.out.println("The media is not in the list.");
        else{
            itemsOrdered.remove(search);
			for (int i = search; i < itemsOrdered.size(); i++) {
				itemsOrdered.get(i).setId(i+1);
			}
            System.out.println("Media removed successfully!");
        }
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
	
	public Media getALuckyItem(){
		int lucky = (int) (Math.random() * itemsOrdered.size());
		return itemsOrdered.get(lucky);
	}
	
}
	
	
	

