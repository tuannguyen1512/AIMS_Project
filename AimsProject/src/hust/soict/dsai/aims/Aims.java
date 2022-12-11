package hust.soict.dsai.aims;
import java.util.Scanner;
import java.util.ArrayList;

import hust.soict.dsai.aims.media.*;
import hust.soict.dsai.aims.cart.Cart.Cart;
import hust.soict.dsai.aims.media.DigitalVideoDisc;

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
//		
//	}
	public static void main(String[] args) {
		showMenu();
	}
	
	public static void showMenu() {

		ArrayList<Cart> userOrder = new ArrayList<Cart>();
		int choice;
		do{
			System.out.println("Order Management Application: ");
			System.out.println("--------------------------------");
			System.out.println("1. Create new order");
			System.out.println("2. Add item to the order");
			System.out.println("3. Delete item by id");
			System.out.println("4. Display the items list of order");
			System.out.println("0. Exit");
			System.out.println("--------------------------------");
			System.out.println("Please choose a number: 0-1-2-3-4");
	
			Scanner sc = new Scanner(System.in);
			choice = sc.nextInt();
		switch (choice){
			case 1:
		        Cart newOrder = new Cart();
				userOrder.add(newOrder);
				System.out.println("There's a new order with the id: " + newOrder.id);
				break;
			case 2:
				System.out.println("Input the id of the order you want to add items to: ");
				sc = new Scanner(System.in);
				int inputId = sc.nextInt();
				int search = orderSearch(inputId, userOrder);
				if(search == -1){
					System.out.println("Wrong order id!");
					break;
				}

				System.out.println("Input the number of the items you want to add: ");
				sc = new Scanner(System.in);
				int inputNum = sc.nextInt();
				for (int i = 0; i < inputNum; i++) {
					Media newMedia = new Media();
					System.out.println("Enter title: ");
					sc = new Scanner(System.in);
					String title = sc.nextLine();
					System.out.println("Enter category: ");
					sc = new Scanner(System.in);
					String category = sc.nextLine();
					System.out.println("Enter cost: ");
					sc = new Scanner(System.in);
					float cost = sc.nextFloat();
					newMedia.setTitle(title);
					newMedia.setCategory(category);
					newMedia.setCost(cost);
					userOrder.get(search).addMedia(newMedia);
				}
				break;
		

			case 3:
				System.out.println("Input the id of the order you want to delete item from: ");
				sc = new Scanner(System.in);
				int orderInputId = sc.nextInt();
				int orderSearch = orderSearch(orderInputId, userOrder);
				if(orderSearch == -1){
					System.out.println("Wrong order id!");
					break;
				}

				System.out.println("Input the id of the item you want to delete: ");
				sc = new Scanner(System.in);
				int itemId = sc.nextInt();
				userOrder.get(orderSearch).removeMedia(itemId);
				break;

		

			case 4:
				System.out.println("Input the id of the order you want to display: ");
				sc = new Scanner(System.in);
				inputId = sc.nextInt();
				search = orderSearch(inputId, userOrder);
				if(search == -1){
					System.out.println("Wrong order id!");
					break;
				}
				userOrder.get(search).cartPrint();
				break;
		

			case 0:
			System.exit(0);
			return;

		}
		}while (choice != 0);	
	}

	public static int orderSearch(int id, ArrayList<Cart> userOrder){
		for (int i = 0; i < userOrder.size(); i++) {
            if (userOrder.get(i).id == id)
                return i;
        }
		return -1;
	}
}
