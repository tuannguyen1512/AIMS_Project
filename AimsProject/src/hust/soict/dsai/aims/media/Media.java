package hust.soict.dsai.aims.media;

import java.util.Comparator;

import hust.soict.dsai.aims.utils.MediaComparatorByCostTitle;
import hust.soict.dsai.aims.utils.MediaComparatorByTitleCost;

public abstract class Media {
	public int id;
    private String title;
    private String category;
    private float cost;

    public static final Comparator<Media> COMPARE_BY_TITLE_COST = new MediaComparatorByTitleCost();
    public static final Comparator<Media> COMPARE_BY_COST_TITLE = new MediaComparatorByCostTitle();

    public Media(){

    }

	public Media(String title){
		this.title = title;
	}

	public Media(String title, String category){
		this(title);
		this.category = category;
	}
	
	public Media(String title, String category, float cost){
		this.title = title;
		this.category = category;
		this.cost = cost;
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
    public float getCost() {
		return cost;
	}
	public void setCost(float cost) {
		this.cost = cost;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Override
    public String toString() {
        return getTitle() + " - " + getCategory() + ": " + getCost() + "$";
    }

	@Override
	public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Media other = (Media) obj;
        if (Float.floatToIntBits(cost) != Float.floatToIntBits(other.cost))
            return false;
        return true;
    }
	
	public boolean isMatch(String st) {
        if (this.title.equals(st))
            return true;
        return false;
    }
	public abstract void play();

}
