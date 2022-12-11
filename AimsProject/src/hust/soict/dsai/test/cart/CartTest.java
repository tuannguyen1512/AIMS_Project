package hust.soict.dsai.test.cart;
import hust.soict.dsai.aims.cart.Cart.Cart;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import java.util.*;
public class CartTest {
public static void main(String[] args) {
	Cart cart = new Cart();
	
	List<DigitalVideoDisc> dvds = new ArrayList<DigitalVideoDisc>();
    DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation",  19.95f);
    DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction",  24.95f);
    DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladdin", "Animation", 18.99f);

    // Add DVD objects to ArrayList
    dvds.add(dvd2);
    dvds.add(dvd1);
    dvds.add(dvd3);
	
	cart.cartPrint();
}
}
