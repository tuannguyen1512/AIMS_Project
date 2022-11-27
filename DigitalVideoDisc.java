package hust.soict.dsai.aims.disc;

public class DigitalVideoDisc {
	
	public DigitalVideoDisc(String title, String category, String director, float cost) {
		super();
		this.title = title;
		this.category = category;
		this.director = director;
		this.cost = cost;
		this.id = nbDigitalVideoDiscs ; nbDigitalVideoDiscs++ ;
	}
	public DigitalVideoDisc(String title, String category, float cost) {
		super();
		this.title = title;
		this.category = category;
		this.cost = cost;
		this.id = nbDigitalVideoDiscs ; nbDigitalVideoDiscs++ ;
	}
	public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
		super();
		this.title = title;
		this.category = category;
		this.director = director;
		this.length = length;
		this.cost = cost;
		this.id = nbDigitalVideoDiscs ; nbDigitalVideoDiscs++ ; 
	}
	public DigitalVideoDisc(String title) {
		super();
		this.title = title;
		this.id = nbDigitalVideoDiscs ; 
		this.id = nbDigitalVideoDiscs ; nbDigitalVideoDiscs++ ; 
	}
	private String title ; 
	private String category ; 
	private String director ; 
	private int length ; private int id ; 
	private float cost ;
	private static int nbDigitalVideoDiscs = 0;
	

	public int getId(){
		return id ;
	}

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	public float getCost() {
		return cost;
	}
	public void setCost(float cost) {
		this.cost = cost;
	} 

	@Override
	public String toString(){
		return "DVD - " + this.title + " - " + this.category + " - " + this.director + " - " +this.length + ": " + this.cost + " $";

	}
}