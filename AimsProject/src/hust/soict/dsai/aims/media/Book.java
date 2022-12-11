package hust.soict.dsai.aims.media;

import java.util.*;

public class Book extends Media {

    private List<String> authors = new ArrayList<String>();

    public Book(){
    }

    public Book(String title){
        super(title);
    }

    public Book(String title, String category){
        super(title, category);
    }

    public Book(String title, String category, List<String> authors){
        super(title, category);
        this.authors = authors;
    }

    public void addAuthor(String authorName){
        int check = 0;
        for (String i : authors)
            if (i.equals(authorName))
                check++;
        if (check == 0){
            authors.add(authorName);
            System.out.println("Author added successfully!");
        }
        else
            System.out.println("The author is already in the list.");
    }

    public void removeAuthor(String authorName){
        int check = -1;
        for (int i = 0; i < authors.size(); i++) {
            if (authors.get(i).equals(authorName))
                check = i;
        }
        if (check == -1)
            System.out.println("The author is not in the list.");
        else{
            authors.remove(check);
            System.out.println("Author removed successfully!");
        }
    }
}
