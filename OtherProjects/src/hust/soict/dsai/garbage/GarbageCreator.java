package hust.soict.dsai.garbage;
import java.io.File;
import java.util.*;

public class GarbageCreator {
    public static void main(String[] args) throws Exception {
        File file = new File("garbage.txt");
        Scanner sc = new Scanner(file);

        long start = System.currentTimeMillis();
        String s = "";
        while (sc.hasNextLine())
            s += sc.nextLine();
        System.out.println(s);
        System.out.println(System.currentTimeMillis() - start);
        sc.close();
    }
}
