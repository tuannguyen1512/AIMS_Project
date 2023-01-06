package hust.soict.dsai.aims;
import java.util.Scanner;
import java.util.ArrayList;

import hust.soict.dsai.aims.media.*;
import hust.soict.dsai.aims.store.Store;
import hust.soict.dsai.aims.cart.Cart.Cart;

public class Aims {
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		Cart anOrder = new Cart() ;
//		
//		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
//		anOrder.addMedia(dvd1);
//		
//		DigitalVideoDisc dvd2 = new DigitalVideoDisc();
//		anOrder.addMedia(dvd2);
//		
//		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", "Geogre Lucas", 87, 18.99f);
//		anOrder.addMedia(dvd3);
//		
//		System.out.println("total Cost is: ");
//		System.out.println(anOrder.totalCost());	
//	}
	public static void main(String[] args) {
		showMenu();
	}
	
	public static void showMenu() {

		ArrayList<Cart> userOrder = new ArrayList<Cart>();
		int choice;
		do{
			System.out.println("AIMS: ");
			System.out.println("--------------------------------");
			System.out.println("1. View store");
			System.out.println("2. Update store");
			System.out.println("3. See current cart");
			System.out.println("0. Exit");
			System.out.println("--------------------------------");
			System.out.println("Please choose a number: 0-1-2-3");
	
			Scanner sc = new Scanner(System.in);
			choice = sc.nextInt();
			Cart cart = new Cart();
	        Store store = new Store();
		switch (choice){
			case 1:
				 viewStore(store, cart);
				break;
			case 2:
				updateStore(store);
				break;
			case 3:
				cart.cartPrint();
                handleCartMenu(cart);		
                break;
			case 0:
			    break;
		}
		}while (choice != 0);	
	}
	
	public static void storeMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. See a media's details");
        System.out.println("2. Add a media to cart");
        System.out.println("3. Play a media");
        System.out.println("4. See current cart");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3-4");
    }
	
	 public static void mediaDetailsMenu() {
	    System.out.println("Options: ");
	    System.out.println("--------------------------------");
	    System.out.println("1. Add to cart");
	    System.out.println("2. Play");
		System.out.println("0. Back");
	    System.out.println("--------------------------------");
	    System.out.println("Please choose a number: 0-1-2");
	}
	 
	 public static void cartMenu() {
	    System.out.println("Options: ");
	    System.out.println("--------------------------------");
	    System.out.println("1. Filter medias in cart");
	    System.out.println("2. Sort medias in cart");
	    System.out.println("3. Remove media from cart");
	    System.out.println("4. Play a media");
	    System.out.println("5. Place order");
	    System.out.println("0. Back");
	    System.out.println("--------------------------------");
	    System.out.println("Please choose a number: 0-1-2-3-4-5");
	}
	
	private static void viewStore(Store store, Cart cart) {
        store.printStore();
        while (true) {
            storeMenu();
            Scanner input = new Scanner(System.in);
            int choice = input.nextInt();
            if (choice == 1) {
            	System.out.print("Enter title of media: ");
                input.nextLine();
                String st = input.nextLine();
                Media res = store.searchStore(st);
                if (res != null) {
                    System.out.println(res.toString());
                    mediaDetailsMenu();
                    handleDetailsMenu(res, cart);
                } else {
                    System.out.println("Not found");
                }
            }
            if (choice == 2) {
            	System.out.print("Enter title of media: ");
                input.nextLine();
                String st = input.nextLine();
                Media res = store.searchStore(st);
                if (res != null && cart.addMedia(res)) {
                    System.out.println("Add " + res.getTitle() + " to cart");
                    System.out.println("Current cart have " + cart.getQty() + " medias");
                } else {
                    System.out.println("Not found");
                }
            }
            if (choice == 3) {
            	System.out.print("Enter title of media: ");
                input.nextLine();
                String st = input.nextLine();
                Media res = store.searchStore(st);
                if (res != null) {
                    res.play();
                } else {
                    System.out.println("Not found");
                }
            }
            if (choice == 4) {
            	cart.cartPrint();
            }
            if (choice == 0) {
            	System.out.println("Exit Store view");
                break;
            }
        }
	}
	
	public static void handleDetailsMenu(Media res, Cart cart) {
        Scanner input = new Scanner(System.in);
        int choice = input.nextInt();
        if (choice == 1) {
            if (cart.addMedia(res)) {
                System.out.println("Add " + res.getTitle() + " to cart");
            }
        }
        if (choice == 2) {
            res.play();
        }
        if (choice == 0) {
            System.out.println("Exit media details view");
        }
    }
	private static void handleCartMenu(Cart cart) {
        while (true) {
            cartMenu();
            Scanner input = new Scanner(System.in);
            int choice = input.nextInt();
            if (choice == 1) { 
                System.out.print("Filter medias in cart by id/title ? (0:1): ");
                int option1 = input.nextInt();
                if (option1 == 1) {
                    System.out.print("Enter title: ");
                    input.nextLine();
                    String st = input.nextLine();
                    cart.filterByTitle(st);
                } else {
                }
            }
            if (choice == 2) {
                System.out.print("Sort medias in cart by title/cost ? (0:1): ");
                int option2 = input.nextInt();
                if (option2 == 1) {
                    cart.sortCartByCost();
                    cart.cartPrint();
                } else {
                    cart.sortCartByTitle();
                    cart.cartPrint();
                }
            }
            if (choice == 3) {
                System.out.print("Enter title of media: ");
                input.nextLine();
                String st = input.nextLine();
                Media res = cart.searchCart(st);
                if (res != null) {
                    cart.removeMedia(res);
                    System.out.println("Deleted " + res.getTitle());
                    cart.cartPrint();
                } else {
                    System.out.println("Not found");
                }
            }
            if (choice == 4) {
                System.out.print("Enter title of media: ");
                input.nextLine();
                String st4 = input.nextLine();
                Media res4 = cart.searchCart(st4);
                if (res4 != null) {
                    res4.play();
                } else {
                    System.out.println("Not found");
                }
            }
            if (choice == 5) { 
                System.out.println("An order is created!");
                cart.newCart();
            }
            if (choice == 0) {
                System.out.println("Exit cart view");
                break;
            }
        }
    }
	
	private static void updateStore(Store store) {
        System.out.println("Delete a media from store");
        System.out.print("Enter title of media: ");
        Scanner input = new Scanner(System.in);
        String st = input.nextLine();
        Media res = store.searchStore(st);
        if (res != null) {
            store.removeMedia(res);
            System.out.println("Deleted " + res.getTitle());
        } else {
            System.out.println("Not found");
        }

    }
}
