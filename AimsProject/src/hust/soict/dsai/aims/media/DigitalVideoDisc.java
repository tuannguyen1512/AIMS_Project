package hust.soict.dsai.aims.media;
public class DigitalVideoDisc extends Disc implements Playable{
	
	public DigitalVideoDisc(){
		super();
	}

	public DigitalVideoDisc(String title){
        super(title);
    }

    public DigitalVideoDisc(String title, String category){
        super(title, category);
    }

	public DigitalVideoDisc(String title, String category, float cost){
        super(title, category, cost);
    }
	
	public void play(){
		System.out.println("Playing DVD: " + this.getTitle());
		System.out.println("DVD length: " + this.getLength());
	}
	
	public int compareTo(Object obj) {
        Media other = (DigitalVideoDisc) obj;
        if (getCost() < other.getCost())
            return -1;
        if (getCost() > other.getCost())
            return 1;
        return 0;
    }
}
