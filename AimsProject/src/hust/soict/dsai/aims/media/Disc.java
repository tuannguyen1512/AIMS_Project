package hust.soict.dsai.aims.media;

public class Disc extends Media{
    private int length;
    private String director;

    public int getLength(){
        return this.length;
    }
    public String getDirector(){
        return this.director;
    }

    public Disc(){
        super();
    }

    public Disc(String title){
        super(title);
    }

    public Disc(String title, String category){
        super(title, category);
    }

    public Disc(String title, String category, float cost){
        super(title, category, cost);
    }

    public Disc(String title, String category, String director, int length, float cost) {
        super(title, category, cost);
        this.director = director;
        this.length = length;
    }
}
