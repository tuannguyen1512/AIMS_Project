package hust.soict.dsai.aims.media;

public class Track implements Playable {
	private String title;
    private int length;

    public Track(String title, int length){
        this.title = title;
        this.length = length;
    }

    public String getTitle(){
        return this.title;
    }

    public int getLength(){
        return this.length;
    }
    
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Track other = (Track) obj;
        if (length != other.length)
            return false;
        if (title == null) {
            if (other.title != null)
                return false;
        } else if (!title.equals(other.title))
            return false;
        return true;
    }

    public void play() {
    	System.out.println("Playing DVD: " + this.getTitle());
    	System.out.println("DVD length: " + this.getLength());
    }
}
