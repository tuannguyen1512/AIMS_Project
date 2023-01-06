package hust.soict.dsai.aims.store;
import java.util.ArrayList;

import hust.soict.dsai.aims.media.Media;

public class Store {
    public static int MAX_NUMBERS_ITEMS = 200 ;
    private ArrayList<Media> itemsInStore = new ArrayList<Media>();
    public void addMedia(Media media){
		if (itemsInStore.size() == MAX_NUMBERS_ITEMS){
			System.out.println("Your order is already full.");
			return;
		}
		else{
			media.setId(itemsInStore.size() + 1);
			itemsInStore.add(media);
			System.out.println("Order has been updated. Your order now has "+ itemsInStore.size() + " items");
		}
	}
	public void removeMedia(int id){
		if (itemsInStore.size() == 0){
			System.out.println("Your order has no items to be removed.");
			return;
		}
		int search = -1;
		for (int i = 0; i < itemsInStore.size(); i++) {
            if (itemsInStore.get(i).getId() == id)
                search = i;
        }
        if (search == -1)
            System.out.println("The media is not in the list.");
        else{
        	itemsInStore.remove(search);
			for (int i = search; i < itemsInStore.size(); i++) {
				itemsInStore.get(i).setId(i+1);
			}
            System.out.println("Media removed successfully!");
        }
	}

	
	public void removeMedia(Media media){
		if (itemsInStore.size() == 0){
			System.out.println("Your order has no items to be removed.");
			return;
		}
		int search = -1;
		for (int i = 0; i < itemsInStore.size(); i++) {
            if (itemsInStore.get(i).getTitle().equals(media.getTitle()))
                search = i;
        }
        if (search == -1)
            System.out.println("The media is not in the list.");
        else{
        	itemsInStore.remove(search);
			for (int i = search; i < itemsInStore.size(); i++) {
				itemsInStore.get(i).setId(i+1);
			}
            System.out.println("Media removed successfully!");
        }
        System.out.println("The disc has been subed");
	}
	
	public void printStore() {
        System.out.println("Store");
        for (Media media : itemsInStore) {
            System.out.println(media.toString());
        }
    }

    public Media searchStore(String st) {
        for (Media media : itemsInStore) {
            if (media.isMatch(st)) {
                return media;
            }
        }
        return null;
    }
}
    
    