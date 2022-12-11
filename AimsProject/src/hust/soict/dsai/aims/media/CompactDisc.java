package hust.soict.dsai.aims.media;
import java.util.ArrayList;

public class CompactDisc extends Disc implements Playable {
    private String artist;
    private ArrayList<Track> tracks = new ArrayList<Track>();

    public CompactDisc(){
        super();
    }

    public CompactDisc(String title){
		super(title);
	}

	public CompactDisc(String title, String category){
		super(title, category);
	}

    public CompactDisc(String title, String category, float cost){
        super(title, category, cost);
    }

    public CompactDisc(String title, String category, String artist, ArrayList<Track> tracks, float cost) {
        super(title, category, "", 0, cost);
        this.artist = artist;
        this.tracks = tracks;
    }

    public String getArtist(){
        return this.artist;
    }

    public void addTrack(Track inputTrack){
        if (tracks.contains(inputTrack)){
            System.out.println("The input track is already in the list of tracks.");
        }
        else{
            tracks.add(inputTrack);
        }
    }

    public void removeTrack(Track inputTrack){
        if (tracks.contains(inputTrack)){
            tracks.remove(inputTrack);
        }
        else
            System.out.println("The input track is not in the list of tracks.");
    }
    
    public int getLength(){
        int totalLength = 0;
        for (Track i:tracks){
            totalLength += i.getLength(); 
        }
        return totalLength;
    }
    
    public void play(){
        System.out.println("Playing CD: " + this.getTitle());
        System.out.println("Artist: " + this.getArtist());
		System.out.println("CD length: " + this.getLength());

        for (Track i:tracks){
            i.play();
        }
	}
    
    public int compareTo(Object obj) {
        CompactDisc other = (CompactDisc) obj;
        if (tracks.size() != other.tracks.size())
            return tracks.size() - other.tracks.size();
        
        return getLength() - other.getLength();
    }
}
